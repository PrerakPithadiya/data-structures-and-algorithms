
import java.util.TreeMap;

/**
 * Solution for LeetCode problem: Count Continuous Subarrays
 *
 * Problem Description: You are given a 0-indexed integer array nums. A subarray
 * of nums is called continuous if: - For any two adjacent elements in the
 * subarray, the difference between them is at most 2.
 *
 * The task is to return the total number of continuous subarrays.
 *
 * Approach: 1. Use a sliding window technique with TreeMap to maintain the
 * window elements 2. For each position, expand window to right and check if
 * max-min difference <= 2 3. If condition violated, shrink window from left
 * until valid 4. Count valid subarrays for each window position
 *
 * Time Complexity: O(n log n) where n is length of input array Space
 * Complexity: O(n) for the TreeMap
 */
class Solution {

    /**
     * Counts the number of continuous subarrays where difference between any
     * two adjacent elements is at most 2.
     *
     * @param nums Input array of integers
     * @return Total number of continuous subarrays
     */
    public long continuousSubarrays(int[] nums) {
        // TreeMap to maintain the frequency of elements in the current window
        TreeMap<Integer, Integer> window = new TreeMap<>();
        long count = 0;
        int left = 0;

        // Iterate through the array
        for (int right = 0; right < nums.length; right++) {
            // Add the current element to the window
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            // Shrink the window if the condition is violated
            while (window.lastKey() - window.firstKey() > 2) {
                int leftValue = nums[left];
                // Decrement the frequency of the left element
                window.put(leftValue, window.get(leftValue) - 1);
                // Remove it from the map if its frequency becomes 0
                if (window.get(leftValue) == 0) {
                    window.remove(leftValue);
                }
                // Shrink the window by moving the left pointer
                left++;
            }

            // Add the number of valid subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with small array
        int[] test1 = {5, 4, 2, 4};
        assert solution.continuousSubarrays(test1) == 8 : "Test case 1 failed";

        // Test Case 2: Array with all same elements
        int[] test2 = {1, 1, 1, 1};
        assert solution.continuousSubarrays(test2) == 10 : "Test case 2 failed";

        // Test Case 3: Array with strictly increasing elements
        int[] test3 = {1, 2, 3, 4, 5};
        assert solution.continuousSubarrays(test3) == 9 : "Test case 3 failed";

        // Test Case 4: Single element array
        int[] test4 = {1};
        assert solution.continuousSubarrays(test4) == 1 : "Test case 4 failed";

        // Test Case 5: Array with elements having difference > 2
        int[] test5 = {1, 4, 1, 2};
        assert solution.continuousSubarrays(test5) == 7 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
