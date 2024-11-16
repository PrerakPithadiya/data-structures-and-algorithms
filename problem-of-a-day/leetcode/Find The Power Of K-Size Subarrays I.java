package LeetCode;

/**
 * Solution class for finding power of k-size subarrays Time Complexity: O(n*k)
 * where n is length of input array Space Complexity: O(n-k+1) for result array
 */
class Solution {

    /**
     * Checks consecutive k elements in array for consecutive sequence and
     * returns max value
     *
     * @param nums Input array of integers
     * @param k Size of subarray to check
     * @return Array containing max value for valid subarrays, -1 for invalid
     * ones
     */
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isValid = true;
            int max = nums[i];

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    isValid = false;
                    break;
                }
                max = Math.max(max, nums[j + 1]);
            }

            result[i] = isValid ? max : -1;
        }
        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic consecutive sequence
        int[] test1 = {1, 2, 3, 4, 5};
        int k1 = 3;
        int[] result1 = solution.resultsArray(test1, k1);
        System.out.println("Test 1: " + java.util.Arrays.toString(result1));  // Expected: [3, 4, 5]

        // Test case 2: Non-consecutive sequence
        int[] test2 = {1, 3, 4, 2, 5};
        int k2 = 3;
        int[] result2 = solution.resultsArray(test2, k2);
        System.out.println("Test 2: " + java.util.Arrays.toString(result2));  // Expected: [-1, -1, -1]

        // Test case 3: Single element subarrays
        int[] test3 = {1, 2, 3};
        int k3 = 1;
        int[] result3 = solution.resultsArray(test3, k3);
        System.out.println("Test 3: " + java.util.Arrays.toString(result3));  // Expected: [1, 2, 3]
    }
}
