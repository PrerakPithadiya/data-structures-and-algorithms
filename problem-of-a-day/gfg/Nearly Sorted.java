package GFG;

import java.util.PriorityQueue;

/**
 * Solution class for sorting nearly sorted arrays A nearly sorted array is an
 * array where each element is at most k positions away from its position in the
 * sorted array
 */
class Solution {

    /**
     * Sorts a nearly sorted array where elements are at most k positions away
     * from their sorted position Time Complexity: O(n log k) Space Complexity:
     * O(k)
     *
     * @param arr The input array to be sorted
     * @param k The maximum distance an element can be from its final sorted
     * position
     */
    public void nearlySorted(int[] arr, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 1: Add the first k + 1 elements to the min-heap
        for (int i = 0; i <= Math.min(k, arr.length - 1); i++) {
            minHeap.add(arr[i]);
        }

        // Step 2: Process the rest of the elements
        int index = 0;
        for (int i = k + 1; i < arr.length; i++) {
            // Extract the minimum element from the heap and place it in the sorted position
            arr[index++] = minHeap.poll();
            // Add the next element from the array to the heap
            minHeap.add(arr[i]);
        }

        // Step 3: Extract remaining elements from the heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[] arr1 = {2, 6, 3, 12, 56, 8};
        int k1 = 3;
        solution.nearlySorted(arr1, k1);
        System.out.println("Test Case 1:");
        printArray(arr1); // Expected: [2, 3, 6, 8, 12, 56]

        // Test Case 2: Array already sorted
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        solution.nearlySorted(arr2, k2);
        System.out.println("Test Case 2:");
        printArray(arr2); // Expected: [1, 2, 3, 4, 5]

        // Test Case 3: k equals array length
        int[] arr3 = {5, 2, 7, 3, 1};
        int k3 = 5;
        solution.nearlySorted(arr3, k3);
        System.out.println("Test Case 3:");
        printArray(arr3); // Expected: [1, 2, 3, 5, 7]

        // Test Case 4: Single element
        int[] arr4 = {1};
        int k4 = 1;
        solution.nearlySorted(arr4, k4);
        System.out.println("Test Case 4:");
        printArray(arr4); // Expected: [1]
    }

    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
