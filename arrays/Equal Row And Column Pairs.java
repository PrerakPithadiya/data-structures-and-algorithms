import java.util.*;

/**
 * Solution class for finding equal row and column pairs in a grid.
 */
class Solution {
    /**
     * Counts the number of equal row and column pairs in the given grid.
     *
     * @param grid The input grid represented as a 2D integer array.
     * @return The count of equal row and column pairs.
     */
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        // Storing rows in the hash map
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }

        int count = 0;

        // Comparing each column with the stored rows
        for (int j = 0; j < n; j++) {
            List<Integer> column = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                column.add(grid[i][j]);
            }
            count += rowMap.getOrDefault(column, 0);
        }

        return count;
    }

    /**
     * Main method to demonstrate the usage of the equalPairs method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } };
        System.out.println(sol.equalPairs(grid1)); // Output: 1

        int[][] grid2 = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(sol.equalPairs(grid2)); // Output: 3
    }
}
