
import java.util.*;

/**
 * Solution class for finding the path with maximum probability in a graph.
 */
class Solution {

    /**
     * Finds the maximum probability of reaching the end node from the start
     * node.
     *
     * @param n The number of nodes in the graph.
     * @param edges An array of edges, where each edge is represented by a pair
     * of nodes.
     * @param succProb An array of success probabilities corresponding to each
     * edge.
     * @param start The starting node.
     * @param end The ending node.
     * @return The maximum probability of reaching the end node from the start
     * node.
     */
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        // Create a graph as adjacency list
        Map<Integer, List<int[]>> graph = createGraph(n, edges);

        // Priority queue for max probability path
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1.0});

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int node = (int) current[0];
            double prob = current[1];

            // If we reached the end node, return the probability
            if (node == end) {
                return prob;
            }

            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                double nextProb = prob * succProb[neighbor[1]];

                if (nextProb > maxProb[nextNode]) {
                    maxProb[nextNode] = nextProb;
                    pq.offer(new double[]{nextNode, nextProb});
                }
            }
        }

        // If the end node was never reached, return 0
        return 0.0;
    }

    /**
     * Creates a graph representation using an adjacency list.
     *
     * @param n The number of nodes in the graph.
     * @param edges An array of edges, where each edge is represented by a pair
     * of nodes.
     * @return A Map representing the graph as an adjacency list.
     */
    private Map<Integer, List<int[]>> createGraph(int n, int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.get(u).add(new int[]{v, i});
            graph.get(v).add(new int[]{u, i});
        }
        return graph;
    }
}
