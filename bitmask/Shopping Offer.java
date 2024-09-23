package bitmask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution class for the Shopping Offer problem.
 * This class provides a method to calculate the lowest price you have to pay
 * for exactly certain items.
 */
class Solution {
    /**
     * Calculates the lowest price to buy exactly certain items using special
     * offers.
     *
     * @param price   List of prices of individual items
     * @param special List of special offers, where each offer is represented as a
     *                list
     * @param needs   List representing the number of each item we need to buy
     * @return The lowest price we have to pay for the items
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // Use a map to memoize results for each state of needs
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    /**
     * Depth-first search to find the lowest price.
     *
     * @param price   List of prices of individual items
     * @param special List of special offers
     * @param needs   Current state of needs
     * @param memo    Memoization map to store computed results
     * @return The lowest price for the current state of needs
     */
    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            Map<List<Integer>, Integer> memo) {
        // If the current needs state is already computed, return the cached result
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }

        // Calculate the cost without using any special offers (buying everything
        // directly)
        int minCost = 0;
        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // Try each special offer and see if it's valid
        for (List<Integer> offer : special) {
            List<Integer> updatedNeeds = applyOfferIfValid(offer, needs);
            if (updatedNeeds != null) {
                // If the offer is valid, calculate the cost recursively and take the minimum
                minCost = Math.min(minCost, offer.get(offer.size() - 1) + dfs(price, special, updatedNeeds, memo));
            }
        }

        // Memoize the result for the current needs
        memo.put(needs, minCost);
        return minCost;
    }

    /**
     * Check if the offer is valid and if so, return the updated needs after
     * applying the offer.
     *
     * @param offer The special offer to apply
     * @param needs Current state of needs
     * @return Updated needs after applying the offer, or null if the offer can't be
     *         applied
     */
    private List<Integer> applyOfferIfValid(List<Integer> offer, List<Integer> needs) {
        List<Integer> updatedNeeds = new ArrayList<>(needs);
        for (int i = 0; i < needs.size(); i++) {
            if (offer.get(i) > needs.get(i)) {
                return null; // Offer can't be applied if it exceeds current needs
            }
            updatedNeeds.set(i, needs.get(i) - offer.get(i));
        }
        return updatedNeeds;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<Integer> price1 = List.of(2, 5);
        List<List<Integer>> special1 = List.of(List.of(3, 0, 5), List.of(1, 2, 10));
        List<Integer> needs1 = List.of(3, 2);
        System.out.println("Test case 1 result: " + solution.shoppingOffers(price1, special1, needs1)); // Expected
                                                                                                        // output: 14

        // Test case 2
        List<Integer> price2 = List.of(2, 3, 4);
        List<List<Integer>> special2 = List.of(List.of(1, 1, 0, 4), List.of(2, 2, 1, 9));
        List<Integer> needs2 = List.of(1, 2, 1);
        System.out.println("Test case 2 result: " + solution.shoppingOffers(price2, special2, needs2)); // Expected
                                                                                                        // output: 11

        // Test case 3
        List<Integer> price3 = List.of(9, 9);
        List<List<Integer>> special3 = List.of(List.of(1, 1, 1));
        List<Integer> needs3 = List.of(2, 2);
        System.out.println("Test case 3 result: " + solution.shoppingOffers(price3, special3, needs3)); // Expected
                                                                                                        // output: 2
    }
}
