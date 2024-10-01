
/**
 * Solution class for the Range Addition II problem.
 */
class Solution {

    /**
     * Calculates the maximum count of the most frequent elements in a matrix
     * after performing operations.
     *
     * @param m The number of rows in the matrix.
     * @param n The number of columns in the matrix.
     * @param ops A 2D array representing the operations to be performed on the
     * matrix. Each operation is defined by [a, b], where a and b are the number
     * of rows and columns to be incremented, respectively.
     * @return The count of the maximum integer in the matrix after performing
     * all operations.
     */
    public int maxCount(int m, int n, int[][] ops) {
        // Initialize min_a and min_b to m and n
        int min_a = m;
        int min_b = n;

        // Iterate over the operations and find the smallest a and b
        for (int[] op : ops) {
            min_a = Math.min(min_a, op[0]);
            min_b = Math.min(min_b, op[1]);
        }

        // The result is the area of the submatrix defined by min_a and min_b
        return min_a * min_b;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int m1 = 3, n1 = 3;
        int[][] ops1 = {{2, 2}, {3, 3}};
        System.out.println("Test case 1 result: " + solution.maxCount(m1, n1, ops1)); // Expected output: 4

        // Test case 2
        int m2 = 3, n2 = 3;
        int[][] ops2 = {{2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}, {2, 2}, {3, 3}, {3, 3}, {3, 3}};
        System.out.println("Test case 2 result: " + solution.maxCount(m2, n2, ops2)); // Expected output: 4

        // Test case 3
        int m3 = 3, n3 = 3;
        int[][] ops3 = {};
        System.out.println("Test case 3 result: " + solution.maxCount(m3, n3, ops3)); // Expected output: 9

        // Test case 4
        int m4 = 39999, n4 = 39999;
        int[][] ops4 = {{19999, 19999}};
        System.out.println("Test case 4 result: " + solution.maxCount(m4, n4, ops4)); // Expected output: 399960001
    }
}
