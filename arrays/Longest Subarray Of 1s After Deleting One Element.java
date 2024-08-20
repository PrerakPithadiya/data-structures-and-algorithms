/**
 * This class provides a solution for finding the longest subarray containing
 * only 1's after one deletion.
 */
class Solution {
    /**
     * Finds the length of the longest subarray containing only 1's after one
     * deletion.
     *
     * @param nums an array of integers
     * @return the size of the longest subarray containing only 1's after one
     *         deletion
     */
    public int longestSubarray(int[] nums) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // Count the number of 0's in the current window
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If there are more than 1 zero, move the left pointer to the right
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the max length of the window with at most one 0
            maxLen = Math.max(maxLen, right - left);
        }

        // Return maxLen as the size of the longest subarray containing only 1's after
        // one deletion
        return maxLen;
    }

    /**
     * Main method to demonstrate the usage of the `longestSubarray` method with
     * example inputs.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 1, 1, 0, 1 };
        System.out.println(solution.longestSubarray(nums1)); // Output: 3

        // Example 2
        int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
        System.out.println(solution.longestSubarray(nums2)); // Output: 5

        // Example 3
        int[] nums3 = { 1, 1, 1 };
        System.out.println(solution.longestSubarray(nums3)); // Output: 2
    }
}