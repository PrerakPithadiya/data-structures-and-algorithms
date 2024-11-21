
/**
 * Solution for LeetCode problem: Count Unguarded Cells in the Grid
 *
 * Problem Description:
 * You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays
 * guards and walls where guards[i] = [rowi, coli] and walls[i] = [rowi, coli] represent the positions of the ith
 * guard and ith wall respectively.
 *
 * A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position
 * unless obstructed by a wall or another guard.
 *
 * Return the number of unguarded cells in the grid.
 *
 * Time Complexity: O(m*n + k) where k is the number of guards
 * Space Complexity: O(m*n) for the grid
 */
class Solution {

    /**
     * Counts the number of unguarded cells in a grid with guards and walls.
     *
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @param guards Array of guard positions where guards[i] = [row, col]
     * @param walls Array of wall positions where walls[i] = [row, col]
     * @return Number of unguarded cells
     */
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Initialize the grid: 0 = unoccupied, 1 = guard, 2 = wall, -1 = guarded
        int[][] grid = new int[m][n];

        // Mark the positions of guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1; // Mark guards
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2; // Mark walls
        }

        // Mark guarded cells
        for (int[] guard : guards) {
            int r = guard[0], c = guard[1];

            // Guard in the north direction
            for (int i = r - 1; i >= 0; i--) {
                if (grid[i][c] == 1 || grid[i][c] == 2) {
                    break; // Stop at guard or wall

                }
                if (grid[i][c] == 0) {
                    grid[i][c] = -1; // Mark as guarded

                }
            }

            // Guard in the south direction
            for (int i = r + 1; i < m; i++) {
                if (grid[i][c] == 1 || grid[i][c] == 2) {
                    break;
                }
                if (grid[i][c] == 0) {
                    grid[i][c] = -1;
                }
            }

            // Guard in the west direction
            for (int j = c - 1; j >= 0; j--) {
                if (grid[r][j] == 1 || grid[r][j] == 2) {
                    break;
                }
                if (grid[r][j] == 0) {
                    grid[r][j] = -1;
                }
            }

            // Guard in the east direction
            for (int j = c + 1; j < n; j++) {
                if (grid[r][j] == 1 || grid[r][j] == 2) {
                    break;
                }
                if (grid[r][j] == 0) {
                    grid[r][j] = -1;
                }
            }
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example from problem description
        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        assert solution.countUnguarded(m1, n1, guards1, walls1) == 7;

        // Test Case 2: Empty grid with no guards or walls
        int m2 = 3, n2 = 3;
        int[][] guards2 = {};
        int[][] walls2 = {};
        assert solution.countUnguarded(m2, n2, guards2, walls2) == 9;

        // Test Case 3: Grid fully blocked by walls
        int m3 = 2, n3 = 2;
        int[][] guards3 = {};
        int[][] walls3 = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        assert solution.countUnguarded(m3, n3, guards3, walls3) == 0;

        // Test Case 4: Grid with single guard in center
        int m4 = 3, n4 = 3;
        int[][] guards4 = {{1, 1}};
        int[][] walls4 = {};
        assert solution.countUnguarded(m4, n4, guards4, walls4) == 4;

        System.out.println("All test cases passed!");
    }
}
