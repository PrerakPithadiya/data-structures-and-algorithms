package GFG;

import java.util.HashSet;

/**
 * Solution class to check for duplicates within k distance in an array
 */
class Solution {

    /**
     * Checks if there are any duplicate elements within k distance in the given
     * array
     *
     * @param arr The input array of integers
     * @param k The maximum allowed distance between duplicate elements
     * @return true if duplicates exist within k distance, false otherwise
     */
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // Create a HashSet to keep track of elements in the current window of size k
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If the set contains the current element, return true (duplicate found within k distance)
            if (set.contains(arr[i])) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);

            // Maintain the size of the set to be at most k by removing the element that's outside the window
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        // No duplicates found within k distance
        return false;
    }

    /**
     * Test cases to verify the functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with duplicates within k distance
        int[] arr1 = {1, 2, 3, 1, 4, 5};
        int k1 = 3;
        System.out.println("Test Case 1: " + solution.checkDuplicatesWithinK(arr1, k1)); // Expected: true

        // Test Case 2: No duplicates within k distance
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        System.out.println("Test Case 2: " + solution.checkDuplicatesWithinK(arr2, k2)); // Expected: false

        // Test Case 3: Duplicates exist but not within k distance
        int[] arr3 = {1, 2, 3, 4, 1};
        int k3 = 2;
        System.out.println("Test Case 3: " + solution.checkDuplicatesWithinK(arr3, k3)); // Expected: false

        // Test Case 4: Empty array
        int[] arr4 = {};
        int k4 = 3;
        System.out.println("Test Case 4: " + solution.checkDuplicatesWithinK(arr4, k4)); // Expected: false

        // Test Case 5: Array with single element
        int[] arr5 = {1};
        int k5 = 3;
        System.out.println("Test Case 5: " + solution.checkDuplicatesWithinK(arr5, k5)); // Expected: false
    }
}
