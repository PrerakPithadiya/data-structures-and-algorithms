
import java.util.Arrays;

/**
 * Solution for LeetCode problem: Maximum Beauty of an Array After Applying
 * Operation
 *
 * Problem Description: You are given a 0-indexed array nums and a non-negative
 * integer k. In one operation, you can do the following: - Choose an index i
 * and change nums[i] to any integer x where nums[i] - k <= x <= nums[i] + k The
 * beauty of the array is the length of the longest subsequence consisting of
 * equal elements. Return the maximum possible beauty of the array after
 * applying the operation any number of times.
 *
 * Approach: 1. Sort the array to group similar numbers together 2. Use sliding
 * window technique to find the longest subsequence that can be made equal: -
 * Window contains elements that can be made equal through operations - For any
 * two elements to be made equal, their difference should not exceed 2*k
 *
 * Time Complexity: O(n log n) due to sorting Space Complexity: O(1) as we only
 * use constant extra space
 */
class Solution {

    /**
     * Calculates the maximum possible beauty of the array after applying
     * operations.
     *
     * @param nums The input array of integers
     * @param k The maximum change allowed for each element
     * @return The maximum possible beauty (length of longest equal subsequence)
     */
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);

        int maxBeauty = 0;
        int start = 0; // Start of the sliding window

        for (int end = 0; end < nums.length; end++) {
            // Ensure the difference between nums[end] and nums[start] is within 2 * k
            while (nums[end] - nums[start] > 2 * k) {
                start++;
            }
            // Update maximum beauty (window size)
            maxBeauty = Math.max(maxBeauty, end - start + 1);
        }

        return maxBeauty;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.maximumBeauty(new int[]{4, 6, 1, 2}, 2) == 3 : "Test case 1 failed";

        // Test Case 2: All elements can be made equal
        assert solution.maximumBeauty(new int[]{1, 1, 1, 1}, 1) == 4 : "Test case 2 failed";

        // Test Case 3: Single element
        assert solution.maximumBeauty(new int[]{5}, 5) == 1 : "Test case 3 failed";

        // Test Case 4: Large differences
        assert solution.maximumBeauty(new int[]{1, 10, 20, 30}, 1) == 1 : "Test case 4 failed";

        // Test Case 5: Elements at array bounds
        assert solution.maximumBeauty(new int[]{999, 999, 999, 1000}, 1) == 4 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }

}
