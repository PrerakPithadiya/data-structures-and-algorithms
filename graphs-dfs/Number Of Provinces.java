
/**
 * This class provides a solution to the "Number of Provinces" problem.
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 */
class Solution {

    /**
     * Finds the number of provinces in the given connectivity matrix.
     *
     * @param isConnected An n x n matrix where isConnected[i][j] = 1 if the ith
     * city and the jth city are directly connected, and isConnected[i][j] = 0
     * otherwise.
     * @return The total number of provinces.
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinceCount++;
            }
        }

        return provinceCount;
    }

    /**
     * Performs a depth-first search (DFS) to mark all cities in a province as
     * visited.
     *
     * @param isConnected The connectivity matrix.
     * @param visited An array to keep track of visited cities.
     * @param city The current city being visited.
     */
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] isConnected1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Test case 1 result: " + solution.findCircleNum(isConnected1)); // Expected output: 2

        // Test case 2
        int[][] isConnected2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Test case 2 result: " + solution.findCircleNum(isConnected2)); // Expected output: 3
    }
}
