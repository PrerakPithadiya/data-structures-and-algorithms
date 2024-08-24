
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class provides a solution to the Painter's Partition Problem. The
 * problem involves finding the minimum time needed to paint a set of boards,
 * given a number of painters who can work simultaneously.
 */
class Solution {

    /**
     * Checks if it's feasible for 'k' painters to paint all boards within 'mid'
     * time.
     *
     * @param arr The list of board lengths.
     * @param n The total number of boards.
     * @param k The number of available painters.
     * @param mid The proposed maximum time for any painter.
     * @return true if it's feasible, false otherwise.
     */
    public static boolean isFeasible(ArrayList<Integer> arr, int n, int k, int mid) {
        int paintersCount = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum += arr.get(i);

            if (currentSum > mid) {
                paintersCount++; // Assign the next board to a new painter
                currentSum = arr.get(i); // Start counting pages for the new painter

                if (paintersCount > k) {
                    return false; // More painters are needed than available
                }
            }
        }
        return true;
    }

    /**
     * Finds the minimum time needed to paint all boards using binary search.
     *
     * @param arr The list of board lengths.
     * @param n The total number of boards.
     * @param k The number of available painters.
     * @return The minimum time needed to paint all boards.
     */
    public static int findMinimumTime(ArrayList<Integer> arr, int n, int k) {
        int low = Collections.max(arr); // Largest single board
        int high = arr.stream().mapToInt(Integer::intValue).sum(); // Sum of all boards

        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isFeasible(arr, n, k, mid)) {
                result = mid; // This could be the answer, but let's try for a smaller one
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    /**
     * Main method to run the program. It reads input from the user and prints
     * the minimum time needed to paint all boards.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt(); // Number of boards
            int k = sc.nextInt(); // Number of painters
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt()); // Length of each board
            }

            System.out.println(findMinimumTime(arr, n, k));
        }
    }
}
