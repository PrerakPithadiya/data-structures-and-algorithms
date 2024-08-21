
/**
 * Solution class for the Strange Printer problem.
 */
class Solution {

    /**
     * Calculates the minimum number of turns required to print a given string.
     *
     * @param s The input string to be printed.
     * @return The minimum number of turns required to print the string.
     */
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: single characters take 1 turn to print
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the DP table
        for (int len = 2; len <= n; len++) { // length of substring
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i][j - 1] + 1; // worst case: print s[j] separately
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    /**
     * Main method to test the strangePrinter function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strangePrinter("aaabbb")); // Output: 2
        System.out.println(sol.strangePrinter("aba"));    // Output: 2
    }
}
