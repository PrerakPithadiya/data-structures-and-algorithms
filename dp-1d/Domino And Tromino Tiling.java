
/**
 * Solution class for the Domino and Tromino Tiling problem.
 * This class provides a method to calculate the number of ways to tile a 2 x n board
 * using 2 x 1 dominos and L-shaped trominos.
 */
class Solution {

    /**
     * Calculates the number of ways to tile a 2 x n board.
     *
     * @param n The width of the board (2 x n)
     * @return The number of ways to tile the board, modulo 1,000,000,007
     */
    public int numTilings(int n) {
        final int MOD = 1_000_000_007;

        // Base cases
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 5;
        }

        // Dynamic programming table
        int[] dp = new int[n + 1];
        dp[0] = 1; // This corresponds to an empty board
        dp[1] = 1; // One way to tile 2x1
        dp[2] = 2; // Two ways to tile 2x2
        dp[3] = 5; // Five ways to tile 2x3

        // Fill the dp table for n > 3
        for (int i = 4; i <= n; i++) {
            // The recurrence relation:
            // dp[i] = 2 * dp[i-1] + dp[i-3]
            // We use modular arithmetic to prevent integer overflow
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3] % MOD) % MOD;
        }

        return dp[n];
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Number of ways to tile a 2x3 board: " + solution.numTilings(3));  // Output: 5
        System.out.println("Number of ways to tile a 2x30 board: " + solution.numTilings(30)); // Expected Output: 312342182
    }
}
