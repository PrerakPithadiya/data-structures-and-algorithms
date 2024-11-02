package GFG;

// User function Template for Java
import java.util.Arrays;

/**
 * Solution class containing method to maximize sum of absolute differences in a
 * circular arrangement of array elements
 */
class Solution {

    /**
     * Maximizes the sum of absolute differences between adjacent elements by
     * rearranging array elements in a circular manner
     *
     * @param arr Input array of Long elements
     * @return Maximum possible sum of absolute differences
     *
     * Example 1: Input: arr = [4, 2, 1, 8] Output: 18 Explanation: Rearrange as
     * [1, 8, 2, 4] to get |1-8| + |8-2| + |2-4| + |4-1| = 7 + 6 + 2 + 3 = 18
     *
     * Example 2: Input: arr = [1, 2, 3] Output: 4 Explanation: Rearrange as [1,
     * 3, 2] to get |1-3| + |3-2| + |2-1| = 2 + 1 + 1 = 4
     */
    public long maxSum(Long[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array

        int n = arr.length;
        long sum = 0;

        // Create a new array to hold the rearranged elements
        Long[] rearranged = new Long[n];

        // Fill the rearranged array in the required order
        int left = 0; // Pointer for the smallest elements
        int right = n - 1; // Pointer for the largest elements

        // Fill the rearranged array with elements from both ends
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rearranged[i] = arr[left++];
            } else {
                rearranged[i] = arr[right--];
            }
        }

        // Step 3: Calculate the sum of absolute differences
        for (int i = 0; i < n; i++) {
            sum += Math.abs(rearranged[i] - rearranged[(i + 1) % n]); // Circular difference
        }

        return sum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        Long[] arr1 = {4L, 2L, 1L, 8L};
        System.out.println("Test Case 1: " + solution.maxSum(arr1)); // Expected: 18

        // Test Case 2
        Long[] arr2 = {1L, 2L, 3L};
        System.out.println("Test Case 2: " + solution.maxSum(arr2)); // Expected: 4

        // Test Case 3: Array with duplicate elements
        Long[] arr3 = {2L, 2L, 2L, 2L};
        System.out.println("Test Case 3: " + solution.maxSum(arr3)); // Expected: 0

        // Test Case 4: Array with negative elements
        Long[] arr4 = {-1L, -2L, 3L, 4L};
        System.out.println("Test Case 4: " + solution.maxSum(arr4)); // Expected: 18

        // Test Case 5: Single element array
        Long[] arr5 = {1L};
        System.out.println("Test Case 5: " + solution.maxSum(arr5)); // Expected: 0
    }

}
