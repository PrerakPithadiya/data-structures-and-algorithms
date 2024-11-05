package GFG;

class GFG {

    /**
     * Rotates a square matrix by 90 degrees clockwise in-place. The rotation is
     * performed in two steps: 1. Transpose the matrix 2. Reverse each row
     *
     * @param mat The input square matrix to be rotated
     */
    static void rotate(int mat[][]) {
        int n = mat.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - j - 1];
                mat[i][n - j - 1] = temp;
            }
        }
    }

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: 2x2 matrix
        int[][] matrix1 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Test Case 1 - Before rotation:");
        printMatrix(matrix1);
        rotate(matrix1);
        System.out.println("After rotation:");
        printMatrix(matrix1);

        // Test Case 2: 3x3 matrix
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("\nTest Case 2 - Before rotation:");
        printMatrix(matrix2);
        rotate(matrix2);
        System.out.println("After rotation:");
        printMatrix(matrix2);

        // Test Case 3: 4x4 matrix
        int[][] matrix3 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println("\nTest Case 3 - Before rotation:");
        printMatrix(matrix3);
        rotate(matrix3);
        System.out.println("After rotation:");
        printMatrix(matrix3);
    }

    /**
     * Helper method to print a matrix
     *
     * @param mat The matrix to be printed
     */
    static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
