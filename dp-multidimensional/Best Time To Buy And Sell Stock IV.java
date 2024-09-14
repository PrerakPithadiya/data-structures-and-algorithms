
/**
 * Solution class for the "Best Time to Buy and Sell Stock IV" problem.
 * This class provides a method to calculate the maximum profit that can be made
 * from at most k transactions given an array of stock prices.
 */
class Solution {

    /**
     * Calculates the maximum profit that can be made from at most k
     * transactions.
     *
     * @param k The maximum number of transactions allowed.
     * @param prices An array of stock prices, where prices[i] is the price on
     * the i-th day.
     * @return The maximum profit that can be achieved.
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        // If we can perform unlimited transactions (k >= n/2)
        if (k >= n / 2) {
            return unlimitedTransactions(prices);
        }

        // Initialize DP array
        int[][] dp = new int[k + 1][n];

        // Iterate over the number of transactions allowed
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];  // Initialize maxDiff for the first day
            for (int i = 1; i < n; i++) {
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][i] - prices[i]);
            }
        }

        // The answer is the maximum profit with exactly k transactions on the last day
        return dp[k][n - 1];
    }

    /**
     * Helper method to calculate profit when unlimited transactions are
     * allowed.
     *
     * @param prices An array of stock prices.
     * @return The maximum profit with unlimited transactions.
     */
    private int unlimitedTransactions(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case
        int k1 = 2;
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        System.out.println("Test case 1: " + solution.maxProfit(k1, prices1)); // Expected output: 7

        // Test case 2: Empty array
        int k2 = 2;
        int[] prices2 = {};
        System.out.println("Test case 2: " + solution.maxProfit(k2, prices2)); // Expected output: 0

        // Test case 3: Single element array
        int k3 = 2;
        int[] prices3 = {1};
        System.out.println("Test case 3: " + solution.maxProfit(k3, prices3)); // Expected output: 0

        // Test case 4: Unlimited transactions
        int k4 = 2;
        int[] prices4 = {3, 2, 6, 5, 0, 3, 1, 4};
        System.out.println("Test case 4: " + solution.maxProfit(k4, prices4)); // Expected output: 10

        // Test case 5: No profit possible
        int k5 = 2;
        int[] prices5 = {3, 3, 3, 3, 3};
        System.out.println("Test case 5: " + solution.maxProfit(k5, prices5)); // Expected output: 0
    }
}
