package greedy;

/**
 * Solution for the Wildcard Matching problem. This class implements a dynamic
 * programming approach to determine if a string matches a given pattern.
 */
class Solution {

    /**
     * Determines if the input string matches the given pattern.
     *
     * @param s The input string to match.
     * @param p The pattern to match against.
     * @return true if the string matches the pattern, false otherwise.
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // DP table
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == sChar || pChar == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Test cases for the isMatch method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic matching
        assert solution.isMatch("aa", "a") == false : "Test case 1 failed";

        // Test case 2: '*' wildcard
        assert solution.isMatch("aa", "*") == true : "Test case 2 failed";

        // Test case 3: '?' wildcard
        assert solution.isMatch("cb", "?a") == false : "Test case 3 failed";

        // Test case 4: Complex pattern
        assert solution.isMatch("adceb", "*a*b") == true : "Test case 4 failed";

        // Test case 5: Multiple wildcards
        assert solution.isMatch("acdcb", "a*c?b") == false : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
