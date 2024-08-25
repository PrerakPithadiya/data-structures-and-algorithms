
/**
 * Solution class for the Min Cost Climbing Stairs problem.
 * This class provides a method to calculate the minimum cost of climbing stairs,
 * where each step has an associated cost.
 */
class Solution {

    /**
     * Calculates the minimum cost of climbing to the top of the stairs. You can
     * either start from the step with index 0, or the step with index 1. Each
     * time you can climb either one or two steps.
     *
     * @param cost An array of integers where cost[i] is the cost of stepping on
     * the i-th stair.
     * @return The minimum cost to reach the top of the staircase.
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // Base case: if there are only two steps, return the minimum of their costs
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // Initialize a dynamic programming array to store minimum costs
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        // Calculate minimum cost for each step
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // The final minimum cost to reach the top can be from the last or second last step
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    /**
     * Main method to run test cases for the Min Cost Climbing Stairs problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] cost1 = {10, 15, 20};
        System.out.println("Test case 1 output: " + solution.minCostClimbingStairs(cost1));  // Expected output: 15

        // Test case 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Test case 2 output: " + solution.minCostClimbingStairs(cost2));  // Expected output: 6
    }
}
