package LeetCode;

/**
 * Solution for LeetCode problem: Maximum XOR for Each Query
 *
 * Problem: You are given a sorted array nums of n non-negative integers and an
 * integer maximumBit. You want to perform the following query n times: 1. Find
 * a non-negative integer k < 2^maximumBit such that nums[0] XOR nums[1] XOR ...
 * XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
 * 2. Remove the last element from the current array nums.
 *
 * Time Complexity: O(n) where n is the length of input array Space Complexity:
 * O(n) for the result array
 */
class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int xorAll = 0;
        int maxPossibleValue = (1 << maximumBit) - 1;

        // Calculate the XOR of all elements
        for (int num : nums) {
            xorAll ^= num;
        }

        // Iterate backwards to process queries
        for (int i = 0; i < n; i++) {
            result[i] = xorAll ^ maxPossibleValue;
            xorAll ^= nums[n - 1 - i];
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {0, 1, 1, 3};
        int maximumBit1 = 2;
        int[] result1 = solution.getMaximumXor(nums1, maximumBit1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(result1));  // Expected: [2,3,2,3]

        // Test Case 2
        int[] nums2 = {2, 3, 4, 7};
        int maximumBit2 = 3;
        int[] result2 = solution.getMaximumXor(nums2, maximumBit2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(result2));  // Expected: [5,2,6,5]

        // Test Case 3
        int[] nums3 = {0};
        int maximumBit3 = 1;
        int[] result3 = solution.getMaximumXor(nums3, maximumBit3);
        System.out.println("Test Case 3: " + java.util.Arrays.toString(result3));  // Expected: [1]
    }
}
