
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * This class provides a solution to the Maximum Subsequence Score problem. The
 * problem involves finding the maximum score of a subsequence of length k from
 * two given arrays nums1 and nums2.
 */
class Solution {

    /**
     * Calculates the maximum score of a subsequence of length k.
     *
     * @param nums1 The first array of integers.
     * @param nums2 The second array of integers.
     * @param k The length of the subsequence to consider.
     * @return The maximum score achievable.
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Step 1: Pairing nums1 and nums2 elements
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        // Step 2: Sort the pairs based on nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        // Step 3: Use a min-heap to maintain the k largest nums1 values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, maxScore = 0;

        // Step 4: Iterate through the sorted pairs
        for (int i = 0; i < n; i++) {
            int currentNum2 = pairs[i][0];
            int currentNum1 = pairs[i][1];

            // Add the current nums1 value to the heap
            sum += currentNum1;
            minHeap.add(currentNum1);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            // If we have exactly k elements in the heap, calculate the score
            if (minHeap.size() == k) {
                long score = sum * currentNum2;
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }

    /**
     * Main method to demonstrate the usage of the maxScore function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1_1 = {1, 3, 3, 2};
        int[] nums2_1 = {2, 1, 3, 4};
        int k1 = 3;
        System.out.println("Test case 1 result: " + solution.maxScore(nums1_1, nums2_1, k1));

        // Test case 2
        int[] nums1_2 = {4, 2, 3, 1, 1};
        int[] nums2_2 = {7, 5, 10, 9, 6};
        int k2 = 1;
        System.out.println("Test case 2 result: " + solution.maxScore(nums1_2, nums2_2, k2));

        // Test case 3
        int[] nums1_3 = {2, 1, 14, 12};
        int[] nums2_3 = {11, 7, 13, 6};
        int k3 = 2;
        System.out.println("Test case 3 result: " + solution.maxScore(nums1_3, nums2_3, k3));
    }
}
