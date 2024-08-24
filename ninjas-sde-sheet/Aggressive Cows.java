
import java.util.*;

/**
 * This class provides a solution to the Aggressive Cows problem. The problem
 * involves placing K cows in N stalls such that the minimum distance between
 * any two cows is maximized.
 */
class Solution {

    /**
     * Checks if it's possible to place K cows with a minimum distance of 'mid'
     * between them.
     *
     * @param arr The sorted array of stall positions
     * @param n The number of stalls
     * @param k The number of cows to be placed
     * @param mid The minimum distance to be checked
     * @return true if it's feasible to place cows with 'mid' distance, false
     * otherwise
     */
    public static boolean isFeasible(int[] arr, int n, int k, int mid) {
        int count = 1;  // We place the first cow in the first stall
        int last_position = arr[0];  // The position of the first cow

        for (int i = 1; i < n; i++) {
            if (arr[i] - last_position >= mid) {
                // Place the cow at arr[i] since the distance is at least 'mid'
                count++;
                last_position = arr[i];
            }
            if (count >= k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the largest minimum distance at which K cows can be placed in N
     * stalls.
     *
     * @param arr The array of stall positions
     * @param n The number of stalls
     * @param k The number of cows to be placed
     * @return The largest minimum distance between cows
     */
    public static int aggressiveCows(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int low = 1;  // Minimum possible distance
        int high = arr[n - 1] - arr[0];  // Maximum possible distance
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isFeasible(arr, n, k, mid)) {
                result = mid;  // Update result because mid is feasible
                low = mid + 1;  // Try for a larger distance
            } else {
                high = mid - 1;  // Try for a smaller distance
            }
        }

        return result;
    }

    /**
     * The main method that handles input/output and calls the solution method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of stalls
        int k = sc.nextInt();  // Number of cows
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // Positions of the stalls
        }

        System.out.println(aggressiveCows(arr, n, k));
    }
}
