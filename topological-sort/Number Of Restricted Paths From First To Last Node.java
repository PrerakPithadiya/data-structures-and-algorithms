
import java.util.*;

/**
 * Solution class for counting restricted paths from the first to the last node
 * in a weighted graph.
 */
class Solution {

    private static final int MOD = 1_000_000_007;

    /**
     * Counts the number of restricted paths from node 1 to node n in a weighted
     * graph.
     *
     * @param n The number of nodes in the graph.
     * @param edges An array of edges, where each edge is [u, v, weight].
     * @return The number of restricted paths from node 1 to node n.
     */
    public int countRestrictedPaths(int n, int[][] edges) {
        // Create the adjacency list for the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], weight = edge[2];
            graph.get(u).add(new int[]{v, weight});
            graph.get(v).add(new int[]{u, weight});
        }

        // Step 1: Use Dijkstra's algorithm to find shortest paths from node n
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[n] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{n, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (dist > distance[node]) {
                continue;
            }

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                if (distance[node] + edgeWeight < distance[nextNode]) {
                    distance[nextNode] = distance[node] + edgeWeight;
                    pq.offer(new int[]{nextNode, distance[nextNode]});
                }
            }
        }

        // Step 2: Use DFS to count restricted paths from node 1 to node n
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(1, n, graph, distance, memo);
    }

    /**
     * Performs a depth-first search to count restricted paths.
     *
     * @param current The current node.
     * @param target The target node (n).
     * @param graph The adjacency list representation of the graph.
     * @param distance The array of shortest distances from node n.
     * @param memo Memoization map to store intermediate results.
     * @return The number of restricted paths from the current node to the
     * target.
     */
    private int dfs(int current, int target, List<List<int[]>> graph, int[] distance, Map<Integer, Integer> memo) {
        if (current == target) {
            return 1; // Found a path to the target
        }
        if (memo.containsKey(current)) {
            return memo.get(current); // Return cached result
        }
        int count = 0;
        for (int[] neighbor : graph.get(current)) {
            int nextNode = neighbor[0];
            if (distance[current] > distance[nextNode]) { // Check the restricted path condition
                count = (count + dfs(nextNode, target, graph, distance, memo)) % MOD;
            }
        }
        memo.put(current, count);
        return count;
    }

    /**
     * Test cases for the countRestrictedPaths method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}};
        int expected1 = 3;
        int result1 = solution.countRestrictedPaths(n1, edges1);
        System.out.println("Test case 1: " + (result1 == expected1 ? "PASSED" : "FAILED"));

        // Test case 2
        int n2 = 7;
        int[][] edges2 = {{1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}};
        int expected2 = 1;
        int result2 = solution.countRestrictedPaths(n2, edges2);
        System.out.println("Test case 2: " + (result2 == expected2 ? "PASSED" : "FAILED"));

        // Test case 3
        int n3 = 3;
        int[][] edges3 = {{1, 2, 1}, {2, 3, 1}};
        int expected3 = 1;
        int result3 = solution.countRestrictedPaths(n3, edges3);
        System.out.println("Test case 3: " + (result3 == expected3 ? "PASSED" : "FAILED"));
    }
}
