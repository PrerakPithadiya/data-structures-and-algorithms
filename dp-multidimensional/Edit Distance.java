
/**
 * This class provides a solution to the Edit Distance problem using dynamic programming.
 * The Edit Distance is the minimum number of operations (insertions, deletions, or substitutions)
 * required to transform one string into another.
 */
class Solution {

    /**
     * Calculates the minimum number of operations required to convert word1 to
     * word2.
     *
     * @param word1 The first string
     * @param word2 The second string
     * @return The minimum number of operations (Edit Distance)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Create the DP table
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the DP table for base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters in word1 to match empty word2
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters into empty word1 to match word2
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match, no new operation needed
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, // Replace
                            Math.min(dp[i - 1][j] + 1, // Delete
                                    dp[i][j - 1] + 1)); // Insert
                }
            }
        }

        // The answer is the minimum number of operations needed to convert word1 to word2
        return dp[m][n];
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.minDistance("horse", "ros")); // Output: 3
        System.out.println(solution.minDistance("intention", "execution")); // Output: 5
    }
}
