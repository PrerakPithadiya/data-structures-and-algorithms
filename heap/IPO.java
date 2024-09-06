
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * This class provides a solution for the IPO (Initial Public Offering) problem.
 * It aims to maximize the final capital after selecting and completing a series
 * of projects.
 */
class Solution {

    /**
     * Finds the maximized capital after completing at most k projects.
     *
     * @param k The maximum number of projects that can be selected.
     * @param w The initial capital available.
     * @param profits An array of integers representing the profits of each
     * project.
     * @param capital An array of integers representing the capital required for
     * each project.
     * @return The maximized capital after completing the selected projects.
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Create an array of project indices sorted by their capital requirement
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Max heap for profit values
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;

        // Try selecting at most k projects
        while (k > 0) {
            // Push all projects that can be started with current capital into the max heap
            while (i < n && projects[i][0] <= w) {
                maxProfitHeap.offer(projects[i][1]);
                i++;
            }

            // If no projects can be started, break
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Pick the project with the maximum profit
            w += maxProfitHeap.poll();
            k--;
        }

        return w;
    }

    /**
     * Main method to run test cases for the IPO problem solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        int result1 = solution.findMaximizedCapital(k1, w1, profits1, capital1);
        System.out.println("Test case 1 result: " + result1);
        assert result1 == 4 : "Test case 1 failed";

        // Test case 2
        int k2 = 3;
        int w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        int result2 = solution.findMaximizedCapital(k2, w2, profits2, capital2);
        System.out.println("Test case 2 result: " + result2);
        assert result2 == 6 : "Test case 2 failed";

        // Test case 3
        int k3 = 1;
        int w3 = 2;
        int[] profits3 = {1, 2, 3};
        int[] capital3 = {1, 1, 2};
        int result3 = solution.findMaximizedCapital(k3, w3, profits3, capital3);
        System.out.println("Test case 3 result: " + result3);
        assert result3 == 5 : "Test case 3 failed";

        System.out.println("All test cases passed successfully.");
    }
}
