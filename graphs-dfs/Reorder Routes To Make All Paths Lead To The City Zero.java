
/**
 * This class provides a solution to the problem of reordering routes to make all paths lead to city zero.
 */
import java.util.*;

class Solution {

    /**
     * Calculates the minimum number of edges that need to be reversed to make
     * all paths lead to city zero.
     *
     * @param n The number of cities (0 to n-1)
     * @param connections An array of connections between cities, where
     * connections[i] = [from, to] represents a road from city 'from' to city
     * 'to'
     * @return The minimum number of edges that need to be reversed
     */
    public int minReorder(int n, int[][] connections) {
        // Create an adjacency list to represent the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with direction information
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1}); // original direction
            graph.get(to).add(new int[]{from, 0}); // reverse direction
        }

        // Perform BFS to count the needed reversals
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] neighbor : graph.get(city)) {
                int nextCity = neighbor[0];
                int needsReversal = neighbor[1];

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    result += needsReversal;
                    queue.offer(nextCity);
                }
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the minReorder method with
     * example inputs.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 6;
        int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(solution.minReorder(n1, connections1)); // Output: 3

        // Example 2
        int n2 = 5;
        int[][] connections2 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        System.out.println(solution.minReorder(n2, connections2)); // Output: 2

        // Example 3
        int n3 = 3;
        int[][] connections3 = {{1, 0}, {2, 0}};
        System.out.println(solution.minReorder(n3, connections3)); // Output: 0
    }
}
