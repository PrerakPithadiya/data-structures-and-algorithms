package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution for finding the shortest subarray with sum at least K LeetCode
 * Problem 862:
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
 */
class Solution {

    /**
     * Finds the length of the shortest subarray with sum at least K Uses a
     * monotonic deque approach with prefix sums to efficiently find the result
     *
     * @param nums Input array of integers
     * @param k Target sum value
     * @return Length of shortest subarray with sum >= k, or -1 if no such
     * subarray exists Time Complexity: O(n) where n is the length of nums Space
     * Complexity: O(n) for storing prefix sums and deque
     */
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        assert solution.shortestSubarray(nums1, k1) == 2 : "Test case 1 failed";

        // Test Case 2: Negative numbers
        int[] nums2 = {2, -1, 2};
        int k2 = 3;
        assert solution.shortestSubarray(nums2, k2) == 3 : "Test case 2 failed";

        // Test Case 3: No valid subarray
        int[] nums3 = {1, 2};
        int k3 = 4;
        assert solution.shortestSubarray(nums3, k3) == -1 : "Test case 3 failed";

        // Test Case 4: Single element array
        int[] nums4 = {5};
        int k4 = 5;
        assert solution.shortestSubarray(nums4, k4) == 1 : "Test case 4 failed";

        // Test Case 5: Large numbers
        int[] nums5 = {84, -37, 32, 40, 95};
        int k5 = 167;
        assert solution.shortestSubarray(nums5, k5) == 3 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
