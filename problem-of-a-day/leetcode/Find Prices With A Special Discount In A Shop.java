
/**
 * Solution for LeetCode problem: Find Prices With A Special Discount In A Shop
 *
 * Problem Description:
 * Given an array 'prices' where prices[i] represents the price of the ith item in a shop.
 * There is a special discount for items in the shop where you can receive a discount
 * equivalent to prices[j] where j > i and prices[j] <= prices[i].
 *
 * Approach:
 * - Use nested loops to iterate through the array
 * - For each price, find the first subsequent price that is less than or equal to it
 * - Apply the discount by subtracting the found price
 *
 * Time Complexity: O(n^2) where n is the length of prices array
 * Space Complexity: O(1) as we modify the input array in-place
 *
 * @author Sourcegraph
 */
class Solution {

    /**
     * Calculates the final prices after applying the special discount.
     *
     * @param prices Array of original prices
     * @return Array of prices after applying discounts
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular case
        int[] test1 = {8, 4, 6, 2, 3};
        assert java.util.Arrays.equals(solution.finalPrices(test1), new int[]{4, 2, 4, 2, 3});

        // Test Case 2: No discounts possible
        int[] test2 = {1, 2, 3, 4, 5};
        assert java.util.Arrays.equals(solution.finalPrices(test2), new int[]{1, 2, 3, 4, 5});

        // Test Case 3: All same prices
        int[] test3 = {4, 4, 4, 4};
        assert java.util.Arrays.equals(solution.finalPrices(test3), new int[]{0, 0, 0, 4});

        // Test Case 4: Single element
        int[] test4 = {10};
        assert java.util.Arrays.equals(solution.finalPrices(test4), new int[]{10});

        System.out.println("All test cases passed!");
    }
}
