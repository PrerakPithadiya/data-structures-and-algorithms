
/**
 * Solution for the Longest Increasing Path in a Matrix problem.
 *
 * This class finds the length of the longest increasing path in a given 2D matrix.
 * The path can move in four directions: up, down, left, or right.
 * Time Complexity: O(m * n), where m and n are the dimensions of the matrix.
 * Space Complexity: O(m * n) for the memoization array.
 */
class Solution {

    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;

    /**
     * Finds the length of the longest increasing path in the given matrix.
     *
     * @param matrix The input 2D integer matrix
     * @return The length of the longest increasing path
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n]; // Memoization array to store the longest path from each cell
        int maxPath = 0;

        // Try to find the longest increasing path from each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, dp));
            }
        }

        return maxPath;
    }

    /**
     * Depth-first search to find the longest increasing path starting from a
     * given cell.
     *
     * @param matrix The input 2D integer matrix
     * @param i The row index of the current cell
     * @param j The column index of the current cell
     * @param dp The memoization array
     * @return The length of the longest increasing path starting from the
     * current cell
     */
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        // If the result is already computed, return it
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 1; // The path length starts at 1 (the cell itself)

        // Explore all 4 possible directions
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            // Check bounds and if the next cell value is greater than the current cell value
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, dp);
                max = Math.max(max, len);
            }
        }

        // Store the result in the dp array
        dp[i][j] = max;
        return max;
    }

    /**
     * Test cases for the longestIncreasingPath method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] matrix1 = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        assert solution.longestIncreasingPath(matrix1) == 4 : "Test case 1 failed";

        // Test case 2
        int[][] matrix2 = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        assert solution.longestIncreasingPath(matrix2) == 4 : "Test case 2 failed";

        // Test case 3
        int[][] matrix3 = {{1}};
        assert solution.longestIncreasingPath(matrix3) == 1 : "Test case 3 failed";

        // Test case 4
        int[][] matrix4 = {};
        assert solution.longestIncreasingPath(matrix4) == 0 : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
