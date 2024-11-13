package LeetCode;

import java.util.Arrays;

/**
 * Solution for counting fair pairs in an array A pair (i, j) is called fair if
 * i < j and lower <= nums[i] + nums[j] <= upper
 */
class Solution {

    /**
     * Counts the number of fair pairs in the given array
     *
     * @param nums Input array of integers
     * @param lower Lower bound for the sum of pairs
     * @param upper Upper bound for the sum of pairs
     * @return Number of fair pairs that satisfy the condition
     */
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        // Step 2: Use two pointers to find valid pairs
        for (int i = 0; i < n; i++) {
            // Find the first index j1 where nums[i] + nums[j1] >= lower
            int j1 = findLowerBound(nums, lower - nums[i], i + 1, n);
            // Find the last index j2 where nums[i] + nums[j2] <= upper
            int j2 = findUpperBound(nums, upper - nums[i], i + 1, n);

            // Count valid pairs
            if (j1 < j2) {
                count += (j2 - j1);
            }
        }

        return count;
    }

    /**
     * Binary search to find the lower bound index
     *
     * @param nums Input array
     * @param target Target value to search for
     * @param start Start index
     * @param end End index
     * @return Index of the lower bound
     */
    private int findLowerBound(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    /**
     * Binary search to find the upper bound index
     *
     * @param nums Input array
     * @param target Target value to search for
     * @param start Start index
     * @param end End index
     * @return Index of the upper bound
     */
    private int findUpperBound(int[] nums, int target, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    /**
     * Test cases for the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case
        int[] nums1 = {0, 1, 7, 4, 4, 5};
        assert solution.countFairPairs(nums1, 3, 6) == 6 : "Test case 1 failed";

        // Test case 2: Array with negative numbers
        int[] nums2 = {-1, -2, -3, -4};
        assert solution.countFairPairs(nums2, -7, -2) == 3 : "Test case 2 failed";

        // Test case 3: Empty array
        int[] nums3 = {};
        assert solution.countFairPairs(nums3, 0, 0) == 0 : "Test case 3 failed";

        // Test case 4: Single element array
        int[] nums4 = {1};
        assert solution.countFairPairs(nums4, 1, 2) == 0 : "Test case 4 failed";

        // Test case 5: Array with all same elements
        int[] nums5 = {2, 2, 2, 2};
        assert solution.countFairPairs(nums5, 4, 4) == 6 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
