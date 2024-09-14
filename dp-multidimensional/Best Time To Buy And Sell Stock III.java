
/**
 * Solution class for the "Best Time to Buy and Sell Stock III" problem.
 * This class provides a method to calculate the maximum profit that can be achieved
 * from at most two transactions in a given array of stock prices.
 */
class Solution {

    /**
     * Calculates the maximum profit that can be achieved from at most two
     * transactions.
     *
     * @param prices An array of integers where prices[i] is the price of a
     * given stock on the i-th day.
     * @return The maximum profit that can be achieved from at most two
     * transactions.
     */
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int price : prices) {
            // Trying to get the max profit after buying the first stock
            firstBuy = Math.max(firstBuy, -price);

            // Trying to get the max profit after selling the first stock
            firstSell = Math.max(firstSell, firstBuy + price);

            // Trying to get the max profit after buying the second stock (after selling the first one)
            secondBuy = Math.max(secondBuy, firstSell - price);

            // Trying to get the max profit after selling the second stock
            secondSell = Math.max(secondSell, secondBuy + price);
        }

        // The answer is the max profit after completing two transactions
        return secondSell;
    }

    /**
     * Main method to run test cases for the maxProfit method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Regular case
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println("Test case 1: " + solution.maxProfit(prices1)); // Expected output: 6

        // Test case 2: Monotonically increasing prices
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test case 2: " + solution.maxProfit(prices2)); // Expected output: 4

        // Test case 3: Monotonically decreasing prices
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test case 3: " + solution.maxProfit(prices3)); // Expected output: 0

        // Test case 4: Empty array
        int[] prices4 = {};
        System.out.println("Test case 4: " + solution.maxProfit(prices4)); // Expected output: 0

        // Test case 5: Array with one element
        int[] prices5 = {1};
        System.out.println("Test case 5: " + solution.maxProfit(prices5)); // Expected output: 0

        // Test case 6: Array with two elements
        int[] prices6 = {1, 2};
        System.out.println("Test case 6: " + solution.maxProfit(prices6)); // Expected output: 1
    }
}
