
/**
 * This class provides a solution to the Spiral Matrix problem.
 * It contains methods to traverse a 2D matrix in spiral order and return the elements as a list.
 */
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Returns all elements of the matrix in spiral order.
     *
     * @param matrix the input 2D matrix
     * @return a list containing the elements of the matrix in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    /**
     * Main method to test the spiralOrder function with various test cases.
     * This method demonstrates the usage of the spiralOrder function and
     * provides example inputs and expected outputs for verification.
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
        System.out.println("Test Case 1 - Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5], Got: " + solution.spiralOrder(matrix1));

        // Test Case 2: 3x4 matrix
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("Test Case 2 - Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7], Got: " + solution.spiralOrder(matrix2));

        // Test Case 3: 1x1 matrix
        int[][] matrix3 = {
            {7}
        };
        System.out.println("Test Case 3 - Expected: [7], Got: " + solution.spiralOrder(matrix3));

        // Test Case 4: 2x2 matrix
        int[][] matrix4 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Test Case 4 - Expected: [1, 2, 4, 3], Got: " + solution.spiralOrder(matrix4));
    }
}
