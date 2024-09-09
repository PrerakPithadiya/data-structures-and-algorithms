
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class solves the problem of finding critical connections in a network. A
 * critical connection is an edge whose removal would disconnect the network.
 */
class CriticalConnections {

    private int time;
    private List<List<Integer>> bridges;
    private int[] discovery;
    private int[] low;
    private boolean[] visited;
    private List<List<Integer>> graph;

    /**
     * Finds all critical connections in a network.
     *
     * @param n The number of nodes in the network.
     * @param connections A list of edges connecting the nodes.
     * @return A list of critical connections.
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // Initialize the graph
        initializeGraph(n);

        // Build the adjacency list
        buildAdjacencyList(connections);

        // Initialize arrays for DFS
        initializeDFSArrays(n);

        // Perform DFS from each unvisited node
        performDFS(n);

        return bridges;
    }

    /**
     * Initializes the graph with empty adjacency lists for each node.
     *
     * @param n The number of nodes in the network.
     */
    private void initializeGraph(int n) {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    /**
     * Builds the adjacency list representation of the graph.
     *
     * @param connections A list of edges connecting the nodes.
     */
    private void buildAdjacencyList(List<List<Integer>> connections) {
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    /**
     * Initializes arrays used in the DFS algorithm.
     *
     * @param n The number of nodes in the network.
     */
    private void initializeDFSArrays(int n) {
        discovery = new int[n];
        low = new int[n];
        visited = new boolean[n];
        bridges = new ArrayList<>();
        time = 0;
    }

    /**
     * Performs DFS from each unvisited node in the graph.
     *
     * @param n The number of nodes in the network.
     */
    private void performDFS(int n) {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
    }

    /**
     * Depth-First Search (DFS) algorithm to find critical connections.
     *
     * @param u The current node being visited.
     * @param parent The parent of the current node in the DFS tree.
     */
    private void dfs(int u, int parent) {
        visited[u] = true;
        discovery[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, u);

                // Update the lowest reachable ancestor for u
                low[u] = Math.min(low[u], low[v]);

                // Check if the edge (u, v) is a bridge
                if (low[v] > discovery[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else if (v != parent) {
                // Update low value of u for parent function calls
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }

    /**
     * Main method to demonstrate the usage of the CriticalConnections class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        CriticalConnections cc = new CriticalConnections();

        // Example 1
        List<List<Integer>> connections1 = new ArrayList<>();
        connections1.add(Arrays.asList(0, 1));
        connections1.add(Arrays.asList(1, 2));
        connections1.add(Arrays.asList(2, 0));
        connections1.add(Arrays.asList(1, 3));
        System.out.println(cc.criticalConnections(4, connections1)); // Output: [[1, 3]]

        // Example 2
        List<List<Integer>> connections2 = new ArrayList<>();
        connections2.add(Arrays.asList(0, 1));
        System.out.println(cc.criticalConnections(2, connections2)); // Output: [[0, 1]]
    }
}
