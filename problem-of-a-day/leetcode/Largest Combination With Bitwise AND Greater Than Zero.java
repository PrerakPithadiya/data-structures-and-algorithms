package LeetCode;

/**
 * Solution for Largest Combination With Bitwise AND Greater Than Zero
 *
 * Problem: Given an array of integers, find the size of the largest combination
 * of numbers where the bitwise AND of all numbers is greater than zero.
 *
 * Approach: 1. For each bit position (0-23), count how many numbers have that
 * bit set to 1 2. The maximum count across all bit positions is our answer 3.
 * This works because if k numbers share a 1 bit at any position, their AND will
 * be > 0
 *
 * Time Complexity: O(n * 24) where n is the length of candidates array Space
 * Complexity: O(1)
 */
class Solution {

    public int largestCombination(int[] candidates) {
        int maxCount = 0;

        // Iterate over all bit positions from 0 to 24 (since 10^7 is less than 2^24)
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            for (int num : candidates) {
                // Check if the bit at position 'bit' is set
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            // Update the maximum count
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] test1 = {16, 17, 71, 62, 12, 24, 14};
        assert solution.largestCombination(test1) == 4 : "Test case 1 failed";

        // Test Case 2: All numbers have common bit
        int[] test2 = {8, 8, 8, 8, 8};
        assert solution.largestCombination(test2) == 5 : "Test case 2 failed";

        // Test Case 3: No common bits
        int[] test3 = {1, 2, 4, 8, 16};
        assert solution.largestCombination(test3) == 1 : "Test case 3 failed";

        // Test Case 4: Empty array
        int[] test4 = {};
        assert solution.largestCombination(test4) == 0 : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
