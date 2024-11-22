package LeetCode;

import java.util.HashMap;

/**
 * Solution for LeetCode problem: Flip Columns For Maximum Number of Equal Rows
 *
 * Problem: Given a matrix consisting of 0s and 1s, we may choose any number of
 * columns in the matrix and flip every cell in that column. Flipping a cell
 * changes the value of that cell from 0 to 1 or from 1 to 0. Return the maximum
 * number of rows that have all values equal after some number of flips.
 */
class Solution {

    /**
     * Finds the maximum number of rows that can become equal after flipping
     * some columns
     *
     * @param matrix The input matrix of 0s and 1s
     * @return Maximum number of rows that can become equal after flips
     */
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> rowCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            // Create a key based on the row, using the first element to determine if we flip
            StringBuilder key = new StringBuilder();
            int firstValue = row[0]; // Store the first value

            for (int j = 0; j < row.length; j++) {
                // Append the normalized value based on the first element
                key.append((row[j] ^ firstValue)); // XOR with firstValue
            }

            // Count the occurrences of this key
            rowCount.put(key.toString(), rowCount.getOrDefault(key.toString(), 0) + 1);
            maxRows = Math.max(maxRows, rowCount.get(key.toString()));
        }

        return maxRows;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[][] matrix1 = {{0, 1}, {1, 1}};
        assert solution.maxEqualRowsAfterFlips(matrix1) == 1 : "Test case 1 failed";

        // Test Case 2: All rows can become equal
        int[][] matrix2 = {{0, 0}, {1, 1}};
        assert solution.maxEqualRowsAfterFlips(matrix2) == 2 : "Test case 2 failed";

        // Test Case 3: Larger matrix
        int[][] matrix3 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        assert solution.maxEqualRowsAfterFlips(matrix3) == 2 : "Test case 3 failed";

        // Test Case 4: Single row
        int[][] matrix4 = {{0, 1, 0}};
        assert solution.maxEqualRowsAfterFlips(matrix4) == 1 : "Test case 4 failed";

        // Test Case 5: All same values
        int[][] matrix5 = {{1, 1, 1}, {1, 1, 1}};
        assert solution.maxEqualRowsAfterFlips(matrix5) == 2 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
