
import java.util.Arrays;

/**
 * Solution class for finding the score of an array after marking elements.
 * LeetCode Problem: Find Score of Array After Marking All Elements
 *
 * Problem Description: You are given an array nums of size n consisting of
 * positive integers. You need to mark elements according to the following
 * rules: 1. Choose the smallest unmarked element in nums and mark it. 2. Mark
 * its left and right adjacent elements if they exist. 3. Repeat until all
 * elements are marked. The score is the sum of all marked elements in the order
 * they were marked.
 *
 * Time Complexity: O(n log n) where n is the length of input array Space
 * Complexity: O(n) for auxiliary arrays
 */
class Solution {

    /**
     * Calculates the score of the array after marking elements according to the
     * rules.
     *
     * @param nums Input array of positive integers
     * @return The final score after marking all elements
     */
    public long findScore(int[] nums) {
        int n = nums.length;
        long score = 0;

        // Create a sorted array of indices based on the values of nums
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i; // Store original indices
        }

        // Sort the indices based on the corresponding values in nums
        // In case of equal values, smaller index comes first
        Arrays.sort(indices, (a, b) -> nums[a] != nums[b] ? nums[a] - nums[b] : a - b);

        // Mark the elements that have been processed
        boolean[] marked = new boolean[n];

        // Process elements in the sorted order
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            if (marked[index]) {
                continue; // Skip if already marked
            }
            // Add value to score
            score += nums[index];

            // Mark the current element and its neighbors
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true; // Mark left neighbor
            }
            if (index < n - 1) {
                marked[index + 1] = true; // Mark right neighbor
            }
        }

        return score;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.findScore(new int[]{2, 1, 3, 4, 5}) == 7 : "Test Case 1 Failed";

        // Test Case 2: Array with duplicate elements
        assert solution.findScore(new int[]{2, 3, 2, 1}) == 4 : "Test Case 2 Failed";

        // Test Case 3: Single element
        assert solution.findScore(new int[]{5}) == 5 : "Test Case 3 Failed";

        // Test Case 4: Two elements
        assert solution.findScore(new int[]{1, 2}) == 3 : "Test Case 4 Failed";

        // Test Case 5: All same elements
        assert solution.findScore(new int[]{1, 1, 1, 1}) == 2 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
