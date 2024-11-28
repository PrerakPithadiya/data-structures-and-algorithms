
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode Problem 2290: Minimum Obstacle Removal to Reach Corner
 *
 * Given a grid of size m x n where each cell is either empty (0) or contains an
 * obstacle (1), find the minimum number of obstacles that need to be removed to
 * reach the bottom-right corner starting from the top-left corner.
 *
 * Time Complexity: O(m*n*log(m*n)) where m and n are the dimensions of the grid
 * Space Complexity: O(m*n) for the priority queue and visited array
 */
class Solution {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Priority queue to store cells based on the number of obstacles removed
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0}); // {row, column, obstacles_removed}

        // Array to track the minimum obstacles removed to reach each cell
        int[][] minObstacles = new int[m][n];
        for (int[] row : minObstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minObstacles[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], obstacles = current[2];

            // If we reach the bottom-right corner, return the number of obstacles removed
            if (x == m - 1 && y == n - 1) {
                return obstacles;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    // Calculate the new number of obstacles removed
                    int newObstacles = obstacles + grid[newX][newY];

                    // If we found a path with fewer obstacles, update and add to the queue
                    if (newObstacles < minObstacles[newX][newY]) {
                        minObstacles[newX][newY] = newObstacles;
                        pq.offer(new int[]{newX, newY, newObstacles});
                    }
                }
            }
        }

        // If we can't reach the bottom-right corner (shouldn't happen according to constraints)
        return -1; // Not reachable
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple 2x2 grid
        int[][] grid1 = {{0, 1}, {1, 0}};
        assert solution.minimumObstacles(grid1) == 1 : "Test case 1 failed";

        // Test Case 2: No obstacles
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assert solution.minimumObstacles(grid2) == 0 : "Test case 2 failed";

        // Test Case 3: All obstacles except start and end
        int[][] grid3 = {{0, 1, 1}, {1, 1, 1}, {1, 1, 0}};
        assert solution.minimumObstacles(grid3) == 5 : "Test case 3 failed";

        // Test Case 4: Single cell
        int[][] grid4 = {{0}};
        assert solution.minimumObstacles(grid4) == 0 : "Test case 4 failed";

        // Test Case 5: Complex path
        int[][] grid5 = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0}
        };
        assert solution.minimumObstacles(grid5) == 0 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
