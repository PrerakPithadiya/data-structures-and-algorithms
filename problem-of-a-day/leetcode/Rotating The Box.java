package LeetCode;

/**
 * Solution for LeetCode problem: Rotating the Box
 *
 * Given an m x n 2D box array where: - '#' represents a stone - '*' represents
 * a stationary obstacle - '.' represents an empty cell
 *
 * The box is rotated 90 degrees clockwise, causing the stones to fall due to
 * gravity. Stones will fall until they hit an obstacle or rest on another
 * stone.
 */
class Solution {

    /**
     * Rotates the box 90 degrees clockwise and applies gravity to the stones.
     *
     * @param box The input box array where box[i][j] represents cell at row i,
     * column j
     * @return The rotated box array after applying gravity
     */
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        // Create the rotated box with dimensions swapped
        char[][] rotatedBox = new char[n][m];

        // Process each row in the original box
        for (int i = 0; i < m; i++) {
            int emptyIndex = n - 1; // Position where the next stone will fall

            // Traverse the row from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Obstacle remains in place; reset emptyIndex
                    emptyIndex = j - 1;
                } else if (box[i][j] == '#') {
                    // Move the stone to the furthest empty position
                    box[i][j] = '.';
                    box[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with stones and obstacles
        char[][] test1 = {
            {'#', '.', '#', '*'},
            {'#', '#', '*', '.'},
            {'#', '.', '.', '#'}
        };
        System.out.println("Test Case 1:");
        printBox(solution.rotateTheBox(test1));

        // Test Case 2: Empty box
        char[][] test2 = {
            {'.', '.', '.'},
            {'.', '.', '.'}
        };
        System.out.println("\nTest Case 2:");
        printBox(solution.rotateTheBox(test2));

        // Test Case 3: Single row
        char[][] test3 = {
            {'#', '*', '#', '#', '.', '*', '.'}
        };
        System.out.println("\nTest Case 3:");
        printBox(solution.rotateTheBox(test3));
    }

    /**
     * Helper method to print the box array
     */
    private static void printBox(char[][] box) {
        for (char[] row : box) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
