
import java.util.HashMap;

/**
 * Solution class for checking if there exists a continuous subarray of size at
 * least two that sums up to a multiple of k.
 */
class Solution {

    /**
     * Checks if there exists a continuous subarray of size at least two that
     * sums up to a multiple of k.
     *
     * @param nums The input array of integers.
     * @param k The integer to check for multiples.
     * @return true if such a subarray exists, false otherwise.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map to store the remainder and the index at which it was first encountered
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // For cases where subarray from the start gives a multiple of k

        int cumulativeSum = 0;

        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            // If k is non-zero, take mod of cumulativeSum by k
            if (k != 0) {
                cumulativeSum = cumulativeSum % k;
            }

            // If the same remainder was seen before
            if (remainderMap.containsKey(cumulativeSum)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(cumulativeSum) > 1) {
                    return true;
                }
            } else {
                // Store the first occurrence of this remainder
                remainderMap.put(cumulativeSum, i);
            }
        }

        return false;
    }

    /**
     * Main method for testing the checkSubarraySum function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Should return true
        int[] nums1 = {23, 2, 4, 6, 7};
        int k1 = 6;
        System.out.println("Test case 1: " + solution.checkSubarraySum(nums1, k1));

        // Test case 2: Should return true
        int[] nums2 = {23, 2, 6, 4, 7};
        int k2 = 6;
        System.out.println("Test case 2: " + solution.checkSubarraySum(nums2, k2));

        // Test case 3: Should return false
        int[] nums3 = {23, 2, 6, 4, 7};
        int k3 = 13;
        System.out.println("Test case 3: " + solution.checkSubarraySum(nums3, k3));

        // Test case 4: Edge case with k = 0, should return false
        int[] nums4 = {0, 1, 0};
        int k4 = 0;
        System.out.println("Test case 4: " + solution.checkSubarraySum(nums4, k4));

        // Test case 5: Edge case with empty array, should return false
        int[] nums5 = {};
        int k5 = 1;
        System.out.println("Test case 5: " + solution.checkSubarraySum(nums5, k5));
    }
}
