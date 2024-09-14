
/**
 * Solution class for finding the longest subarray with maximum bitwise AND.
 */
class Solution {

    /**
     * Finds the length of the longest subarray with maximum bitwise AND.
     *
     * @param nums The input array of integers.
     * @return The length of the longest subarray with maximum bitwise AND.
     */
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest subarray where all elements are equal to maxVal
        int maxLength = 0;
        int currentLength = 0;

        for (int num : nums) {
            if (num == maxVal) {
                // If the current element is equal to the max value, extend the subarray
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Reset the current length if the element is not equal to max value
                currentLength = 0;
            }
        }

        return maxLength;
    }

    /**
     * Main method for testing the longestSubarray function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case
        int[] nums1 = {1, 2, 3, 3, 2, 2};
        System.out.println("Test case 1: " + solution.longestSubarray(nums1)); // Expected output: 2

        // Test case 2: All elements are the same
        int[] nums2 = {5, 5, 5, 5};
        System.out.println("Test case 2: " + solution.longestSubarray(nums2)); // Expected output: 4

        // Test case 3: Single element array
        int[] nums3 = {7};
        System.out.println("Test case 3: " + solution.longestSubarray(nums3)); // Expected output: 1

        // Test case 4: Empty array
        int[] nums4 = {};
        System.out.println("Test case 4: " + solution.longestSubarray(nums4)); // Expected output: 0

        // Test case 5: Array with negative numbers
        int[] nums5 = {-1, -1, -2, -1, -1, -1};
        System.out.println("Test case 5: " + solution.longestSubarray(nums5)); // Expected output: 3
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * longestSubarray method with an integer array as the argument. 3. The method
 * will return the length of the longest subarray with maximum bitwise AND.
 *
 * Example: Solution solution = new Solution(); int[] nums = {1, 2, 3, 3, 2, 2};
 * int result = solution.longestSubarray(nums); System.out.println(result); //
 * Output: 2
 *
 * Design and Implementation: - The algorithm works in two steps: 1. Find the
 * maximum value in the input array. 2. Find the longest consecutive sequence of
 * the maximum value. - Time Complexity: O(n), where n is the length of the
 * input array. - Space Complexity: O(1), as it uses only a constant amount of
 * extra space.
 */
