
/**
 * Solution for LeetCode Problem: Unique Length-3 Palindromic Subsequences
 *
 * Problem Description:
 * Given a string s, return the number of unique length-3 palindromic subsequences in s.
 * A palindromic subsequence is a subsequence of a string that reads the same forwards and backwards.
 *
 * Approach:
 * 1. For each character (potential outer character of palindrome):
 *    - Find its first and last occurrence
 * 2. For each valid outer character:
 *    - Count unique characters between first and last occurrence
 * 3. Each unique middle character forms a palindrome with the outer character
 *
 * Time Complexity: O(n), where n is the length of string s
 * Space Complexity: O(1), as we use fixed size arrays and set
 */
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * Counts the number of unique length-3 palindromic subsequences in the
     * given string.
     *
     * @param s The input string to process
     * @return The number of unique length-3 palindromic subsequences
     */
    public int countPalindromicSubsequence(String s) {
        // Store first and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, Integer.MAX_VALUE);
        Arrays.fill(last, Integer.MIN_VALUE);

        // Find first and last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            first[idx] = Math.min(first[idx], i);
            last[idx] = Math.max(last[idx], i);
        }

        // Count unique palindromes
        int result = 0;

        // For each character as the outer character of palindrome
        for (int i = 0; i < 26; i++) {
            // If this character appears at least twice
            if (first[i] < last[i]) {
                // Use Set to count unique middle characters
                Set<Character> middleChars = new HashSet<>();

                // Check all characters between first and last occurrence
                for (int j = first[i] + 1; j < last[i]; j++) {
                    middleChars.add(s.charAt(j));
                }

                // Add number of unique palindromes with this outer character
                result += middleChars.size();
            }
        }

        return result;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with multiple palindromes
        assert solution.countPalindromicSubsequence("aabca") == 3;  // ["aba", "aaa", "aca"]

        // Test Case 2: Single character repeated
        assert solution.countPalindromicSubsequence("aaa") == 1;    // ["aaa"]

        // Test Case 3: No palindromes possible
        assert solution.countPalindromicSubsequence("abc") == 0;    // []

        // Test Case 4: Complex case with multiple possibilities
        assert solution.countPalindromicSubsequence("bbcbaba") == 4; // ["bbb", "bcb", "bab", "bba"]

        // Test Case 5: Empty string
        assert solution.countPalindromicSubsequence("") == 0;       // []

        System.out.println("All test cases passed!");
    }
}
