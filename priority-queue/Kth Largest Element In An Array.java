
import java.util.PriorityQueue;

/**
 * This class provides a solution for finding the kth largest element in an
 * array.
 */
class Solution {

    /**
     * Finds the kth largest element in the given array.
     *
     * @param nums The input array of integers.
     * @param k The position of the largest element to find (1-indexed).
     * @return The kth largest element in the array.
     */
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the largest k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            minHeap.add(num);
            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }

    /**
     * Main method to demonstrate the usage of the findKthLargest method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println("Example 1 - Kth Largest: " + solution.findKthLargest(nums1, k1)); // Output: 5

        // Example 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println("Example 2 - Kth Largest: " + solution.findKthLargest(nums2, k2)); // Output: 4
    }
}
