
/**
 * Solution class for solving the Unique Paths II problem.
 * This class provides a method to calculate the number of unique paths
 * in a grid with obstacles.
 */
class Solution {

    /**
     * Calculates the number of unique paths from the top-left corner to the
     * bottom-right corner of a grid with obstacles.
     *
     * @param obstacleGrid A 2D integer array representing the grid where 1
     * indicates an obstacle and 0 indicates a free cell.
     * @return The number of unique paths from start to finish, considering the
     * obstacles.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a dp array with the same dimensions as the grid
        int[][] dp = new int[m][n];

        // Initialize the starting point
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 1 || dp[0][j - 1] == 0) ? 0 : 1;
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) ? 0 : 1;
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        // Return the number of unique paths to the bottom-right corner
        return dp[m - 1][n - 1];
    }
}
