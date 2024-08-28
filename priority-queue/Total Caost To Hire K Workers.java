
import java.util.PriorityQueue;

/**
 * This class provides a solution to calculate the total cost of hiring K
 * workers from a pool of candidates, considering the hiring cost for each
 * worker.
 */
class Solution {

    /**
     * Calculates the total cost of hiring K workers from a pool of candidates.
     *
     * @param costs An array of integers representing the cost of hiring each
     * worker.
     * @param k The number of workers to hire.
     * @param candidates The number of candidates to consider from each end of
     * the costs array.
     * @return The total cost of hiring K workers.
     */
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int left = 0, right = n - 1;
        long totalCost = 0;

        // Add the first `candidates` elements to the left heap and last `candidates` elements to the right heap
        while (left < candidates) {
            leftHeap.offer(costs[left++]);
        }

        while (right >= n - candidates && right >= left) {
            rightHeap.offer(costs[right--]);
        }

        // Process to hire `k` workers
        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                totalCost += rightHeap.poll();
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }

        return totalCost;
    }

    /**
     * Main method to demonstrate the usage of the totalCost method with various
     * test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] costs1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k1 = 3;
        int candidates1 = 4;
        System.out.println("Test case 1 result: " + solution.totalCost(costs1, k1, candidates1));

        // Test case 2
        int[] costs2 = {1, 2, 4, 1};
        int k2 = 3;
        int candidates2 = 3;
        System.out.println("Test case 2 result: " + solution.totalCost(costs2, k2, candidates2));

        // Test case 3
        int[] costs3 = {31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        int k3 = 11;
        int candidates3 = 2;
        System.out.println("Test case 3 result: " + solution.totalCost(costs3, k3, candidates3));
    }
}
