
/**
 * Solution class for the "Best Time to Buy and Sell Stock II" problem.
 * This class provides a method to calculate the maximum profit that can be obtained
 * by buying and selling stocks, given an array of stock prices.
 */
class Solution {

    /**
     * Calculates the maximum profit that can be obtained by buying and selling
     * stocks.
     *
     * @param prices An array of integers representing the stock prices on
     * consecutive days.
     * @return The maximum profit that can be obtained.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If the price of the stock today is greater than the price yesterday,
            // we can make a profit by buying yesterday and selling today.
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test case 1: " + solution.maxProfit(prices1)); // Output: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2: " + solution.maxProfit(prices2)); // Output: 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test case 3: " + solution.maxProfit(prices3)); // Output: 0
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * maxProfit method with an array of integers representing stock prices. 3. The
 * method will return the maximum profit that can be obtained.
 *
 * Example: Solution solution = new Solution(); int[] prices = {7, 1, 5, 3, 6,
 * 4}; int maxProfit = solution.maxProfit(prices); System.out.println("Maximum
 * profit: " + maxProfit);
 *
 * Design and Implementation: - The solution uses a greedy approach to calculate
 * the maximum profit. - It iterates through the prices array once, comparing
 * each price with the previous day's price. - If the current price is higher
 * than the previous day's price, it adds the difference to the total profit. -
 * This approach works because we can buy and sell stocks on the same day,
 * allowing us to capture all possible profits. - Time complexity: O(n), where n
 * is the number of days (length of the prices array). - Space complexity: O(1),
 * as we only use a constant amount of extra space.
 */
