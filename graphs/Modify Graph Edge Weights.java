
import java.util.*;

/**
 * This class provides a solution for modifying graph edge weights to achieve a
 * specific target distance between a source and destination node.
 */
class Solution {

    /**
     * Modifies the edge weights of a graph to achieve a target distance between
     * source and destination.
     *
     * @param n The number of nodes in the graph.
     * @param edges The array of edges, where each edge is [nodeA, nodeB,
     * weight].
     * @param source The source node.
     * @param destination The destination node.
     * @param target The target distance between source and destination.
     * @return The modified edges array, or an empty array if it's impossible to
     * achieve the target.
     */
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjacencyList = buildAdjacencyList(n, edges);
        int[][] distances = initializeDistances(n, source);

        runDijkstra(adjacencyList, edges, distances, source, 0, 0);
        long difference = (long) target - distances[destination][0];
        if (difference < 0) {
            return new int[][]{};
        }
        runDijkstra(adjacencyList, edges, distances, source, difference, 1);
        if (distances[destination][1] < target) {
            return new int[][]{};
        }

        return finalizeEdges(edges);
    }

    /**
     * Builds an adjacency list representation of the graph.
     *
     * @param n The number of nodes in the graph.
     * @param edges The array of edges.
     * @return The adjacency list representation of the graph.
     */
    private List<int[]>[] buildAdjacencyList(int n, int[][] edges) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int nodeA = edges[i][0], nodeB = edges[i][1];
            adjacencyList[nodeA].add(new int[]{nodeB, i});
            adjacencyList[nodeB].add(new int[]{nodeA, i});
        }
        return adjacencyList;
    }

    /**
     * Initializes the distances array for Dijkstra's algorithm.
     *
     * @param n The number of nodes in the graph.
     * @param source The source node.
     * @return The initialized distances array.
     */
    private int[][] initializeDistances(int n, int source) {
        int[][] distances = new int[n][2];
        Arrays.fill(distances[source], 0);
        for (int i = 0; i < n; i++) {
            if (i != source) {
                distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
            }
        }
        return distances;
    }

    /**
     * Runs Dijkstra's algorithm on the graph.
     *
     * @param adjacencyList The adjacency list representation of the graph.
     * @param edges The array of edges.
     * @param distances The distances array to be updated.
     * @param source The source node.
     * @param difference The difference to be added to -1 weighted edges.
     * @param run The current run (0 or 1) of the algorithm.
     */
    private void runDijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] distances, int source, long difference, int run) {
        int n = adjacencyList.length;
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        priorityQueue.add(new long[]{source, 0});
        distances[source][run] = 0;

        while (!priorityQueue.isEmpty()) {
            long[] current = priorityQueue.poll();
            int currentNode = (int) current[0];
            long currentDistance = current[1];

            if (currentDistance > distances[currentNode][run]) {
                continue;
            }

            for (int[] neighbor : adjacencyList[currentNode]) {
                int nextNode = neighbor[0], edgeIndex = neighbor[1];
                long weight = edges[edgeIndex][2];

                if (weight == -1) {
                    weight = 1; // Initially consider -1 as 1
                }
                if (run == 1 && edges[edgeIndex][2] == -1) {
                    long newWeight = difference + distances[nextNode][0] - distances[currentNode][1];
                    if (newWeight > Integer.MAX_VALUE) {
                        newWeight = Integer.MAX_VALUE;
                    }
                    if (newWeight > weight) {
                        edges[edgeIndex][2] = (int) newWeight;
                        weight = newWeight;
                    }
                }

                if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                    distances[nextNode][run] = (int) Math.min((long) distances[currentNode][run] + weight, Integer.MAX_VALUE);
                    priorityQueue.add(new long[]{nextNode, distances[nextNode][run]});
                }
            }
        }
    }

    /**
     * Finalizes the edges array by replacing any remaining -1 weights with 1.
     *
     * @param edges The array of edges to be finalized.
     * @return The finalized edges array.
     */
    private int[][] finalizeEdges(int[][] edges) {
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = 1;
            }
        }
        return edges;
    }

    /**
     * Main method to run test cases for the solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {0, 3, 1}, {0, 4, 1}, {3, 4, -1}, {1, 4, 1}};
        int source1 = 0;
        int destination1 = 1;
        int target1 = 5;
        int[][] result1 = solution.modifiedGraphEdges(n1, edges1, source1, destination1, target1);
        System.out.println("Test case 1 result: " + Arrays.deepToString(result1));

        // Test case 2
        int n2 = 3;
        int[][] edges2 = {{0, 1, -1}, {0, 2, 5}};
        int source2 = 0;
        int destination2 = 2;
        int target2 = 6;
        int[][] result2 = solution.modifiedGraphEdges(n2, edges2, source2, destination2, target2);
        System.out.println("Test case 2 result: " + Arrays.deepToString(result2));

        // Test case 3
        int n3 = 4;
        int[][] edges3 = {{1, 0, 4}, {1, 2, 3}, {2, 3, 5}, {0, 3, -1}};
        int source3 = 0;
        int destination3 = 2;
        int target3 = 6;
        int[][] result3 = solution.modifiedGraphEdges(n3, edges3, source3, destination3, target3);
        System.out.println("Test case 3 result: " + Arrays.deepToString(result3));
    }
}
