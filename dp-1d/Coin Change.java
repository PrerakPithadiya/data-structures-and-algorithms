
import java.util.Arrays;

/**
 * Solution class for the Coin Change problem. This class provides a method to
 * find the minimum number of coins needed to make up a given amount.
 */
class Solution {

    /**
     * Finds the minimum number of coins needed to make up the given amount.
     *
     * @param coins An array of integers representing the denominations of coins
     * available.
     * @param amount The target amount for which we need to find the minimum
     * number of coins.
     * @return The minimum number of coins needed to make up the amount, or -1
     * if it's not possible.
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);  // Initialize dp array with max value
        dp[0] = 0;  // Base case: 0 coins needed to make amount 0

        // Iterate over each amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still max, it means amount cannot be formed
        return dp[amount] == max ? -1 : dp[amount];
    }

    /**
     * Main method to run test cases for the coinChange method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Test case 1:");
        System.out.println("Coins: " + Arrays.toString(coins1));
        System.out.println("Amount: " + amount1);
        System.out.println("Minimum coins needed: " + solution.coinChange(coins1, amount1));
        System.out.println();

        // Test case 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Test case 2:");
        System.out.println("Coins: " + Arrays.toString(coins2));
        System.out.println("Amount: " + amount2);
        System.out.println("Minimum coins needed: " + solution.coinChange(coins2, amount2));
        System.out.println();

        // Test case 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Test case 3:");
        System.out.println("Coins: " + Arrays.toString(coins3));
        System.out.println("Amount: " + amount3);
        System.out.println("Minimum coins needed: " + solution.coinChange(coins3, amount3));
    }
}

/**
 * Design and Implementation:
 *
 * The coinChange method uses dynamic programming to solve the problem
 * efficiently.
 *
 * 1. We create a dp array of size amount + 1 to store the minimum number of
 * coins needed for each amount from 0 to amount. 2. We initialize all values in
 * dp with amount + 1 (max) as a placeholder for infinity. 3. We set dp[0] = 0
 * as the base case (0 coins needed to make amount 0). 4. We iterate through all
 * amounts from 1 to amount: a. For each amount, we try all coin denominations.
 * b. If a coin can be used (i.e., its value is not greater than the current
 * amount), we update dp[i] with the minimum of its current value and 1 plus the
 * number of coins needed for (amount - coin value). 5. After the iteration, if
 * dp[amount] is still max, it means the amount cannot be formed with the given
 * coins, so we return -1. Otherwise, we return dp[amount], which represents the
 * minimum number of coins needed.
 *
 * Time Complexity: O(amount * number of coin denominations) Space Complexity:
 * O(amount)
 *
 * Usage Instructions:
 *
 * 1. Create an instance of the Solution class. 2. Call the coinChange method
 * with an array of coin denominations and the target amount. 3. The method will
 * return the minimum number of coins needed or -1 if it's not possible.
 *
 * Example: Solution solution = new Solution(); int[] coins = {1, 2, 5}; int
 * amount = 11; int result = solution.coinChange(coins, amount);
 * System.out.println(result); // Output: 3 (11 = 5 + 5 + 1)
 */
