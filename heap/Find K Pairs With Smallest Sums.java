
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This class provides a solution to find k pairs with the smallest sums from
 * two sorted arrays.
 */
class Solution {

    /**
     * Finds k pairs with the smallest sums from two sorted arrays.
     *
     * @param nums1 The first sorted array
     * @param nums2 The second sorted array
     * @param k The number of pairs to return
     * @return A list of k pairs with the smallest sums
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Priority queue to store pairs based on their sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

        // Initialize the priority queue with pairs from nums1[0] and all elements of nums2
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0], j = pair[1];
            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(nums1[i]);
            currentPair.add(nums2[j]);
            result.add(currentPair);

            // Move to the next element in nums2 for the current nums1[i]
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println("Test case 1:");
        System.out.println("Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3");
        System.out.println("Output: " + solution.kSmallestPairs(nums1, nums2, k));

        // Test case 2
        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        k = 2;
        System.out.println("\nTest case 2:");
        System.out.println("Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2");
        System.out.println("Output: " + solution.kSmallestPairs(nums1, nums2, k));

        // Test case 3
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3};
        k = 3;
        System.out.println("\nTest case 3:");
        System.out.println("Input: nums1 = [1,2], nums2 = [3], k = 3");
        System.out.println("Output: " + solution.kSmallestPairs(nums1, nums2, k));
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project implements a solution to find k pairs with the
 * smallest sums from two sorted arrays. The solution uses a priority queue to
 * efficiently find the k smallest pairs.
 *
 * 2. Class Structure: - Solution: Contains the main logic for finding k
 * smallest pairs. - kSmallestPairs: Method to find k pairs with the smallest
 * sums. - main: Method to run test cases and demonstrate the solution.
 *
 * 3. Algorithm: - Use a priority queue to store pairs of indices based on their
 * sum. - Initialize the queue with pairs from the first array and the first
 * element of the second array. - Iteratively poll the smallest pair from the
 * queue and add it to the result. - For each polled pair, offer a new pair with
 * the next element from the second array.
 *
 * 4. Time Complexity: - O(k * log(min(k, m))) where m is the length of nums1.
 *
 * 5. Space Complexity: - O(min(k, m)) for the priority queue.
 *
 * 6. Test Cases: - Three test cases are provided to demonstrate the
 * functionality of the solution.
 *
 * 7. Future Improvements: - Add error handling for invalid inputs. - Optimize
 * for cases where k is very large compared to the input arrays. - Implement
 * unit tests for more comprehensive testing.
 */
