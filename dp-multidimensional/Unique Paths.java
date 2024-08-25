
/**
 * This class provides a solution to the "Unique Paths" problem using dynamic programming.
 * The problem involves finding the number of unique paths from the top-left corner to
 * the bottom-right corner of a grid, moving only right and down.
 */
class Solution {

    /**
     * Calculates the number of unique paths in a grid of size m x n.
     *
     * @param m The number of rows in the grid.
     * @param n The number of columns in the grid.
     * @return The number of unique paths from top-left to bottom-right.
     */
    public int uniquePaths(int m, int n) {
        // DP table to store the number of paths to each cell
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        // There's only one way to reach any cell in the first row or column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        // The number of paths to a cell is the sum of paths from the cell above and the cell to the left
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right corner will have the total number of unique paths
        return dp[m - 1][n - 1];
    }

    /**
     * Main method to run test cases for the uniquePaths method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Number of unique paths in a 3x7 grid: " + solution.uniquePaths(3, 7)); // Output: 28
        System.out.println("Number of unique paths in a 3x2 grid: " + solution.uniquePaths(3, 2)); // Output: 3
    }
}
