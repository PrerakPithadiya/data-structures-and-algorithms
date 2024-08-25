
/**
 * Solution class for the "Best Time to Buy and Sell Stock with Transaction Fee" problem.
 * This class provides a method to calculate the maximum profit that can be obtained
 * from a series of stock prices, considering a transaction fee for each sale.
 */
class Solution {

    /**
     * Calculates the maximum profit that can be obtained from a series of stock
     * prices with a transaction fee for each sale.
     *
     * @param prices An array of integers representing daily stock prices.
     * @param fee An integer representing the transaction fee for each stock
     * sale.
     * @return The maximum profit that can be obtained.
     */
    public int maxProfit(int[] prices, int fee) {
        // Initialize the variables for hold and cash states

        int hold = Integer.MIN_VALUE; // Represents the maximum profit if we are holding a stock
        int cash = 0; // Represents the maximum profit if we are not holding any stock

        // Iterate through each day's price
        for (int price : prices) {
            // Update the hold state: Either continue holding or buy at the current price
            hold = Math.max(hold, cash - price);
            // Update the cash state: Either continue with cash or sell the stock we are holding
            cash = Math.max(cash, hold + price - fee);
        }

        // The maximum profit when not holding any stock at the end
        return cash;
    }

    /**
     * Main method to demonstrate the usage of the maxProfit method with test
     * cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // Output: 8
        System.out.println(solution.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)); // Output: 6
    }
}
