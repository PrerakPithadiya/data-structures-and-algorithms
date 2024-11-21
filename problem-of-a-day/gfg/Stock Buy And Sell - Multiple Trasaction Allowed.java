package GFG;

/**
 * Solution class to find maximum profit from multiple stock transactions Time
 * Complexity: O(n) where n is length of prices array Space Complexity: O(1)
 */
class Solution {

    /**
     * Calculates maximum profit that can be obtained by buying and selling
     * stocks multiple times
     *
     * @param prices Array containing stock prices where prices[i] is price on
     * day i
     * @return Maximum profit that can be obtained
     */
    public int maximumProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            // If there's a profit to be made, add it
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular case with profits
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assert solution.maximumProfit(prices1) == 7 : "Test case 1 failed";

        // Test Case 2: Continuously decreasing prices
        int[] prices2 = {7, 6, 4, 3, 1};
        assert solution.maximumProfit(prices2) == 0 : "Test case 2 failed";

        // Test Case 3: Continuously increasing prices
        int[] prices3 = {1, 2, 3, 4, 5};
        assert solution.maximumProfit(prices3) == 4 : "Test case 3 failed";

        // Test Case 4: Single element
        int[] prices4 = {1};
        assert solution.maximumProfit(prices4) == 0 : "Test case 4 failed";

        // Test Case 5: Empty array
        int[] prices5 = {};
        assert solution.maximumProfit(prices5) == 0 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
