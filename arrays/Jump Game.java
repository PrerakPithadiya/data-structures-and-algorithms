
/**
 * Solution class for the Jump Game problem.
 * This class provides a method to determine if it's possible to reach the last index
 * in an array of non-negative integers, where each element represents the maximum
 * jump length at that position.
 */
class Solution {

    /**
     * Determines if it's possible to reach the last index of the given array.
     *
     * @param nums An array of non-negative integers where nums[i] represents
     * the maximum jump length from index i.
     * @return true if it's possible to reach the last index, false otherwise.
     */
    public boolean canJump(int[] nums) {
        int farthest = 0; // Initialize the farthest position we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                // If current index is greater than the farthest reachable point, return false
                return false;
            }
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If farthest point is greater than or equal to the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        // If we finish the loop, return false (in case we never reach the last index)
        return false;
    }

    /**
     * Main method to demonstrate the usage of the canJump method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: A case where it's possible to reach the last index
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Example 1: " + sol.canJump(nums1)); // Output: true

        // Example 2: A case where it's not possible to reach the last index
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Example 2: " + sol.canJump(nums2)); // Output: false
    }
}
