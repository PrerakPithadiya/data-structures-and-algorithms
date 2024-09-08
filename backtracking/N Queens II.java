
/**
 * Solution class for solving the N-Queens problem and counting the number of valid solutions.
 * The N-Queens problem is the challenge of placing N chess queens on an N×N chessboard
 * so that no two queens threaten each other.
 */
class Solution {

    /**
     * Counter for the number of valid solutions found
     */
    private int count = 0;

    /**
     * Calculates the total number of distinct solutions to the N-Queens
     * problem.
     *
     * @param n The size of the chessboard (n x n) and the number of queens to
     * place.
     * @return The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];        // Columns where queens are placed
        boolean[] diag1 = new boolean[2 * n];   // Diagonal "/" 
        boolean[] diag2 = new boolean[2 * n];   // Diagonal "\"
        backtrack(0, n, cols, diag1, diag2);    // Start backtracking
        return count;
    }

    /**
     * Recursive backtracking method to explore all possible queen placements.
     *
     * @param row The current row being processed.
     * @param n The size of the chessboard.
     * @param cols Array to track occupied columns.
     * @param diag1 Array to track occupied "/" diagonals.
     * @param diag2 Array to track occupied "\" diagonals.
     */
    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;   // Found a valid solution
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;  // Index for the "/" diagonal
            int d2 = row + col;      // Index for the "\" diagonal
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;   // Skip if there's a conflict
            }

            // Place the queen and mark the columns and diagonals as occupied
            cols[col] = diag1[d1] = diag2[d2] = true;
            // Move to the next row
            backtrack(row + 1, n, cols, diag1, diag2);
            // Backtrack: Remove the queen and mark the columns and diagonals as free
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(4));  // Example 1: Output is 2
        System.out.println(solution.totalNQueens(1));  // Example 2: Output is 1
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * totalNQueens method with the desired board size as the argument. 3. The
 * method will return the total number of distinct solutions for the given board
 * size.
 *
 * Example: Solution solution = new Solution(); int result =
 * solution.totalNQueens(4); System.out.println(result); // This will print the
 * number of solutions for a 4x4 board
 *
 * Note: The time complexity of this solution is O(N!), where N is the size of
 * the board. This is because in the worst case, we need to try all possible
 * combinations of queen placements. The space complexity is O(N) for the
 * recursive call stack and the boolean arrays used for tracking.
 */
