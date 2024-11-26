package LeetCode;

/**
 * Solution for Find Champion II problem
 *
 * In a tournament with n teams (numbered from 0 to n-1), teams compete against
 * each other. You are given a 2D array edges where edges[i] = [ai, bi]
 * indicates that team ai is stronger than team bi. A team x is considered the
 * champion if there is no team y that is stronger than team x.
 *
 * Time Complexity: O(n + e) where n is number of teams and e is number of edges
 * Space Complexity: O(n) for the inDegree array
 */
class Solution {

    /**
     * Finds the champion team in the tournament
     *
     * @param n number of teams in the tournament
     * @param edges array where edges[i] = [ai, bi] indicates team ai is
     * stronger than team bi
     * @return the champion team number, or -1 if there is no unique champion
     */
    public int findChampion(int n, int[][] edges) {
        // Step 1: Create an array to store the in-degree of each node
        int[] inDegree = new int[n];

        // Step 2: Populate the in-degree array based on the edges
        for (int[] edge : edges) {
            int v = edge[1]; // weaker team
            inDegree[v]++;   // increase the in-degree of the weaker team
        }

        // Step 3: Find the team(s) with in-degree of 0
        int champion = -1; // Initialize champion to -1 (no champion found)
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) { // Found a team with no stronger team
                if (champion != -1) { // If we already found a champion, return -1
                    return -1;
                }
                champion = i; // Set the current team as the champion
            }
        }

        // Step 4: Return the champion or -1 if there isn't a unique champion
        return champion;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Single champion
        int[][] edges1 = {{0, 1}, {1, 2}};
        assert solution.findChampion(3, edges1) == 0 : "Test case 1 failed";

        // Test case 2: No unique champion
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 0}};
        assert solution.findChampion(3, edges2) == -1 : "Test case 2 failed";

        // Test case 3: Empty edges
        int[][] edges3 = {};
        assert solution.findChampion(1, edges3) == 0 : "Test case 3 failed";

        System.out.println("All test cases passed!");
    }
}
