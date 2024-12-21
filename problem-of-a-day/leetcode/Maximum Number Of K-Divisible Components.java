
import java.util.*;

/**
 * Solution class for finding the maximum number of k-divisible components in a
 * tree.
 *
 * Problem Description: Given a tree with n nodes, where each node has a value,
 * find the maximum number of components such that the sum of values in each
 * component is divisible by k. A component is formed by cutting edges in the
 * tree such that the remaining connected subgraphs have sums divisible by k.
 *
 * Time Complexity: O(n) where n is the number of nodes Space Complexity: O(n)
 * for the adjacency list and recursion stack
 *
 * Example 1: Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]], values =
 * [1,2,3,4,5], k = 2 Output: 3 Explanation: Can be divided into components with
 * sums: [1,2,3], [4], [5]
 *
 * Example 2: Input: n = 4, edges = [[0,1],[1,2],[1,3]], values = [2,4,6,8], k =
 * 2 Output: 4 Explanation: Each node can be its own component as all values are
 * even
 */
class Solution {

    /**
     * Finds the maximum number of k-divisible components in a tree. A component
     * is considered k-divisible if the sum of all node values in that component
     * is divisible by k.
     *
     * Algorithm: 1. Build an adjacency list representation of the tree 2.
     * Perform DFS traversal to compute subtree sums 3. For each subtree with
     * sum divisible by k, increment component count
     *
     * @param n Number of nodes in the tree (1 ≤ n ≤ 3 * 10^4)
     * @param edges Array of edges where edges[i] = [ai, bi] represents an edge
     * between nodes ai and bi
     * @param values Array of integer values for each node (-10^9 ≤ values[i] ≤
     * 10^9)
     * @param k The divisor for k-divisibility (1 ≤ k ≤ 10^9)
     * @return The maximum number of k-divisible components possible
     *
     * @throws IllegalArgumentException if input parameters are invalid
     */
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Input validation
        if (n < 1 || values.length != n || (n > 1 && edges.length != n - 1)) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        // Step 1: Build adjacency list for the tree
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // Step 2: Initialize component counter
        int[] componentCount = new int[1]; // Array used to allow pass-by-reference

        // Step 3: Start DFS traversal from the root node (node 0)
        dfs(0, -1, adjList, values, k, componentCount);

        // Step 4: Return the total number of components
        return componentCount[0];
    }

    /**
     * DFS helper function to calculate subtree sums and count k-divisible
     * components. This method traverses the tree in a depth-first manner,
     * computing the sum of values in each subtree and identifying k-divisible
     * components.
     *
     * @param currentNode Current node being processed
     * @param parentNode Parent node to avoid revisiting
     * @param adjList Adjacency list representing the tree
     * @param nodeValues Array of node values
     * @param k The divisor for k-divisibility
     * @param componentCount Array to track the number of k-divisible components
     * @return The sum of the subtree rooted at the current node (modulo k)
     */
    private int dfs(int currentNode, int parentNode, List<List<Integer>> adjList, int[] nodeValues, int k, int[] componentCount) {
        // Initialize the sum for the current subtree
        int subtreeSum = 0;

        // Traverse all neighboring nodes
        for (int neighbor : adjList.get(currentNode)) {
            if (neighbor != parentNode) {
                // Recursively process the subtree rooted at the neighbor
                subtreeSum += dfs(neighbor, currentNode, adjList, nodeValues, k, componentCount);
                subtreeSum %= k; // Keep the sum within bounds
            }
        }

        // Add the current node's value to the subtree sum
        subtreeSum += nodeValues[currentNode];
        subtreeSum %= k;

        // If the subtree sum is divisible by k, increment the component count
        if (subtreeSum == 0) {
            componentCount[0]++;
        }

        // Return the sum of the current subtree
        return subtreeSum;
    }

    /**
     * Test cases for the maxKDivisibleComponents method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with even/odd values
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[] values1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        assert solution.maxKDivisibleComponents(n1, edges1, values1, k1) == 3;

        // Test Case 2: All values divisible by k
        int n2 = 4;
        int[][] edges2 = {{0, 1}, {1, 2}, {1, 3}};
        int[] values2 = {2, 4, 6, 8};
        int k2 = 2;
        assert solution.maxKDivisibleComponents(n2, edges2, values2, k2) == 4;

        // Test Case 3: Single node
        int n3 = 1;
        int[][] edges3 = {};
        int[] values3 = {4};
        int k3 = 2;
        assert solution.maxKDivisibleComponents(n3, edges3, values3, k3) == 1;

        // Test Case 4: Large k value
        int n4 = 3;
        int[][] edges4 = {{0, 1}, {1, 2}};
        int[] values4 = {1, 2, 3};
        int k4 = 6;
        assert solution.maxKDivisibleComponents(n4, edges4, values4, k4) == 1;

        System.out.println("All test cases passed!");
    }
}
