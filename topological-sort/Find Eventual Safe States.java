
import java.util.*;

/**
 * Solution class for finding eventual safe nodes in a graph.
 */
class Solution {

    /**
     * Finds all eventual safe nodes in the given graph. A safe node is a node
     * from which every path leads to a terminal node (a node with no outgoing
     * edges).
     *
     * @param graph The input graph represented as an adjacency list.
     * @return A list of all safe nodes in ascending order.
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[n];

        // Initialize reverseGraph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build the reverse graph and compute outdegree for each node
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i); // Reverse the edge
            }
            outdegree[i] = graph[i].length; // Original outdegree of node i
        }

        // Queue to perform BFS on nodes with 0 outdegree (terminal nodes)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i); // Terminal nodes
            }
        }

        // List to store safe nodes
        List<Integer> safeNodes = new ArrayList<>();

        // BFS to reduce outdegree of neighbors in the reverse graph
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node); // This node is safe

            // Traverse the reversed graph
            for (int neighbor : reverseGraph.get(node)) {
                outdegree[neighbor]--;
                if (outdegree[neighbor] == 0) {
                    queue.offer(neighbor); // If outdegree becomes 0, it's safe
                }
            }
        }

        // Sort the result in ascending order
        Collections.sort(safeNodes);

        return safeNodes;
    }

    /**
     * Test cases for the eventualSafeNodes method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] graph1 = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println("Test case 1:");
        System.out.println("Input: " + Arrays.deepToString(graph1));
        System.out.println("Output: " + solution.eventualSafeNodes(graph1));
        System.out.println("Expected: [2, 4, 5, 6]");

        // Test case 2
        int[][] graph2 = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + Arrays.deepToString(graph2));
        System.out.println("Output: " + solution.eventualSafeNodes(graph2));
        System.out.println("Expected: [4]");

        // Test case 3
        int[][] graph3 = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + Arrays.deepToString(graph3));
        System.out.println("Output: " + solution.eventualSafeNodes(graph3));
        System.out.println("Expected: [0, 1, 2, 3, 4]");
    }
}
