public class Solution {
    
    /**
     * Converts a 1D array into a 2D array with dimensions m x n.
     * 
     * @param original The 1D array to be converted.
     * @param m The number of rows in the 2D array.
     * @param n The number of columns in the 2D array.
     * @return A 2D array of dimensions m x n if conversion is possible; otherwise, an empty 2D array.
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if it's possible to create a 2D array with the given dimensions
        if (original.length != m * n) {
            return new int[0][];
        }

        // Initialize the 2D array
        int[][] result = new int[m][n];

        // Fill the 2D array with elements from the original array
        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] original1 = {1, 2, 3, 4};
        int m1 = 2;
        int n1 = 2;
        int[][] result1 = solution.construct2DArray(original1, m1, n1);
        System.out.println("Test Case 1 Result:");
        print2DArray(result1); // Expected: [[1, 2], [3, 4]]

        // Test Case 2
        int[] original2 = {1, 2, 3};
        int m2 = 1;
        int n2 = 3;
        int[][] result2 = solution.construct2DArray(original2, m2, n2);
        System.out.println("Test Case 2 Result:");
        print2DArray(result2); // Expected: [[1, 2, 3]]

        // Test Case 3
        int[] original3 = {1, 2};
        int m3 = 1;
        int n3 = 1;
        int[][] result3 = solution.construct2DArray(original3, m3, n3);
        System.out.println("Test Case 3 Result:");
        print2DArray(result3); // Expected: []

        // Test Case 4
        int[] original4 = {1, 2, 3, 4, 5, 6, 7, 8};
        int m4 = 2;
        int n4 = 4;
        int[][] result4 = solution.construct2DArray(original4, m4, n4);
        System.out.println("Test Case 4 Result:");
        print2DArray(result4); // Expected: [[1, 2, 3, 4], [5, 6, 7, 8]]
    }

    /**
     * Utility method to print a 2D array.
     * 
     * @param array The 2D array to be printed.
     */
    public static void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
