/**
 * Solution class for finding the longest contiguous subarray with at most k
 * zeros.
 */
class Solution {
    /**
     * Finds the length of the longest contiguous subarray with at most k zeros.
     *
     * @param nums The input array of 0s and 1s.
     * @param k    The maximum number of zeros allowed to be flipped.
     * @return The length of the longest contiguous subarray with at most k zeros.
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, increase the zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If the number of zeros exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length of the window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    /**
     * Main method to test the longestOnes function with example inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k1 = 2;
        System.out.println(solution.longestOnes(nums1, k1)); // Output: 6

        // Example 2
        int[] nums2 = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k2 = 3;
        System.out.println(solution.longestOnes(nums2, k2)); // Output: 10
    }
}
