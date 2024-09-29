
/**
 * Solution class for the "Guess Number Higher or Lower II" problem.
 * This class implements a dynamic programming approach to find the minimum amount of money
 * needed to guarantee a win in the guessing game, regardless of the number chosen.
 */
class Solution {

    /**
     * Calculates the minimum amount of money needed to guarantee a win in the
     * guessing game.
     *
     * @param n The upper bound of the range of numbers (1 to n)
     * @return The minimum amount of money needed to guarantee a win
     */
    public int getMoneyAmount(int n) {
        // Initialize a 2D array to store the minimum cost for each range
        int[][] dp = new int[n + 1][n + 1];

        // Fill the table for all ranges [low, high]
        for (int length = 2; length <= n; length++) {
            for (int low = 1; low <= n - length + 1; low++) {
                int high = low + length - 1;
                dp[low][high] = Integer.MAX_VALUE;
                // Try all possible guesses within the current range
                for (int x = low; x < high; x++) {
                    // Calculate the cost of the current guess
                    int cost = x + Math.max(dp[low][x - 1], dp[x + 1][high]);
                    // Update the minimum cost for the current range
                    dp[low][high] = Math.min(dp[low][high], cost);
                }
            }
        }

        // Return the minimum cost for the entire range [1, n]
        return dp[1][n];
    }

    /**
     * Main method for testing the Solution class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 10;
        System.out.println("Test case 1:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.getMoneyAmount(n1));
        System.out.println("Expected: 16");
        System.out.println();

        // Test case 2
        int n2 = 1;
        System.out.println("Test case 2:");
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.getMoneyAmount(n2));
        System.out.println("Expected: 0");
        System.out.println();

        // Test case 3
        int n3 = 2;
        System.out.println("Test case 3:");
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + solution.getMoneyAmount(n3));
        System.out.println("Expected: 1");
        System.out.println();
    }
}
