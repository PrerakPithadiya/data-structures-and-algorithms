package LeetCode;

import java.util.Arrays;

/**
 * Solution for Shortest Distance After Road Addition Queries Problem: Given a
 * line graph with n nodes (0 to n-1) and queries to add roads, find the
 * shortest distance from node 0 to node n-1 after each query.
 */
class Solution {

    /**
     * Calculates shortest distances after adding roads based on queries
     *
     * @param n number of nodes in the graph
     * @param queries array of queries where each query adds a road between two
     * nodes
     * @return array of shortest distances from node 0 to n-1 after each query
     */
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Step 1: Initialize the distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0; // Distance to self is 0
        }
        for (int i = 0; i < n - 1; i++) {
            dist[i][i + 1] = 1; // Initial unidirectional roads
        }

        int[] answer = new int[queries.length];

        // Step 2: Process each query
        for (int q = 0; q < queries.length; q++) {
            int u = queries[q][0];
            int v = queries[q][1];

            // Add the new road
            dist[u][v] = 1;

            // Step 3: Update distances using Floyd-Warshall for the new road
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }

            // Record the shortest path from 0 to n-1
            answer[q] = dist[0][n - 1];
        }

        return answer;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int n1 = 4;
        int[][] queries1 = {{1, 3}, {0, 2}, {2, 3}};
        int[] result1 = solution.shortestDistanceAfterQueries(n1, queries1);
        System.out.println("Test Case 1: " + Arrays.toString(result1));
        // Expected: [4, 3, 2]

        // Test Case 2: Single node
        int n2 = 1;
        int[][] queries2 = {};
        int[] result2 = solution.shortestDistanceAfterQueries(n2, queries2);
        System.out.println("Test Case 2: " + Arrays.toString(result2));
        // Expected: []

        // Test Case 3: Two nodes
        int n3 = 2;
        int[][] queries3 = {{1, 0}};
        int[] result3 = solution.shortestDistanceAfterQueries(n3, queries3);
        System.out.println("Test Case 3: " + Arrays.toString(result3));
        // Expected: [1]
    }
}
