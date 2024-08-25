
/**
 * Solution class for the House Robber problem.
 * This class provides a method to determine the maximum amount of money that can be robbed
 * from a row of houses without alerting the police by robbing adjacent houses.
 */
class Solution {

    /**
     * Determines the maximum amount of money that can be robbed.
     *
     * @param nums An array of non-negative integers representing the amount of
     * money in each house.
     * @return The maximum amount of money that can be robbed without alerting
     * the police.
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // dp array to store the maximum money that can be robbed up to house i
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        // The answer is in the last element
        return dp[n - 1];
    }

    /**
     * Main method to run test cases for the House Robber problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test case 1 result: " + solution.rob(nums1));  // Expected output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Test case 2 result: " + solution.rob(nums2));  // Expected output: 12
    }
}
