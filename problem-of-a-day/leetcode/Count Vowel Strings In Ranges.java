
/**
 * Solution for LeetCode problem: Count Vowel Strings in Ranges
 *
 * Problem Description:
 * Given an array of strings 'words' and a 2D array 'queries', where each query consists of two integers [left, right],
 * count the number of strings in the subarray words[left...right] that start and end with a vowel.
 *
 * Approach:
 * 1. Use prefix sum array to optimize query processing
 * 2. Build prefix sum array where each element represents count of vowel strings up to that index
 * 3. For each query [left, right], calculate result using prefix sum difference
 *
 * Time Complexity: O(n + q) where n is length of words array and q is number of queries
 * Space Complexity: O(n) for prefix sum array
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    /**
     * Processes queries to count vowel strings in given ranges.
     *
     * @param words Array of strings to be processed
     * @param queries 2D array where each query is [left, right] representing
     * range bounds
     * @return Array of integers where each element is the count of vowel
     * strings in the corresponding query range
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Build prefix sum array
        int[] prefixSum = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        // Process queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1] + 1;
            result[i] = prefixSum[right] - prefixSum[left];
        }

        return result;
    }

    /**
     * Checks if a string starts and ends with a vowel.
     *
     * @param word String to be checked
     * @return true if string starts and ends with vowel, false otherwise
     */
    private boolean isVowelString(String word) {
        return !word.isEmpty() && VOWELS.contains(word.charAt(0)) && VOWELS.contains(word.charAt(word.length() - 1));
    }

    /**
     * Test cases for the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        String[] words1 = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries1 = {{0, 2}, {1, 4}, {1, 1}};
        int[] result1 = solution.vowelStrings(words1, queries1);
        assert Arrays.equals(result1, new int[]{2, 3, 0}) : "Test case 1 failed";

        // Test Case 2: Empty strings
        String[] words2 = {"", "a", "", "e"};
        int[][] queries2 = {{0, 3}, {0, 1}};
        int[] result2 = solution.vowelStrings(words2, queries2);
        assert Arrays.equals(result2, new int[]{2, 1}) : "Test case 2 failed";

        // Test Case 3: No vowel strings
        String[] words3 = {"bcd", "xyz"};
        int[][] queries3 = {{0, 1}};
        int[] result3 = solution.vowelStrings(words3, queries3);
        assert Arrays.equals(result3, new int[]{0}) : "Test case 3 failed";

        // Test Case 4: All vowel strings
        String[] words4 = {"ae", "ea", "ei", "ia"};
        int[][] queries4 = {{0, 3}, {1, 2}};
        int[] result4 = solution.vowelStrings(words4, queries4);
        assert Arrays.equals(result4, new int[]{4, 2}) : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
