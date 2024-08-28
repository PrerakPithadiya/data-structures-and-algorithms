

/**
 * This class provides a solution to count the number of sub-islands in a given pair of grids.
 * A sub-island is an island in grid2 that is completely contained within an island in grid1.
 */
class Solution {

    /**
     * Counts the number of sub-islands in grid2 that are completely contained
     * within islands in grid1.
     *
     * @param grid1 The first grid representing the main land masses
     * @param grid2 The second grid representing potential sub-islands
     * @return The count of sub-islands
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Performs a depth-first search to determine if an island in grid2 is a
     * sub-island of grid1.
     *
     * @param grid1 The first grid representing the main land masses
     * @param grid2 The second grid representing potential sub-islands
     * @param i The current row index
     * @param j The current column index
     * @return true if the island is a sub-island, false otherwise
     */
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0) {
            return true;
        }

        // Mark the cell as visited in grid2
        grid2[i][j] = 0;

        // Check if the corresponding cell in grid1 is land
        boolean isSubIsland = grid1[i][j] == 1;

        // Explore the four directions
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);

        return isSubIsland;
    }

    /**
     * Main method to demonstrate the functionality of the Solution class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] grid1 = {
            {1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1}
        };
        int[][] grid2 = {
            {1, 1, 1, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 0, 0, 0},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0}
        };
        System.out.println(solution.countSubIslands(grid1, grid2)); // Output: 3

        // Example 2
        int[][] grid1_2 = {
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1}
        };
        int[][] grid2_2 = {
            {0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {1, 0, 0, 0, 1}
        };
        System.out.println(solution.countSubIslands(grid1_2, grid2_2)); // Output: 2
    }
}
