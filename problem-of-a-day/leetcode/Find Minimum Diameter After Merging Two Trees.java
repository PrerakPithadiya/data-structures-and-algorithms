
import java.util.*;

/**
 * Solution for finding the minimum diameter after merging two trees. This class
 * provides methods to analyze and merge two trees while minimizing the
 * resulting diameter.
 */
class Solution {

    /**
     * Helper class to store distance and node information for path
     * calculations.
     */
    private static class PathInfo {

        int node;      // Current node identifier
        int distance;  // Distance from starting node

        /**
         * Constructs a PathInfo object with specified node and distance.
         *
         * @param node The node identifier
         * @param distance The distance from starting node
         */
        PathInfo(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    /**
     * Calculates the minimum possible diameter after merging two trees.
     *
     * @param edges1 Edge list representing the first tree
     * @param edges2 Edge list representing the second tree
     * @return The minimum possible diameter after merging
     */
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        // Build adjacency lists for both trees
        List<List<Integer>> tree1 = buildTree(edges1);
        List<List<Integer>> tree2 = buildTree(edges2);

        // Find diameter endpoints and center for tree1
        PathInfo[] tree1Info = findDiameterAndCenter(tree1);
        int tree1Diameter = tree1Info[1].distance;
        int tree1Center = tree1Info[2].node;

        // Find diameter endpoints and center for tree2
        PathInfo[] tree2Info = findDiameterAndCenter(tree2);
        int tree2Diameter = tree2Info[1].distance;
        int tree2Center = tree2Info[2].node;

        // Find max distances from centers
        int maxDist1 = findMaxDistance(tree1, tree1Center);
        int maxDist2 = findMaxDistance(tree2, tree2Center);

        // Return minimum possible diameter
        return Math.max(Math.max(tree1Diameter, tree2Diameter),
                maxDist1 + maxDist2 + 1);
    }

    /**
     * Builds an adjacency list representation of a tree from edge list.
     *
     * @param edges Array of edge connections
     * @return Adjacency list representation of the tree
     */
    private List<List<Integer>> buildTree(int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < edges.length + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    /**
     * Finds diameter endpoints and center of a tree using two DFS traversals.
     *
     * @param tree Adjacency list representation of the tree
     * @return Array of PathInfo containing endpoints and center information
     */
    private PathInfo[] findDiameterAndCenter(List<List<Integer>> tree) {
        PathInfo endPoint1 = dfs(tree, 0, -1)[1];
        PathInfo[] info = dfs(tree, endPoint1.node, -1);
        PathInfo endPoint2 = info[1];
        int center = findCenter(tree, endPoint1.node, endPoint2.node);

        return new PathInfo[]{
            endPoint1,
            endPoint2,
            new PathInfo(center, 0)
        };
    }

    /**
     * Performs DFS to find the farthest node and its distance.
     *
     * @param tree Adjacency list representation of the tree
     * @param node Current node being processed
     * @param parent Parent of current node
     * @return Array of PathInfo containing current and maximum distance
     * information
     */
    private PathInfo[] dfs(List<List<Integer>> tree, int node, int parent) {
        PathInfo current = new PathInfo(node, 0);
        PathInfo maxSoFar = current;

        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                PathInfo[] childInfo = dfs(tree, neighbor, node);
                PathInfo childMax = childInfo[1];
                if (childMax.distance + 1 > maxSoFar.distance) {
                    maxSoFar = new PathInfo(childMax.node, childMax.distance + 1);
                }
            }
        }

        return new PathInfo[]{current, maxSoFar};
    }

    /**
     * Finds the center node of path between two nodes.
     *
     * @param tree Adjacency list representation of the tree
     * @param start Starting node
     * @param end Ending node
     * @return Center node of the path
     */
    private int findCenter(List<List<Integer>> tree, int start, int end) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        List<Integer> path = new ArrayList<>();

        dfsPath(tree, start, end, visited, parent);

        int current = end;
        while (current != start) {
            path.add(current);
            current = parent.get(current);
        }
        path.add(start);

        return path.get(path.size() / 2);
    }

    /**
     * Performs DFS to find path between two nodes.
     *
     * @param tree Adjacency list representation of the tree
     * @param start Starting node
     * @param end Ending node
     * @param visited Set of visited nodes
     * @param parent Map of parent relationships
     * @return True if path is found, false otherwise
     */
    private boolean dfsPath(List<List<Integer>> tree, int start, int end,
            Set<Integer> visited, Map<Integer, Integer> parent) {
        if (start == end) {
            return true;
        }
        visited.add(start);

        for (int neighbor : tree.get(start)) {
            if (!visited.contains(neighbor)) {
                parent.put(neighbor, start);
                if (dfsPath(tree, neighbor, end, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Finds maximum distance from a given starting node.
     *
     * @param tree Adjacency list representation of the tree
     * @param start Starting node
     * @return Maximum distance from starting node
     */
    private int findMaxDistance(List<List<Integer>> tree, int start) {
        return dfs(tree, start, -1)[1].distance;
    }

    /**
     * Main method with test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple trees
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}};
        int[][] edges2 = {{0, 1}, {1, 2}};
        System.out.println("Test Case 1: " + solution.minimumDiameterAfterMerge(edges1, edges2));
        // Expected output: 4

        // Test Case 2: Star-shaped trees
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}};
        int[][] edges4 = {{0, 1}, {0, 2}};
        System.out.println("Test Case 2: " + solution.minimumDiameterAfterMerge(edges3, edges4));
        // Expected output: 3

        // Test Case 3: Complex trees
        int[][] edges5 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] edges6 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println("Test Case 3: " + solution.minimumDiameterAfterMerge(edges5, edges6));
        // Expected output: 6
    }
}
