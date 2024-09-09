
/**
 * Solution class for the Jump Game II problem.
 * This class provides a method to find the minimum number of jumps
 * required to reach the last index in an array.
 */
class Solution {

    /**
     * Calculates the minimum number of jumps required to reach the last index.
     *
     * @param nums An array of non-negative integers representing the maximum
     * jump length at each position.
     * @return The minimum number of jumps to reach the last index.
     */
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0; // No jumps needed if there's only one element
        }
        int jumps = 0;      // Count of jumps
        int farthest = 0;   // The farthest position we can reach
        int end = 0;        // The end of the current jump range

        // Iterate through the array, updating jump count and range
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest we can reach from index i
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == end) {
                jumps++;   // Increment the jump count
                end = farthest; // Set the new range to the farthest point

                // If the farthest point reaches or exceeds the last index, we can stop
                if (end >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    /**
     * Main method to demonstrate the usage of the jump method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Example 1 output: " + sol.jump(nums1));  // Output: 2

        // Example 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Example 2 output: " + sol.jump(nums2));  // Output: 2
    }
}
