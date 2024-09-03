
/**
 * Solution class for the "Set Matrix Zeroes" problem.
 * This class provides a method to modify a matrix in-place, setting entire rows and columns to zero
 * if an element in the matrix is zero.
 */
class Solution {

    /**
     * Sets the entire row and column to 0's if an element in the matrix is 0.
     * The operation is done in-place with O(1) extra space.
     *
     * Algorithm: 1. Check if the first row and first column need to be zeroed.
     * 2. Use the first row and first column as markers for zeroing. 3. Iterate
     * through the matrix (excluding first row and column) to mark zeros. 4.
     * Zero out cells based on the markers in the first row and column. 5. Zero
     * out the first row and column if necessary.
     *
     * Time Complexity: O(m * n), where m is the number of rows and n is the
     * number of columns. Space Complexity: O(1), as we use the matrix itself to
     * store information.
     *
     * @param matrix the m x n matrix to be modified
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Determine if the first row or first column needs to be zeroed
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2 & 3: Use the first row and first column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle the first row and column
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Main method to test the setZeroes function with various test cases. This
     * method demonstrates the usage of the setZeroes function and provides
     * example inputs and outputs.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x3 matrix with a zero in the center
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        solution.setZeroes(matrix1);
        System.out.println("Test Case 1:");
        printMatrix(matrix1);

        // Test Case 2: 3x4 matrix with zeros in the first and last columns
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        solution.setZeroes(matrix2);
        System.out.println("Test Case 2:");
        printMatrix(matrix2);

        // Test Case 3: 2x2 matrix with a zero in the first row
        int[][] matrix3 = {
            {1, 0},
            {3, 4}
        };
        solution.setZeroes(matrix3);
        System.out.println("Test Case 3:");
        printMatrix(matrix3);

        // Test Case 4: 2x2 matrix with zeros on the diagonal
        int[][] matrix4 = {
            {0, 1},
            {3, 0}
        };
        solution.setZeroes(matrix4);
        System.out.println("Test Case 4:");
        printMatrix(matrix4);
    }

    /**
     * Helper method to print the matrix. This method is used for displaying the
     * results of the test cases.
     *
     * @param matrix the matrix to be printed
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println(); // Add a blank line between matrices for better readability
    }
}
