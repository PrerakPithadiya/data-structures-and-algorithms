package greedy;

/**
 * Solution for the Patching Array problem.
 *
 * This class provides a method to find the minimum number of patches required
 * to make all numbers from 1 to n representable as a sum of a subset of the
 * given array.
 */
class Solution {

    /**
     * Calculates the minimum number of patches required.
     *
     * @param nums An array of positive integers sorted in ascending order.
     * @param n The upper limit of the range we want to cover.
     * @return The minimum number of patches required.
     */
    public int minPatches(int[] nums, int n) {
        long x = 1; // smallest number that we cannot form
        int patches = 0; // number of patches we need
        int i = 0; // index for nums array

        while (x <= n) {
            if (i < nums.length && nums[i] <= x) {
                // If nums[i] is less than or equal to x, we can use nums[i]
                x += nums[i];
                i++;
            } else {
                // We need to patch with x (the smallest number we can't form)
                x += x;
                patches++;
            }
        }

        return patches;
    }

    /**
     * Main method for testing the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3};
        int n1 = 6;
        System.out.println("Test case 1: " + solution.minPatches(nums1, n1)); // Expected output: 1

        // Test case 2
        int[] nums2 = {1, 5, 10};
        int n2 = 20;
        System.out.println("Test case 2: " + solution.minPatches(nums2, n2)); // Expected output: 2

        // Test case 3
        int[] nums3 = {1, 2, 2};
        int n3 = 5;
        System.out.println("Test case 3: " + solution.minPatches(nums3, n3)); // Expected output: 0

        // Test case 4
        int[] nums4 = {};
        int n4 = 7;
        System.out.println("Test case 4: " + solution.minPatches(nums4, n4)); // Expected output: 3
    }
}
