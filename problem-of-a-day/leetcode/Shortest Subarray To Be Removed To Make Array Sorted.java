package LeetCode;

/**
 * Solution for LeetCode problem: Shortest Subarray to be Removed to Make Array
 * Sorted
 *
 * Problem: Given an integer array arr, remove a subarray (can be empty) from
 * arr such that the remaining elements in arr are non-decreasing. Return the
 * length of the shortest subarray to remove.
 *
 * Time Complexity: O(n) where n is the length of the input array Space
 * Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the length of shortest subarray that needs to be removed to make
     * the array non-decreasing.
     *
     * @param arr input integer array
     * @return length of shortest subarray to be removed
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is non-decreasing
        if (left == n - 1) {
            return 0;
        }

        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Step 3: Minimum removal by keeping only prefix or suffix
        int minRemoval = Math.min(n - left - 1, right);

        // Step 4: Try to merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minRemoval = Math.min(minRemoval, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minRemoval;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array is already sorted
        int[] test1 = {1, 2, 3, 4, 5};
        assert solution.findLengthOfShortestSubarray(test1) == 0 : "Test case 1 failed";

        // Test Case 2: Need to remove middle elements
        int[] test2 = {1, 2, 3, 10, 4, 2, 3, 5};
        assert solution.findLengthOfShortestSubarray(test2) == 3 : "Test case 2 failed";

        // Test Case 3: Need to remove prefix
        int[] test3 = {5, 4, 3, 2, 1};
        assert solution.findLengthOfShortestSubarray(test3) == 4 : "Test case 3 failed";

        // Test Case 4: Single element array
        int[] test4 = {1};
        assert solution.findLengthOfShortestSubarray(test4) == 0 : "Test case 4 failed";

        // Test Case 5: Two element array
        int[] test5 = {2, 1};
        assert solution.findLengthOfShortestSubarray(test5) == 1 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
