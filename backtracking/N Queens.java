
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class solves the N-Queens problem using a backtracking algorithm. The
 * N-Queens problem is the challenge of placing N chess queens on an N×N
 * chessboard so that no two queens threaten each other.
 */
class NQueens {

    /**
     * Solves the N-Queens problem for a given board size.
     *
     * @param n The size of the chessboard (n x n) and the number of queens to
     * place.
     * @return A list of all possible solutions, where each solution is
     * represented as a list of strings.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), n, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0);
        return results;
    }

    /**
     * Recursive backtracking method to find all solutions for the N-Queens
     * problem.
     *
     * @param results The list to store all valid solutions.
     * @param current The current partial solution being built.
     * @param n The size of the chessboard.
     * @param cols Set to keep track of occupied columns.
     * @param diag1 Set to keep track of occupied major diagonals (top-left to
     * bottom-right).
     * @param diag2 Set to keep track of occupied minor diagonals (top-right to
     * bottom-left).
     * @param row The current row being processed.
     */
    private void backtrack(List<List<String>> results, List<String> current, int n, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2, int row) {
        if (row == n) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col; // Major diagonal
            int d2 = row + col; // Minor diagonal

            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2)) {
                continue;
            }

            // Place the queen
            char[] rowArray = new char[n];
            for (int i = 0; i < n; i++) {
                rowArray[i] = '.';
            }
            rowArray[col] = 'Q';
            String rowStr = new String(rowArray);

            // Add this row to the current board
            current.add(rowStr);
            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);

            // Recur to place the next queen
            backtrack(results, current, n, cols, diag1, diag2, row + 1);

            // Backtrack: remove the queen and try next position
            current.remove(current.size() - 1);
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }

    /**
     * Main method to demonstrate the usage of the NQueens class. It solves the
     * N-Queens problem for a 4x4 board and prints all solutions.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int n = 4; // Size of the chessboard
        List<List<String>> solutions = nQueens.solveNQueens(n);

        // Print all solutions
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
