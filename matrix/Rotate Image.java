
/**
 * This class provides a solution for rotating an n x n matrix by 90 degrees clockwise in place.
 * It includes methods for matrix rotation, testing, and printing.
 */
class Solution {

    /**
     * Rotates the given n x n matrix by 90 degrees clockwise in place. This
     * method uses a two-step approach: 1. Transpose the matrix (convert rows to
     * columns) 2. Reverse each row to get the 90-degree rotated matrix
     *
     * Time Complexity: O(n^2), where n is the number of rows/columns in the
     * matrix Space Complexity: O(1), as the rotation is done in place
     *
     * @param matrix the n x n matrix to be rotated
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix (convert rows to columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get the 90-degree rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * Main method to test the rotate function with various test cases. This
     * method demonstrates the usage of the rotate function and provides example
     * inputs and outputs for different matrix sizes.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x3 matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        solution.rotate(matrix1);
        System.out.println("Test Case 1 (3x3 matrix):");
        printMatrix(matrix1);

        // Test Case 2: 4x4 matrix
        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        solution.rotate(matrix2);
        System.out.println("Test Case 2 (4x4 matrix):");
        printMatrix(matrix2);

        // Test Case 3: 1x1 matrix
        int[][] matrix3 = {
            {1}
        };
        solution.rotate(matrix3);
        System.out.println("Test Case 3 (1x1 matrix):");
        printMatrix(matrix3);

        // Test Case 4: 2x2 matrix
        int[][] matrix4 = {
            {1, 2},
            {3, 4}
        };
        solution.rotate(matrix4);
        System.out.println("Test Case 4 (2x2 matrix):");
        printMatrix(matrix4);
    }

    /**
     * Helper method to print the matrix. This method prints the matrix in a
     * readable format, with each element separated by a space and each row on a
     * new line.
     *
     * @param matrix the matrix to be printed
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println(); // Add an extra line for better readability between test cases
    }
}
