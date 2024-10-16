
import java.util.*;

/**
 * Solution class for the "Loud and Rich" problem. This class provides a method
 * to find the quietest person among the richer or equally rich people for each
 * person.
 */
class Solution {

    /**
     * Finds the quietest person among the richer or equally rich people for
     * each person.
     *
     * @param richer 2D array where richer[i] = [a, b] means person a is richer
     * than person b
     * @param quiet array where quiet[i] is the quietness value of person i
     * @return array where answer[i] is the quietest person among the richer or
     * equally rich people for person i
     */
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        // Create a graph where richer[i] = [a, b] means a -> b
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the adjacency list for the graph
        for (int[] pair : richer) {
            graph.get(pair[1]).add(pair[0]); // Person pair[1] has richer neighbors (person pair[0])
        }

        // Array to store the result
        int[] answer = new int[n];
        Arrays.fill(answer, -1); // Initialize the answer array with -1

        // DFS function to find the quietest person who is richer than or equal to current node
        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, answer);
        }

        return answer;
    }

    /**
     * Depth-First Search to find the quietest person among the richer or
     * equally rich people.
     *
     * @param node current person being processed
     * @param graph adjacency list representation of the richer relationships
     * @param quiet array of quietness values
     * @param answer array to store the result
     * @return the index of the quietest person among the richer or equally rich
     * people
     */
    private int dfs(int node, List<List<Integer>> graph, int[] quiet, int[] answer) {
        // If the answer for this node is already calculated, return it
        if (answer[node] != -1) {
            return answer[node];
        }

        // Initially, the quietest person is the current person
        answer[node] = node;

        // Explore the richer neighbors
        for (int neighbor : graph.get(node)) {
            int quietestRicherPerson = dfs(neighbor, graph, quiet, answer);
            if (quiet[quietestRicherPerson] < quiet[answer[node]]) {
                answer[node] = quietestRicherPerson; // Update the quietest person if a quieter richer person is found
            }
        }

        return answer[node];
    }

    /**
     * Test cases for the loudAndRich method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] richer1 = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet1 = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] result1 = solution.loudAndRich(richer1, quiet1);
        System.out.println("Test case 1 result: " + Arrays.toString(result1));
        // Expected output: [5,5,2,5,4,5,6,7]

        // Test case 2
        int[][] richer2 = {};
        int[] quiet2 = {0};
        int[] result2 = solution.loudAndRich(richer2, quiet2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2));
        // Expected output: [0]

        // Test case 3
        int[][] richer3 = {{0, 1}, {1, 2}};
        int[] quiet3 = {0, 1, 2};
        int[] result3 = solution.loudAndRich(richer3, quiet3);
        System.out.println("Test case 3 result: " + Arrays.toString(result3));
        // Expected output: [0,0,0]
    }
}
