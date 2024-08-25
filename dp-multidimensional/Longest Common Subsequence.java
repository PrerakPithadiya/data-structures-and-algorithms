
/**
 * This class provides a solution for finding the Longest Common Subsequence (LCS) of two strings.
 * The LCS problem is a classic problem in computer science and is often used in file comparison programs.
 */
class Solution {

    /**
     * Finds the length of the Longest Common Subsequence of two given strings.
     *
     * @param text1 The first input string
     * @param text2 The second input string
     * @return The length of the longest common subsequence
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        // DP table to store the lengths of LCS for different subproblems
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If characters match, add 1 to the LCS length of the substring without these characters
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters don't match, take the maximum of LCS without one of the characters
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right corner of the table contains the length of the LCS
        return dp[m][n];
    }

    /**
     * Main method to run test cases for the LCS algorithm.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("LCS length of 'abcde' and 'ace': " + solution.longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println("LCS length of 'abc' and 'abc': " + solution.longestCommonSubsequence("abc", "abc"));     // Output: 3
        System.out.println("LCS length of 'abc' and 'def': " + solution.longestCommonSubsequence("abc", "def"));     // Output: 0
    }
}
