package bitmask;

import java.util.Arrays;

/**
 * This class provides a solution to the problem of finding the minimum number
 * of work sessions
 * required to finish a given set of tasks, where each session has a time limit.
 */
class Solution {
    /**
     * Calculates the minimum number of work sessions required to complete all
     * tasks.
     *
     * @param tasks       An array of integers representing the time required for
     *                    each task.
     * @param sessionTime The maximum time allowed for each work session.
     * @return The minimum number of sessions required to complete all tasks.
     */
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[] dp = new int[1 << n]; // dp[mask] stores the minimum sessions required for task assignment "mask"
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // No tasks assigned, no sessions required

        // Precompute the session times for each subset of tasks
        int[] sessionCost = new int[1 << n];
        for (int mask = 0; mask < (1 << n); mask++) {
            int time = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    time += tasks[i];
                }
            }
            sessionCost[mask] = time;
        }

        // Iterate over all possible task assignments (bitmasks)
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE)
                continue; // Skip if unreachable state

            // Try to assign a new set of tasks to the current state
            for (int subMask = mask; subMask < (1 << n); subMask = (subMask + 1) | mask) {
                if (sessionCost[subMask - mask] <= sessionTime) {
                    dp[subMask] = Math.min(dp[subMask], dp[mask] + 1);
                }
            }
        }

        return dp[(1 << n) - 1]; // Minimum sessions to finish all tasks
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] tasks1 = { 1, 2, 3 };
        int sessionTime1 = 3;
        System.out.println("Test case 1: " + solution.minSessions(tasks1, sessionTime1)); // Expected output: 2

        // Test case 2
        int[] tasks2 = { 3, 1, 3, 1, 1 };
        int sessionTime2 = 8;
        System.out.println("Test case 2: " + solution.minSessions(tasks2, sessionTime2)); // Expected output: 2

        // Test case 3
        int[] tasks3 = { 1, 2, 3, 4, 5 };
        int sessionTime3 = 15;
        System.out.println("Test case 3: " + solution.minSessions(tasks3, sessionTime3)); // Expected output: 1

        // Test case 4
        int[] tasks4 = { 2, 3, 3, 4, 4, 4, 5, 6, 7, 10 };
        int sessionTime4 = 12;
        System.out.println("Test case 4: " + solution.minSessions(tasks4, sessionTime4)); // Expected output: 4
    }
}
