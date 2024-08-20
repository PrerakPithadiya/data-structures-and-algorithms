/**
 * This class provides a solution for finding the maximum average of a subarray
 * of length k in an integer array.
 */
class Solution {
    /**
     * Finds the maximum average of a subarray of length k in the given integer
     * array.
     *
     * @param nums the input integer array
     * @param k    the length of the subarray
     * @return the maximum average of a subarray of length k
     */
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window of size k
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        // Initialize maxSum as the sum of the first window
        int maxSum = windowSum;

        // Slide the window across the array
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, windowSum);
        }

        // Return the maximum average
        return (double) maxSum / k;
    }

    /**
     * Main method to demonstrate the usage of the findMaxAverage method with
     * examples.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 1, 12, -5, -6, 50, 3 };
        int k1 = 4;
        System.out.println(solution.findMaxAverage(nums1, k1)); // Output: 12.75

        // Example 2
        int[] nums2 = { 5 };
        int k2 = 1;
        System.out.println(solution.findMaxAverage(nums2, k2)); // Output: 5.0
    }
}