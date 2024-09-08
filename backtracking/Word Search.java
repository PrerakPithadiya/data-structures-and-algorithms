
/**
 * Solution class for the Word Search problem.
 * This class provides methods to determine if a given word exists in a 2D board of characters.
 */
class Solution {

    /**
     * Determines if a word exists in the given board.
     *
     * @param board The 2D character array representing the board.
     * @param word The word to search for in the board.
     * @return true if the word exists in the board, false otherwise.
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Iterate over every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start backtracking if the first character matches
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false; // No valid path found
    }

    /**
     * Helper method for backtracking to search for the word in the board.
     *
     * @param board The 2D character array representing the board.
     * @param word The word to search for in the board.
     * @param row The current row index in the board.
     * @param col The current column index in the board.
     * @param index The current index in the word being matched.
     * @return true if the remaining part of the word is found from the current
     * position, false otherwise.
     */
    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case: if all characters of the word are found
        if (index == word.length()) {
            return true;
        }

        // Boundary check and character matching check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited by replacing the character
        char temp = board[row][col];
        board[row][col] = '#';  // Mark visited

        // Explore the 4 possible directions: up, down, left, right
        boolean found = backtrack(board, word, row + 1, col, index + 1)
                || // down
                backtrack(board, word, row - 1, col, index + 1)
                || // up
                backtrack(board, word, row, col + 1, index + 1)
                || // right
                backtrack(board, word, row, col - 1, index + 1);   // left

        // Restore the original value for backtracking
        board[row][col] = temp;

        return found;
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board1, "ABCCED"));  // Output: true
        System.out.println(solution.exist(board1, "SEE"));     // Output: true
        System.out.println(solution.exist(board1, "ABCB"));    // Output: false
    }
}
