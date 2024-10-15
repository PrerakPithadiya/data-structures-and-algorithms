package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Solution class for finding the minimum cost to hire K workers.
 */
class Solution {

    /**
     * Calculates the minimum cost to hire K workers.
     *
     * @param quality An array of integers representing the quality of each
     * worker.
     * @param wage An array of integers representing the minimum wage
     * expectation of each worker.
     * @param k The number of workers to hire.
     * @return The minimum cost to hire K workers.
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // Create a list of workers as pairs of (ratio, quality)
        double[][] workers = new double[n][2];

        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i]; // ratio of wage to quality
            workers[i][1] = quality[i];
        }

        // Sort workers by the wage-to-quality ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        // Max-heap to store the qualities of the selected workers
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double totalQuality = 0; // To store the total quality of selected workers
        double minCost = Double.MAX_VALUE; // Initialize the minimum cost

        for (double[] worker : workers) {
            double ratio = worker[0];
            double currQuality = worker[1];

            // Add the current worker's quality to the total quality
            totalQuality += currQuality;
            maxHeap.offer(currQuality);

            // If we have more than k workers, remove the one with the highest quality
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll(); // Remove the largest quality
            }

            // If we have exactly k workers, calculate the cost
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * ratio); // Calculate total cost
            }
        }

        return minCost; // Return the minimum cost
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] quality1 = {10, 20, 5};
        int[] wage1 = {70, 50, 30};
        int k1 = 2;
        System.out.println("Test case 1 result: " + solution.mincostToHireWorkers(quality1, wage1, k1));
        // Expected output: 105.00000

        // Test case 2
        int[] quality2 = {3, 1, 10, 10, 1};
        int[] wage2 = {4, 8, 2, 2, 7};
        int k2 = 3;
        System.out.println("Test case 2 result: " + solution.mincostToHireWorkers(quality2, wage2, k2));
        // Expected output: 30.66667

        // Test case 3
        int[] quality3 = {5, 4, 3, 2, 1};
        int[] wage3 = {10, 8, 6, 4, 2};
        int k3 = 3;
        System.out.println("Test case 3 result: " + solution.mincostToHireWorkers(quality3, wage3, k3));
        // Expected output: 18.00000
    }
}
