
import java.util.*;

/**
 * This class provides a solution for ranking elements in an array. The ranking
 * is based on the relative order of elements, with the smallest element
 * receiving rank 1, the next smallest receiving rank 2, and so on. Elements
 * with the same value receive the same rank.
 */
class Solution {

    /**
     * Transforms an array by replacing each element with its rank.
     *
     * @param arr The input array to be transformed.
     * @return A new array where each element is replaced by its rank.
     */
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Copy the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Step 2: Create a rank map
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : sortedArr) {
            // Assign rank only if the number is not already ranked
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Step 3: Replace elements in the original array with their rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }

    /**
     * Main method to run test cases for the arrayRankTransform method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Regular case with unique elements
        int[] arr1 = {40, 10, 20, 30};
        int[] result1 = solution.arrayRankTransform(arr1);
        System.out.println("Test case 1: " + Arrays.toString(result1));
        // Expected output: [4, 1, 2, 3]

        // Test case 2: Array with duplicate elements
        int[] arr2 = {100, 100, 100};
        int[] result2 = solution.arrayRankTransform(arr2);
        System.out.println("Test case 2: " + Arrays.toString(result2));
        // Expected output: [1, 1, 1]

        // Test case 3: Array with negative numbers
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        int[] result3 = solution.arrayRankTransform(arr3);
        System.out.println("Test case 3: " + Arrays.toString(result3));
        // Expected output: [5, 3, 4, 2, 8, 6, 7, 1, 3]

        // Test case 4: Empty array
        int[] arr4 = {};
        int[] result4 = solution.arrayRankTransform(arr4);
        System.out.println("Test case 4: " + Arrays.toString(result4));
        // Expected output: []
    }
}
