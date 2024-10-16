
import java.util.*;

/**
 * Solution class for finding all ancestors of nodes in a Directed Acyclic Graph
 * (DAG).
 */
class Solution {

    /**
     * Finds all ancestors for each node in a DAG.
     *
     * @param n The number of nodes in the graph.
     * @param edges The edges of the graph, where each edge is represented as
     * [from, to].
     * @return A list of lists, where the i-th list contains all ancestors of
     * node i in sorted order.
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Step 1: Build the graph as an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(to).add(from); // Reverse the direction to find ancestors
        }

        // Step 2: Prepare the answer list
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answer.add(new ArrayList<>());
        }

        // Step 3: Use DFS to find ancestors
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            findAncestors(i, graph, visited);
            List<Integer> ancestorsList = new ArrayList<>(visited);
            Collections.sort(ancestorsList); // Sort the ancestors
            answer.set(i, ancestorsList);
        }

        return answer;
    }

    /**
     * Recursive DFS helper method to find all ancestors of a node.
     *
     * @param node The current node being explored.
     * @param graph The graph represented as an adjacency list.
     * @param visited A set to keep track of visited (ancestor) nodes.
     */
    private void findAncestors(int node, List<List<Integer>> graph, Set<Integer> visited) {
        // Explore all ancestors of the current node
        for (int ancestor : graph.get(node)) {
            if (visited.add(ancestor)) { // Add ancestor if not visited
                findAncestors(ancestor, graph, visited);
            }
        }
    }

    /**
     * Test cases for the getAncestors method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println("Test case 1:");
        System.out.println(solution.getAncestors(n1, edges1));
        // Expected output: [[], [0], [0], [0, 1, 2]]

        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println("Test case 2:");
        System.out.println(solution.getAncestors(n2, edges2));
        // Expected output: [[], [0], [0], [0, 1, 2], [0, 1, 2, 3]]

        // Test case 3
        int n3 = 3;
        int[][] edges3 = {{0, 1}, {1, 2}};
        System.out.println("Test case 3:");
        System.out.println(solution.getAncestors(n3, edges3));
        // Expected output: [[], [0], [0, 1]]
    }
}
