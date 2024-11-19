package LeetCode;

import java.util.*;

/**
 * Solution for finding maximum sum of distinct subarrays with length K Time
 * Complexity: O(n) where n is the length of input array Space Complexity: O(k)
 * where k is the length of sliding window
 */
class Solution {

    /**
     * Finds the maximum sum of a subarray of length k containing distinct
     * elements
     *
     * @param nums Input array of integers
     * @param k Length of subarray to consider
     * @return Maximum sum of any subarray of length k with distinct elements
     */
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the sum and set
            currentSum += nums[right];

            // Ensure the subarray maintains unique elements
            while (uniqueElements.contains(nums[right]) || uniqueElements.size() >= k) {
                currentSum -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }

            // Add the current number to the unique set
            uniqueElements.add(nums[right]);

            // Check if the window size is exactly `k`
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
                // Prepare to move window by removing leftmost element
                currentSum -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with distinct elements
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        assert solution.maximumSubarraySum(nums1, k1) == 15; // [1,5,4] = 10, [5,4,2] = 11, [4,2,9] = 15

        // Test Case 2: Array with duplicates
        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        assert solution.maximumSubarraySum(nums2, k2) == 0; // No valid subarray exists

        // Test Case 3: Minimum length array
        int[] nums3 = {1, 2};
        int k3 = 2;
        assert solution.maximumSubarraySum(nums3, k3) == 3; // [1,2] = 3

        // Test Case 4: Array with negative numbers
        int[] nums4 = {-1, -2, 3, 4};
        int k4 = 2;
        assert solution.maximumSubarraySum(nums4, k4) == 7; // [3,4] = 7

        System.out.println("All test cases passed!");
    }
}
