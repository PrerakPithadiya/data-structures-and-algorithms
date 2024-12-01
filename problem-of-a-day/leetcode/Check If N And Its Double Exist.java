
import java.util.HashSet;

/**
 * Solution class to check if there exists two elements in an array such that
 * one is double of another
 */
class Solution {

    /**
     * Checks if there exists two elements arr[i] and arr[j] such that arr[i] =
     * 2 * arr[j]
     *
     * @param arr input array of integers
     * @return true if there exists two elements where one is double of another,
     * false otherwise
     */
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            // Check if double of current number exists in the set
            if (seen.contains(num * 2) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            // Add the current number to the set
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array with doubles
        int[] arr1 = {10, 2, 5, 3};
        System.out.println("Test Case 1: " + solution.checkIfExist(arr1)); // Expected: true (10 = 2 * 5)

        // Test Case 2: Array with no doubles
        int[] arr2 = {3, 1, 7, 11};
        System.out.println("Test Case 2: " + solution.checkIfExist(arr2)); // Expected: false

        // Test Case 3: Array with zeros
        int[] arr3 = {0, 0};
        System.out.println("Test Case 3: " + solution.checkIfExist(arr3)); // Expected: true (0 * 2 = 0)

        // Test Case 4: Array with negative numbers
        int[] arr4 = {-2, 0, 10, -19, 4, 6, -8};
        System.out.println("Test Case 4: " + solution.checkIfExist(arr4)); // Expected: false
    }

}
