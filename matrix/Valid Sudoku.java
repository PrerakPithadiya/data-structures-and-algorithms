
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution for validating a Sudoku board. It includes
 * methods to check if a given 9x9 Sudoku board is valid according to the rules
 * of Sudoku.
 */
class Solution {

    /**
     * Validates whether a given 9x9 Sudoku board is valid.
     *
     * The method checks for the following conditions: 1. Each row must contain
     * the digits 1-9 without repetition. 2. Each column must contain the digits
     * 1-9 without repetition. 3. Each of the nine 3x3 sub-boxes of the grid
     * must contain the digits 1-9 without repetition.
     *
     * @param board a 2D character array representing the Sudoku board
     * @return true if the board is valid, false otherwise
     */
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        // Create 3 arrays of sets to keep track of seen digits in rows, columns, and boxes.
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Initialize the HashSet for each row, column, and box
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse each cell in the board.
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Calculate the index for the corresponding 3x3 sub-box
                int boxIndex = (r / 3) * 3 + c / 3;

                // Check if the number already exists in the row, column, or box
                if (rows[r].contains(num) || cols[c].contains(num) || boxes[boxIndex].contains(num)) {
                    return false; // The board is invalid
                }

                // Add the number to the respective row, column, and box sets
                rows[r].add(num);
                cols[c].add(num);
                boxes[boxIndex].add(num);
            }
        }

        // If no conflicts were found, the board is valid
        return true;
    }

    /**
     * Main method to test the isValidSudoku function with various test cases.
     * This method demonstrates how to use the isValidSudoku method and provides
     * example inputs and expected outputs.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Valid Sudoku board
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test Case 1 - Expected: true, Got: " + solution.isValidSudoku(board1));

        // Test Case 2: Invalid Sudoku board (duplicate number in first row and column)
        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("Test Case 2 - Expected: false, Got: " + solution.isValidSudoku(board2));

        // Additional test cases can be added here to further validate the solution
    }
}
