
/**
 * This class provides a solution to the Minimum Path Sum problem.
 * The problem involves finding the path with the minimum sum from the top-left
 * to the bottom-right corner of a grid, moving only right or down.
 */
class Solution {

    /**
     * Calculates the minimum path sum in a given grid.
     *
     * @param grid A 2D integer array representing the grid.
     * @return The minimum sum of the path from top-left to bottom-right.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Initialize dp array with the same dimensions as grid
        int[][] dp = new int[m][n];

        // Base case
        dp[0][0] = grid[0][0];

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The result is in the bottom-right corner
        return dp[m - 1][n - 1];
    }

    /**
     * Main method to run test cases for the Minimum Path Sum problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Standard 3x3 grid
        int[][] grid1 = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("Test case 1 result: " + solution.minPathSum(grid1));

        // Test case 2: 2x3 grid
        int[][] grid2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Test case 2 result: " + solution.minPathSum(grid2));

        // Test case 3: 1x1 grid (edge case)
        int[][] grid3 = {{1}};
        System.out.println("Test case 3 result: " + solution.minPathSum(grid3));

        // Test case 4: 2x2 grid
        int[][] grid4 = {{1, 2}, {1, 1}};
        System.out.println("Test case 4 result: " + solution.minPathSum(grid4));
    }
}
