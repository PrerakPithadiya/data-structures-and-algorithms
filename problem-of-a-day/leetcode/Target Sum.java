
/**
 * Solution for LeetCode Problem: Target Sum
 *
 * Problem Description:
 * Given an array of integers nums and an integer target, find the total number of ways to assign + and -
 * before each integer such that the sum of all terms equals target.
 *
 * Approach:
 * 1. Convert the problem into a subset sum problem:
 *    - Let P be sum of numbers with + sign and N be sum of numbers with - sign
 *    - P + N = totalSum (where totalSum is sum of all numbers)
 *    - P - N = target
 *    - Solving these equations: P = (totalSum + target) / 2
 *
 * 2. Use Dynamic Programming:
 *    - Create a 1D DP array where dp[i] represents number of ways to make sum i
 *    - For each number in array, update dp[j] += dp[j - num] for all valid j
 *
 * Time Complexity: O(n * sum) where n is length of array and sum is target sum
 * Space Complexity: O(sum)
 */
class Solution {

    /**
     * Finds the total number of ways to assign + and - signs to achieve target
     * sum.
     *
     * @param nums Array of non-negative integers
     * @param target The target sum to achieve
     * @return Number of ways to achieve target sum
     */
    public int findTargetSumWays(int[] nums, int target) {
        // Calculate total sum of array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // If abs(target) is greater than totalSum, it's impossible to achieve target
        if (Math.abs(target) > totalSum) {
            return 0;
        }

        // If (totalSum + target) is odd, it's impossible to achieve target
        if ((totalSum + target) % 2 != 0) {
            return 0;
        }

        // Convert problem to subset sum
        // Let P be sum of positive numbers and N be sum of negative numbers
        // P + N = totalSum
        // P - N = target
        // 2P = totalSum + target
        // P = (totalSum + target) / 2
        int targetSum = (totalSum + target) / 2;

        // Use 1D DP array to find number of subsets with sum equal to targetSum
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        // For each number, update dp array
        for (int num : nums) {
            for (int j = targetSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[targetSum];
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) == 5 : "Test case 1 failed";

        // Test Case 2: Single element
        assert solution.findTargetSumWays(new int[]{1}, 1) == 1 : "Test case 2 failed";

        // Test Case 3: Impossible case (sum < target)
        assert solution.findTargetSumWays(new int[]{1, 2, 3}, 7) == 0 : "Test case 3 failed";

        // Test Case 4: Impossible case (odd sum)
        assert solution.findTargetSumWays(new int[]{1, 2, 1}, 0) == 0 : "Test case 4 failed";

        // Test Case 5: Multiple solutions
        assert solution.findTargetSumWays(new int[]{1, 2, 1, 3}, 1) == 3 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
