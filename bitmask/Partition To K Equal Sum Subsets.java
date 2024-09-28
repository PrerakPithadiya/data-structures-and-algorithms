package bitmask;

import java.util.Arrays;

/**
 * This class provides a solution to the problem of partitioning an array into k
 * subsets with equal sum.
 */
class Solution {
    /**
     * Determines if it's possible to partition the given array into k subsets with
     * equal sum.
     *
     * @param nums The input array of integers.
     * @param k    The number of subsets to partition into.
     * @return true if it's possible to partition the array, false otherwise.
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) {
            return false; // If total sum isn't divisible by k, it's impossible.
        }

        int target = totalSum / k; // Target sum for each subset
        Arrays.sort(nums); // Sort nums in descending order for optimization
        reverse(nums);

        int[] subsets = new int[k]; // Array to keep track of sum of each subset
        return backtrack(nums, subsets, 0, target);
    }

    /**
     * Backtracking helper function to find a valid partition.
     *
     * @param nums    The input array of integers.
     * @param subsets Array to keep track of sum of each subset.
     * @param index   Current index in nums being considered.
     * @param target  Target sum for each subset.
     * @return true if a valid partition is found, false otherwise.
     */
    private boolean backtrack(int[] nums, int[] subsets, int index, int target) {
        // If we've placed all elements, check if all subsets are valid
        if (index == nums.length) {
            for (int subsetSum : subsets) {
                if (subsetSum != target) {
                    return false;
                }
            }
            return true;
        }

        int currentNum = nums[index]; // Current number to place

        // Try to place the current number into each subset
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + currentNum <= target) {
                subsets[i] += currentNum;
                if (backtrack(nums, subsets, index + 1, target)) {
                    return true; // If placing the number leads to a solution, return true
                }
                subsets[i] -= currentNum; // Backtrack if it doesn't lead to a solution
            }

            // If the subset is empty and placing this number doesn't work, no point in
            // trying further subsets
            if (subsets[i] == 0) {
                break;
            }
        }

        return false; // No valid partition found for this configuration
    }

    /**
     * Helper function to reverse the sorted array.
     *
     * @param nums The array to be reversed.
     */
    private void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 4, 3, 2, 3, 5, 2, 1 };
        int k1 = 4;
        System.out.println("Test case 1: " + solution.canPartitionKSubsets(nums1, k1)); // Expected: true

        // Test case 2
        int[] nums2 = { 1, 2, 3, 4 };
        int k2 = 3;
        System.out.println("Test case 2: " + solution.canPartitionKSubsets(nums2, k2)); // Expected: false

        // Test case 3
        int[] nums3 = { 2, 2, 2, 2, 3, 4, 5 };
        int k3 = 4;
        System.out.println("Test case 3: " + solution.canPartitionKSubsets(nums3, k3)); // Expected: false

        // Test case 4
        int[] nums4 = { 1, 1, 1, 1, 2, 2, 2, 2 };
        int k4 = 4;
        System.out.println("Test case 4: " + solution.canPartitionKSubsets(nums4, k4)); // Expected: true
    }
}
