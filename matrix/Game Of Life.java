
/**
 * This class implements Conway's Game of Life, a cellular automaton simulation.
 * The game is played on a 2D grid where each cell is either alive or dead.
 * The state of each cell in the next generation is determined by its current state
 * and the number of live neighbors it has.
 */
class GameOfLife {

    /**
     * Directions for the 8 neighboring cells. Each inner array represents a
     * direction as [row_offset, col_offset].
     */
    private static final int[][] directions = {
        {0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}
    };

    /**
     * Applies the rules of Conway's Game of Life to the given board. This
     * method modifies the input board in-place to represent the next
     * generation.
     *
     * @param board A 2D integer array representing the current state of the
     * board. 1 represents a live cell, 0 represents a dead cell.
     */
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Iterate through every cell on the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Count the live neighbors of the cell board[i][j]
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);

                // Apply the rules
                if (board[i][j] == 1) {
                    // Case 1 and 3: live cell with fewer than 2 or more than 3 live neighbors dies
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // Mark as 1 -> 0 (will die)
                    }
                } else {
                    // Case 4: dead cell with exactly 3 live neighbors becomes live
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // Mark as 0 -> 1 (will become live)
                    }
                }
            }
        }

        // Final transformation of the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Dead cell (previously 1)
                } else if (board[i][j] == 3) {
                    board[i][j] = 1; // Live cell (previously 0)
                }
            }
        }
    }

    /**
     * Helper function to count the live neighbors of a given cell.
     *
     * @param board The current state of the board.
     * @param i The row index of the current cell.
     * @param j The column index of the current cell.
     * @param m The number of rows in the board.
     * @param n The number of columns in the board.
     * @return The number of live neighbors for the cell at (i, j).
     */
    private int countLiveNeighbors(int[][] board, int i, int j, int m, int n) {
        int liveNeighbors = 0;

        // Check all 8 directions
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];

            // Make sure the neighbor is within the grid bounds
            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                // Check if the cell was originally live (1 or 2 -> live)
                if (board[ni][nj] == 1 || board[ni][nj] == 2) {
                    liveNeighbors++;
                }
            }
        }

        return liveNeighbors;
    }

    /**
     * Main method to demonstrate the usage of the GameOfLife class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife();

        // Example 1
        int[][] board1 = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        System.out.println("Example 1 - Initial State:");
        printBoard(board1);
        game.gameOfLife(board1);
        System.out.println("Example 1 - Next Generation:");
        printBoard(board1);

        // Example 2
        int[][] board2 = {
            {1, 1},
            {1, 0}
        };
        System.out.println("Example 2 - Initial State:");
        printBoard(board2);
        game.gameOfLife(board2);
        System.out.println("Example 2 - Next Generation:");
        printBoard(board2);
    }

    /**
     * Helper function to print the current state of the board.
     *
     * @param board The 2D integer array representing the board to be printed.
     */
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
