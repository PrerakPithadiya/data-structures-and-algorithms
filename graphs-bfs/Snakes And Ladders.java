
import java.util.*;

/**
 * This class provides a solution to the Snakes and Ladders problem using
 * Breadth-First Search (BFS). The problem involves finding the minimum number
 * of moves required to reach the last square on a Snakes and Ladders board,
 * given the positions of snakes and ladders.
 */
class Solution {

    /**
     * Calculates the minimum number of moves required to reach the last square
     * on the board.
     *
     * @param board A 2D integer array representing the Snakes and Ladders
     * board. -1 represents a normal square, other values represent the
     * destination of a snake or ladder.
     * @return The minimum number of moves to reach the last square, or -1 if
     * it's impossible.
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Convert from 1D index to 2D coordinates
        int[] flatten = flattenBoard(board);

        // BFS setup
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // Start at square 1 with 0 moves
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int square = current[0];
            int moves = current[1];

            // If we've reached the final square, return the number of moves
            if (square == n * n) {
                return moves;
            }

            // Try all dice rolls from 1 to 6
            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                if (nextSquare > n * n) {
                    break; // Stay within board limits
                }
                // If there's a snake or ladder, move to its destination
                if (flatten[nextSquare] != -1) {
                    nextSquare = flatten[nextSquare];
                }

                // If not visited, add to queue
                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }

        // If it's not possible to reach the final square
        return -1;
    }

    /**
     * Flattens the 2D board into a 1D array for easier processing.
     *
     * @param board The 2D board to flatten.
     * @return A 1D array representing the flattened board.
     */
    private int[] flattenBoard(int[][] board) {
        int n = board.length;
        int[] flatten = new int[n * n + 1];
        boolean leftToRight = true;
        int idx = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flatten[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flatten[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        return flatten;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal board with snakes and ladders
        int[][] board1 = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        System.out.println("Test case 1 result: " + solution.snakesAndLadders(board1)); // Expected output: 4

        // Test case 2: Board with no snakes or ladders
        int[][] board2 = {
            {-1, -1},
            {-1, -1}
        };
        System.out.println("Test case 2 result: " + solution.snakesAndLadders(board2)); // Expected output: 1

        // Test case 3: Board with a snake at the last square
        int[][] board3 = {
            {-1, -1, -1},
            {-1, -1, -1},
            {-1, -1, 1}
        };
        System.out.println("Test case 3 result: " + solution.snakesAndLadders(board3)); // Expected output: -1
    }
}
