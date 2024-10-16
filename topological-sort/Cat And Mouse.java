
import java.util.*;

/**
 * Solution class for the Cat and Mouse game. This class implements a solution
 * to determine the winner of the Cat and Mouse game using a graph
 * representation and dynamic programming approach.
 */
class Solution {

    /**
     * Determines the winner of the Cat and Mouse game.
     *
     * @param graph An array of integer arrays representing the graph of the
     * game. graph[i] contains the list of nodes that can be reached from node
     * i.
     * @return An integer representing the game result: 0 - Draw 1 - Mouse wins
     * 2 - Cat wins
     */
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][][] dp = new int[n][n][3]; // dp[mouse][cat][turn]: 0 -> draw, 1 -> mouse win, 2 -> cat win

        // BFS setup
        Queue<int[]> queue = new LinkedList<>();

        // Initialize base cases
        // Mouse wins if it is at the hole
        for (int cat = 0; cat < n; cat++) {
            for (int turn = 1; turn <= 2; turn++) {
                dp[0][cat][turn] = 1; // Mouse wins if at hole
                queue.offer(new int[]{0, cat, turn, 1}); // Mouse wins
            }
        }

        // Cat wins if it catches the mouse
        for (int mouse = 1; mouse < n; mouse++) {
            for (int turn = 1; turn <= 2; turn++) {
                dp[mouse][mouse][turn] = 2; // Cat wins if catches the mouse
                queue.offer(new int[]{mouse, mouse, turn, 2}); // Cat wins
            }
        }

        // Process the queue
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int mouse = state[0], cat = state[1], turn = state[2], result = state[3];

            // Process the previous states
            if (turn == 1) { // Previous turn is Cat's turn
                for (int prevCat : graph[cat]) {
                    if (prevCat == 0) {
                        continue; // Cat cannot go to the hole
                    }
                    if (dp[mouse][prevCat][2] == 0) { // If it's not determined yet
                        // If the result of this state guarantees the other player's loss
                        if (result == 2) {
                            dp[mouse][prevCat][2] = 2; // Cat wins
                            queue.offer(new int[]{mouse, prevCat, 2, 2});
                        } else if (allNextLose(mouse, prevCat, 2, graph, dp)) {
                            dp[mouse][prevCat][2] = 1; // Mouse wins
                            queue.offer(new int[]{mouse, prevCat, 2, 1});
                        }
                    }
                }
            } else { // Previous turn is Mouse's turn
                for (int prevMouse : graph[mouse]) {
                    if (dp[prevMouse][cat][1] == 0) { // If it's not determined yet
                        // If the result of this state guarantees the other player's loss
                        if (result == 1) {
                            dp[prevMouse][cat][1] = 1; // Mouse wins
                            queue.offer(new int[]{prevMouse, cat, 1, 1});
                        } else if (allNextLose(prevMouse, cat, 1, graph, dp)) {
                            dp[prevMouse][cat][1] = 2; // Cat wins
                            queue.offer(new int[]{prevMouse, cat, 1, 2});
                        }
                    }
                }
            }
        }

        // Return the result from the start state
        return dp[1][2][1];
    }

    /**
     * Helper function to check if all possible next moves of the player lose.
     *
     * @param mouse The current position of the mouse.
     * @param cat The current position of the cat.
     * @param turn The current turn (1 for mouse, 2 for cat).
     * @param graph The graph representation of the game.
     * @param dp The dynamic programming array storing game states.
     * @return true if all next moves lead to a loss for the current player,
     * false otherwise.
     */
    private boolean allNextLose(int mouse, int cat, int turn, int[][] graph, int[][][] dp) {
        if (turn == 1) { // Mouse's turn, check if all Cat's moves lead to Mouse's win
            for (int nextMouse : graph[mouse]) {
                if (dp[nextMouse][cat][2] != 2) {
                    return false; // Found a move where Cat doesn't win
                }
            }
        } else { // Cat's turn, check if all Mouse's moves lead to Cat's win
            for (int nextCat : graph[cat]) {
                if (nextCat == 0) {
                    continue; // Cat cannot go to the hole
                }
                if (dp[mouse][nextCat][1] != 1) {
                    return false; // Found a move where Mouse doesn't win
                }
            }
        }
        return true;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] graph1 = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        System.out.println("Test case 1 result: " + solution.catMouseGame(graph1)); // Expected output: 0

        // Test case 2
        int[][] graph2 = {{1, 3}, {0}, {3}, {0, 2}};
        System.out.println("Test case 2 result: " + solution.catMouseGame(graph2)); // Expected output: 1

        // Test case 3
        int[][] graph3 = {{2, 3}, {3, 4}, {0, 4}, {0, 1}, {1, 2}};
        System.out.println("Test case 3 result: " + solution.catMouseGame(graph3)); // Expected output: 1
    }
}
