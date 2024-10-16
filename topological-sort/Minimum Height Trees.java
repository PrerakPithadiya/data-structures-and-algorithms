
import java.util.*;

/**
 * Solution class for finding Minimum Height Trees (MHTs) in an undirected
 * graph.
 */
class Solution {

    /**
     * Finds the roots of all possible Minimum Height Trees in an undirected
     * graph.
     *
     * @param n The number of nodes in the graph (labeled from 0 to n-1).
     * @param edges An array of edge connections, where each edge is represented
     * by a pair of nodes.
     * @return A list of node labels that could be roots of Minimum Height
     * Trees.
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0); // Only one node, it's the MHT root
        }

        // Create an adjacency list for the graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Initialize leaves: nodes with only one connection (degree == 1)
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // Remove leaves layer by layer
        while (n > 2) {
            n -= leaves.size(); // Update the number of remaining nodes
            List<Integer> newLeaves = new ArrayList<>();

            for (int leaf : leaves) {
                // Get the only neighbor of the leaf
                int neighbor = graph.get(leaf).iterator().next();
                // Remove the edge between the leaf and the neighbor
                graph.get(neighbor).remove(leaf);

                // If the neighbor becomes a leaf (degree == 1), add it to new leaves
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }

            // Move to the next layer of leaves
            leaves = newLeaves;
        }

        // The remaining nodes are the roots of the MHTs
        return leaves;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println("Test case 1:");
        System.out.println("Input: n = " + n1 + ", edges = " + Arrays.deepToString(edges1));
        System.out.println("Output: " + solution.findMinHeightTrees(n1, edges1));
        System.out.println("Expected: [1]");

        // Test case 2
        int n2 = 6;
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println("\nTest case 2:");
        System.out.println("Input: n = " + n2 + ", edges = " + Arrays.deepToString(edges2));
        System.out.println("Output: " + solution.findMinHeightTrees(n2, edges2));
        System.out.println("Expected: [3, 4]");

        // Test case 3
        int n3 = 1;
        int[][] edges3 = {};
        System.out.println("\nTest case 3:");
        System.out.println("Input: n = " + n3 + ", edges = " + Arrays.deepToString(edges3));
        System.out.println("Output: " + solution.findMinHeightTrees(n3, edges3));
        System.out.println("Expected: [0]");
    }
}
