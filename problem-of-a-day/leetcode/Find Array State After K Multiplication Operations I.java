
import java.util.Arrays;

/**
 * Solution class for finding array state after k multiplication operations.
 * This class provides functionality to modify an array by repeatedly
 * multiplying its minimum element by a given multiplier for a specified number
 * of iterations.
 */
class Solution {

    /**
     * Modifies an array by performing k multiplication operations on its
     * minimum elements. In each operation, it finds the first occurrence of the
     * minimum element and multiplies it by the given multiplier.
     *
     * @param nums The input array of integers to be modified
     * @param k The number of multiplication operations to perform
     * @param multiplier The value to multiply the minimum element by in each
     * operation
     * @return The modified array after performing all operations
     *
     * @throws IllegalArgumentException if nums is null or empty, k is negative,
     * or multiplier is zero
     *
     * Example 1: Input: nums = [1,2,3], k = 2, multiplier = 2 Output: [2,2,3]
     * Explanation: Operation 1: Minimum element is 1, after multiplication:
     * [2,2,3] Operation 2: Minimum element is 2, after multiplication: [2,4,3]
     *
     * Example 2: Input: nums = [0,-1,2], k = 1, multiplier = -2 Output: [0,2,2]
     * Explanation: Operation 1: Minimum element is -1, after multiplication:
     * [0,2,2]
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Input validation
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        if (k < 0) {
            throw new IllegalArgumentException("Number of operations cannot be negative");
        }
        if (multiplier == 0) {
            throw new IllegalArgumentException("Multiplier cannot be zero");
        }

        for (int i = 0; i < k; i++) {
            int minIndex = 0;

            // Find the index of the first minimum element
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Multiply the found minimum value by the multiplier
            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    /**
     * Test cases to verify the functionality of getFinalState method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Test case 1: Basic test
        assert Arrays.equals(solution.getFinalState(new int[]{1, 2, 3}, 2, 2), new int[]{2, 4, 3});

        // Test case 2: Negative numbers
        assert Arrays.equals(solution.getFinalState(new int[]{0, -1, 2}, 1, -2), new int[]{0, 2, 2});

        // Test case 3: Single element
        assert Arrays.equals(solution.getFinalState(new int[]{5}, 3, 2), new int[]{40});

        // Test case 4: No operations (k=0)
        assert Arrays.equals(solution.getFinalState(new int[]{1, 2, 3}, 0, 2), new int[]{1, 2, 3});

        // Test case 5: Multiple minimum elements
        assert Arrays.equals(solution.getFinalState(new int[]{1, 1, 2}, 1, 3), new int[]{3, 1, 2});
    }
}
