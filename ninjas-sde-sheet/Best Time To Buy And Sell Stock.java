
import java.util.Scanner;

/**
 * This class provides a solution to the "Best Time to Buy and Sell Stock"
 * problem. It calculates the maximum profit that can be obtained by buying and
 * selling a stock given an array of stock prices over a period of time.
 */
class Solution {

    /**
     * Calculates the maximum profit that can be obtained from a single buy and
     * sell transaction.
     *
     * @param prices An array of integers representing the stock prices on
     * consecutive days.
     * @return The maximum profit that can be obtained. If no profit can be
     * made, returns 0.
     */
    public static int maxProfit(int[] prices) {
        // Edge case: If there are less than 2 days, no profit can be made
        if (prices.length < 2) {
            return 0;
        }

        // Initialize minPrice with the first element
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through the array to find the maximum profit
        for (int i = 0; i < prices.length; i++) {
            // Update the minimum price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // Calculate the profit if we were to sell today
            int currentProfit = prices[i] - minPrice;

            // Update the maximum profit found so far
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }

        return maxProfit;
    }

    /**
     * The main method that handles input/output and invokes the maxProfit
     * method.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Read the number of days
            int n = sc.nextInt();
            int[] prices = new int[n];

            // Read the stock prices
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }

            // Get the maximum profit
            int result = maxProfit(prices);

            // Output the result
            System.out.println(result);
        }
    }
}
