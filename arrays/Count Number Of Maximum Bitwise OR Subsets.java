
/**
 * Solution class to count the number of maximum bitwise-OR subsets in an array.
 */
class Solution {

    /**
     * Counts the number of subsets in the given array that have the maximum
     * bitwise OR value.
     *
     * @param nums The input array of integers.
     * @return The count of subsets with maximum bitwise OR value.
     */
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int maxOr = 0;  // to store the maximum OR value
        int count = 0;  // to count subsets with the maximum OR value

        // Step 1: Find the maximum OR for the entire array
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Generate all non-empty subsets
        int totalSubsets = (1 << n);  // Total subsets (2^n)

        for (int subset = 1; subset < totalSubsets; subset++) {
            int currentOr = 0;
            // Iterate over each bit to check which elements are included in this subset
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {  // If the i-th bit is set, include nums[i]
                    currentOr |= nums[i];
                }
            }
            // Step 3: Check if this subset's OR is equal to the maximum OR
            if (currentOr == maxOr) {
                count++;
            }
        }

        return count;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {3, 1};
        System.out.println("Test case 1: " + solution.countMaxOrSubsets(nums1)); // Expected output: 2

        // Test case 2
        int[] nums2 = {2, 2, 2};
        System.out.println("Test case 2: " + solution.countMaxOrSubsets(nums2)); // Expected output: 7

        // Test case 3
        int[] nums3 = {3, 2, 1, 5};
        System.out.println("Test case 3: " + solution.countMaxOrSubsets(nums3)); // Expected output: 6

        // Test case 4
        int[] nums4 = {1, 2, 3, 4};
        System.out.println("Test case 4: " + solution.countMaxOrSubsets(nums4)); // Expected output: 1
    }
}
