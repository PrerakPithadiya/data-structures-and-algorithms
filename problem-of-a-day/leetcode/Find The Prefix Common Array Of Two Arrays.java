
/**
 * Solution for LeetCode problem: Find The Prefix Common Array Of Two Arrays
 *
 * Problem Description:
 * Given two arrays A and B of length n, return an array C where C[i] represents the number of elements
 * that are common between the prefix arrays A[0..i] and B[0..i].
 *
 * Approach:
 * 1. Use a frequency array to track occurrences of numbers in both arrays
 * 2. Process both arrays simultaneously and count common elements
 * 3. When a number appears twice in the frequency array, it means it's common between A and B
 *
 * Time Complexity: O(n) where n is the length of input arrays
 * Space Complexity: O(n) for the frequency array and result array
 */
class Solution {

    /**
     * Finds the prefix common array of two given arrays.
     *
     * @param A first input array of integers
     * @param B second input array of integers
     * @return array where each element represents count of common elements in
     * prefixes
     * @throws IllegalArgumentException if input arrays are null or have
     * different lengths
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        if (A.length != B.length) {
            throw new IllegalArgumentException("Input arrays must have equal length");
        }

        int n = A.length;
        int[] result = new int[n];
        // Use an array to track frequency of numbers
        int[] count = new int[n + 1];
        int commonCount = 0;

        // Process both arrays simultaneously
        for (int i = 0; i < n; i++) {
            // Increment count for number from array A
            count[A[i]]++;
            // If this number now appears twice, it's common
            if (count[A[i]] == 2) {
                commonCount++;
            }

            // Increment count for number from array B
            count[B[i]]++;
            // If this number now appears twice, it's common
            if (count[B[i]] == 2) {
                commonCount++;
            }

            // Store the count of common numbers up to index i
            result[i] = commonCount;
        }

        return result;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] test1A = {1, 2, 3};
        int[] test1B = {2, 3, 1};
        assert java.util.Arrays.equals(solution.findThePrefixCommonArray(test1A, test1B),
                new int[]{0, 1, 3}) : "Test Case 1 Failed";

        // Test Case 2: All elements same
        int[] test2A = {1, 1, 1};
        int[] test2B = {1, 1, 1};
        assert java.util.Arrays.equals(solution.findThePrefixCommonArray(test2A, test2B),
                new int[]{1, 2, 3}) : "Test Case 2 Failed";

        // Test Case 3: No common elements
        int[] test3A = {1, 2, 3};
        int[] test3B = {4, 5, 6};
        assert java.util.Arrays.equals(solution.findThePrefixCommonArray(test3A, test3B),
                new int[]{0, 0, 0}) : "Test Case 3 Failed";

        // Test Case 4: Single element
        int[] test4A = {1};
        int[] test4B = {1};
        assert java.util.Arrays.equals(solution.findThePrefixCommonArray(test4A, test4B),
                new int[]{1}) : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
