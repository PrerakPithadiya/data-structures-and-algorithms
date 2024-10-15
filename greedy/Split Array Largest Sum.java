package greedy;

/**
 * Solution for the "Split Array Largest Sum" problem. This class implements an
 * algorithm to split an array into k non-empty continuous subarrays such that
 * the largest sum among these subarrays is minimized.
 */
class Solution {

    /**
     * Splits the given array into k subarrays and returns the minimized largest
     * sum.
     *
     * @param nums The input array of integers.
     * @param k The number of subarrays to split the array into.
     * @return The minimized largest sum among the k subarrays.
     */
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        // Calculate the bounds for binary search
        for (int num : nums) {
            low = Math.max(low, num); // largest single element
            high += num; // sum of all elements
        }

        // Binary search for the minimal largest sum
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid; // try to minimize the largest sum
            } else {
                low = mid + 1; // increase the allowed sum
            }
        }

        return low;
    }

    /**
     * Checks if it's possible to split the array into k or fewer subarrays with
     * a maximum sum of maxSum.
     *
     * @param nums The input array of integers.
     * @param k The maximum number of subarrays allowed.
     * @param maxSum The maximum sum allowed for each subarray.
     * @return true if the split is possible, false otherwise.
     */
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int currentSum = 0;
        int subarrays = 1; // start with one subarray

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                subarrays++; // start a new subarray
                currentSum = num; // reset the sum for the new subarray
                if (subarrays > k) {
                    return false; // too many subarrays
                }
            } else {
                currentSum += num; // add the current number to the current subarray
            }
        }

        return true; // we can split the array into at most k subarrays
    }

    /**
     * Test cases for the splitArray method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("Test case 1: " + solution.splitArray(nums1, k1)); // Expected output: 18

        // Test case 2
        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Test case 2: " + solution.splitArray(nums2, k2)); // Expected output: 9

        // Test case 3
        int[] nums3 = {1, 4, 4};
        int k3 = 3;
        System.out.println("Test case 3: " + solution.splitArray(nums3, k3)); // Expected output: 4
    }
}
