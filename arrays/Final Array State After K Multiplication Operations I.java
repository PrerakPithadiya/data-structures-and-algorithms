
import java.util.Arrays;

/**
 * This class provides a solution for performing multiplication operations on an
 * array.
 */
class Solution {

    /**
     * Performs a series of multiplication operations on the given array.
     *
     * @param nums The input array of integers.
     * @param k The number of operations to perform.
     * @param multiplier The value to multiply with.
     * @return The modified array after performing the operations.
     */
    public int[] performOperations(int[] nums, int k, int multiplier) {
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
     * The main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 1, 3, 5, 6};
        int k1 = 5;
        int multiplier1 = 2;
        System.out.println(Arrays.toString(solution.performOperations(nums1, k1, multiplier1))); // Output: [8, 4, 6, 5, 6]

        // Example 2
        int[] nums2 = {1, 2};
        int k2 = 3;
        int multiplier2 = 4;
        System.out.println(Arrays.toString(solution.performOperations(nums2, k2, multiplier2))); // Output: [16, 8]
    }
}
