
/**
 * Solution class for finding the maximal square in a binary matrix.
 */
class Solution {

    /**
     * Finds the area of the largest square submatrix with all 1's.
     *
     * @param matrix The input binary matrix represented as char[][]
     * @return The area of the largest square submatrix
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        // Edge case for empty matrix
        if (n == 0) {
            return 0;
        }

        // Initialize DP table
        int[][] dp = new int[m][n];
        int maxSideLength = 0;

        // Fill the DP table
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // For the first row or first column, the largest square ending here is 1x1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // Use DP relation to calculate the side length
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // Update the maximum side length found
                    maxSideLength = Math.max(maxSideLength, dp[i][j]);
                }
            }
        }

        // Return the area of the largest square
        return maxSideLength * maxSideLength;
    }

    /**
     * Main method for testing the maximalSquare function.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Standard case
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Test case 1 result: " + solution.maximalSquare(matrix1)); // Expected output: 4

        // Test case 2: Empty matrix
        char[][] matrix2 = {};
        System.out.println("Test case 2 result: " + solution.maximalSquare(matrix2)); // Expected output: 0

        // Test case 3: Matrix with only 0's
        char[][] matrix3 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        System.out.println("Test case 3 result: " + solution.maximalSquare(matrix3)); // Expected output: 0

        // Test case 4: Matrix with only 1's
        char[][] matrix4 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        System.out.println("Test case 4 result: " + solution.maximalSquare(matrix4)); // Expected output: 9

        // Test case 5: Matrix with single element
        char[][] matrix5 = {{'1'}};
        System.out.println("Test case 5 result: " + solution.maximalSquare(matrix5)); // Expected output: 1
    }
}
