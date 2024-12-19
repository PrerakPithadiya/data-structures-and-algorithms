
/**
 * Solution for LeetCode problem: Max Chunks To Make Sorted
 *
 * Problem Description:
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some
 * number of "chunks" (partitions), and individually sort each chunk. After concatenating them, the result
 * equals the sorted array. What is the most number of chunks we could have made?
 *
 * Approach:
 * 1. Keep track of the maximum value seen so far in the current chunk
 * 2. For each position i, if the maximum value seen equals i, we can form a valid chunk
 * 3. This works because:
 *    - Each number from 0 to n-1 must be present exactly once
 *    - If max_so_far equals current index, all previous numbers must be less than or equal to i
 *
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Calculates the maximum number of chunks possible to make the array sorted
     *
     * @param arr input array containing permutation of [0, 1, ..., arr.length -
     * 1]
     * @return maximum number of possible chunks
     */
    public int maxChunksToSorted(int[] arr) {
        int max_so_far = 0;
        int chunks = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the maximum value seen so far
            max_so_far = Math.max(max_so_far, arr[i]);

            // Check if the current segment can form a valid chunk
            if (max_so_far == i) {
                chunks++;
            }
        }

        return chunks;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}) == 1 : "Test case 1 failed";

        // Test Case 2: Already sorted array
        assert solution.maxChunksToSorted(new int[]{0, 1, 2, 3, 4}) == 5 : "Test case 2 failed";

        // Test Case 3: Mixed case
        assert solution.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}) == 4 : "Test case 3 failed";

        // Test Case 4: Single element array
        assert solution.maxChunksToSorted(new int[]{0}) == 1 : "Test case 4 failed";

        // Test Case 5: Two elements
        assert solution.maxChunksToSorted(new int[]{1, 0}) == 1 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
