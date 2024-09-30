
/**
 * Solution class for the "Predict the Winner" problem.
 * This class implements a dynamic programming approach to determine if Player 1 can win or tie in a two-player game.
 */
class Solution {

    /**
     * Predicts whether Player 1 can win or tie in the game.
     *
     * @param nums An array of integers representing the values of the game
     * elements.
     * @return true if Player 1 can win or tie, false otherwise.
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // DP table to store the score differences
        int[][] dp = new int[n][n];

        // Base case: when there is only one element
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill the DP table using the recursive relation
        for (int len = 2; len <= n; len++) { // length of subarray
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // end index of subarray
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // If the final score difference is non-negative, Player 1 can win or tie
        return dp[0][n - 1] >= 0;
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 5, 2};
        System.out.println("Test case 1: " + solution.predictTheWinner(nums1)); // Expected: false

        // Test case 2
        int[] nums2 = {1, 5, 233, 7};
        System.out.println("Test case 2: " + solution.predictTheWinner(nums2)); // Expected: true

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        System.out.println("Test case 3: " + solution.predictTheWinner(nums3)); // Expected: true

        // Test case 4
        int[] nums4 = {1, 1, 1};
        System.out.println("Test case 4: " + solution.predictTheWinner(nums4)); // Expected: true

        // Test case 5
        int[] nums5 = {1, 2};
        System.out.println("Test case 5: " + solution.predictTheWinner(nums5)); // Expected: true
    }
}

/**
 * The program will execute the test cases and print the results to the console.
 *
 * To use the predictTheWinner method in your own code: 1. Create an instance of
 * the Solution class. 2. Call the predictTheWinner method with an integer array
 * as the argument. 3. The method will return a boolean indicating whether
 * Player 1 can win or tie.
 *
 * Example: Solution solution = new Solution(); int[] nums = {1, 5, 2}; boolean
 * result = solution.predictTheWinner(nums); System.out.println(result);
 */
