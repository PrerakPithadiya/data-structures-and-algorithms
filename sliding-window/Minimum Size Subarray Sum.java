
/**
 * This class provides a solution to find the minimum size subarray sum.
 * It implements an efficient sliding window approach to solve the problem.
 */
class Solution {

    /**
     * Returns the minimal length of a contiguous subarray whose sum is greater
     * than or equal to the target.
     *
     * This method uses a sliding window technique to efficiently find the
     * minimum length subarray. It maintains a window with two pointers,
     * expanding and contracting as needed.
     *
     * Time Complexity: O(n), where n is the length of the input array. Space
     * Complexity: O(1), as it uses only a constant amount of extra space.
     *
     * @param target the target sum to be reached or exceeded
     * @param nums the array of positive integers to be processed
     * @return the minimal length of the subarray, or 0 if no such subarray
     * exists
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int currentSum = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // Shrink the window as small as possible while the sum is greater than or equal to target
            while (currentSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * Main method to demonstrate the functionality of the Solution class. It
     * includes several test cases to verify the correctness of the
     * minSubArrayLen method.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case with a valid subarray
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int result1 = solution.minSubArrayLen(target1, nums1);
        System.out.println("Test case 1 - Minimum size subarray sum: " + result1);

        // Test case 2: Case where the target is reached exactly
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        int result2 = solution.minSubArrayLen(target2, nums2);
        System.out.println("Test case 2 - Minimum size subarray sum: " + result2);

        // Test case 3: Case where no subarray sums to the target
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int result3 = solution.minSubArrayLen(target3, nums3);
        System.out.println("Test case 3 - Minimum size subarray sum: " + result3);

        // Test case 4: Case where the entire array sums to the target
        int target4 = 15;
        int[] nums4 = {1, 2, 3, 4, 5};
        int result4 = solution.minSubArrayLen(target4, nums4);
        System.out.println("Test case 4 - Minimum size subarray sum: " + result4);
    }
}
