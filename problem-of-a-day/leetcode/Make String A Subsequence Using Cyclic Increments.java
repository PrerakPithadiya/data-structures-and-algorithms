
/**
 * Solution for making string a subsequence using cyclic increments.
 *
 * Problem: Given two strings str1 and str2, determine if str2 can be made a subsequence of str1
 * by performing cyclic increments on characters in str1. A cyclic increment means 'a' becomes 'b',
 * 'b' becomes 'c', ..., 'z' becomes 'a'.
 *
 * Time Complexity: O(m) where m is the length of str1
 * Space Complexity: O(1)
 */
class Solution {

    /**
     * Determines if str2 can be made a subsequence of str1 using cyclic
     * increments.
     *
     * @param str1 The source string
     * @param str2 The target subsequence string
     * @return true if str2 can be made a subsequence of str1, false otherwise
     */
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int j = 0; // Pointer for str2

        // Iterate through str1
        for (int i = 0; i < m; i++) {
            // If we have matched all characters in str2, we can return true
            if (j == n) {
                return true;
            }
            // Check if the current character in str1 matches the current character in str2
            if (str1.charAt(i) == str2.charAt(j)) {
                j++; // Move to the next character in str2
            } else if ((str1.charAt(i) - 'a' + 1) % 26 + 'a' == str2.charAt(j)) {
                // Check if we can increment str1[i] to match str2[j]
                j++; // Move to the next character in str2
            }
        }

        // After iterating through str1, check if we matched all characters in str2
        return j == n;
    }

    /**
     * Test cases for the canMakeSubsequence method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.canMakeSubsequence("abc", "ad") == true;

        // Test Case 2: No increments needed
        assert solution.canMakeSubsequence("abcd", "ac") == true;

        // Test Case 3: Impossible case
        assert solution.canMakeSubsequence("ab", "d") == false;

        // Test Case 4: Empty str2
        assert solution.canMakeSubsequence("abc", "") == true;

        // Test Case 5: str2 longer than str1
        assert solution.canMakeSubsequence("a", "ab") == false;

        // Test Case 6: Cyclic increment (z to a)
        assert solution.canMakeSubsequence("xyz", "ya") == true;

        System.out.println("All test cases passed!");
    }
}
