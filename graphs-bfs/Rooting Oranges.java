
/**
 * This class provides a solution to the "Rotting Oranges" problem.
 * The problem involves determining the minimum number of minutes required
 * for all fresh oranges to rot, given a grid of oranges.
 */
class Solution {

    /**
     * Determines the minimum number of minutes required for all fresh oranges
     * to rot.
     *
     * @param grid A 2D integer array representing the grid of oranges. 0
     * represents an empty cell. 1 represents a fresh orange. 2 represents a
     * rotten orange.
     * @return The minimum number of minutes for all oranges to rot, or -1 if
     * it's impossible.
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        // Add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // [row, col, time]
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0; // No fresh oranges to rot
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            minutes = time;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new position is within bounds and is a fresh orange
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2; // Rotten the orange
                    freshOranges--;
                    queue.offer(new int[]{newRow, newCol, time + 1});
                }
            }
        }

        return freshOranges == 0 ? minutes : -1;
    }

    /**
     * Main method to demonstrate the functionality of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] grid1 = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Test case 1 result: " + solution.orangesRotting(grid1)); // Expected output: 4

        // Test case 2
        int[][] grid2 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println("Test case 2 result: " + solution.orangesRotting(grid2)); // Expected output: -1

        // Test case 3
        int[][] grid3 = {{0, 2}};
        System.out.println("Test case 3 result: " + solution.orangesRotting(grid3)); // Expected output: 0
    }
}
