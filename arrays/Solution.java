
import java.util.Arrays;

/**
 * This class provides a solution to the candy distribution problem. The problem
 * involves distributing candies to children based on their ratings, following
 * specific rules.
 */
public class Solution {

    /**
     * Calculates the minimum number of candies needed to distribute to children
     * based on their ratings.
     *
     * Rules: 1. Each child must have at least one candy. 2. Children with a
     * higher rating get more candies than their neighbors.
     *
     * @param ratings An array of integers representing the ratings of children.
     * @return The minimum total number of candies needed.
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize all candies to 1
        Arrays.fill(candies, 1);

        // Left to Right pass
        // Ensure that if a child has a higher rating than the left neighbor,
        // they get more candies
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left pass
        // Ensure that if a child has a higher rating than the right neighbor,
        // they get more candies, while maintaining the left neighbor condition
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    /**
     * Main method to demonstrate the usage of the candy distribution algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] ratings1 = {1, 0, 2};
        System.out.println("Example 1 output: " + sol.candy(ratings1));  // Expected output: 5

        // Example 2
        int[] ratings2 = {1, 2, 2};
        System.out.println("Example 2 output: " + sol.candy(ratings2));  // Expected output: 4
    }
}
