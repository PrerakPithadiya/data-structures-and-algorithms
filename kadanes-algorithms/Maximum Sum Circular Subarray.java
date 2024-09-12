
/**
 * Solution class for finding the maximum sum of a circular subarray.
 */
class Solution {

    /**
     * Finds the maximum sum of a circular subarray in the given array.
     *
     * This method uses Kadane's algorithm to find both the maximum subarray sum
     * and the minimum subarray sum. It then compares the maximum subarray sum
     * with the total sum minus the minimum subarray sum to handle the circular
     * case.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a circular subarray.
     */
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {
            totalSum += num;

            // Calculate max subarray sum using Kadane's algorithm
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Calculate min subarray sum (similar to Kadane's but for minimum)
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, return the maximum element
        if (maxSum < 0) {
            return maxSum;
        }

        // Otherwise, return the maximum of non-circular maxSum or circular maxSum
        return Math.max(maxSum, totalSum - minSum);
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Regular array
        int[] nums1 = {1, -2, 3, -2};
        System.out.println("Test case 1: " + solution.maxSubarraySumCircular(nums1)); // Expected output: 3

        // Test case 2: All positive numbers
        int[] nums2 = {5, 3, 2};
        System.out.println("Test case 2: " + solution.maxSubarraySumCircular(nums2)); // Expected output: 10

        // Test case 3: All negative numbers
        int[] nums3 = {-3, -2, -1};
        System.out.println("Test case 3: " + solution.maxSubarraySumCircular(nums3)); // Expected output: -1

        // Test case 4: Circular subarray sum is maximum
        int[] nums4 = {3, -1, 2, -1};
        System.out.println("Test case 4: " + solution.maxSubarraySumCircular(nums4)); // Expected output: 4

        // Test case 5: Empty array
        int[] nums5 = {};
        System.out.println("Test case 5: " + solution.maxSubarraySumCircular(nums5)); // Expected output: Integer.MIN_VALUE
    }
}
