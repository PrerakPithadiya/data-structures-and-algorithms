
import java.util.Arrays;

/**
 * This class provides a solution for rotating an array to the right by k steps.
 */
class Solution {

    /**
     * Rotates the given array to the right by k steps.
     *
     * @param nums The array to be rotated.
     * @param k The number of steps to rotate the array.
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Ensure k is within bounds of the array's length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper function to reverse a portion of the array.
     *
     * @param nums The array containing the portion to be reversed.
     * @param start The starting index of the portion to be reversed.
     * @param end The ending index of the portion to be reversed.
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Main method to demonstrate the usage of the rotate function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1:
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        sol.rotate(nums1, k1);
        // Output: [5, 6, 7, 1, 2, 3, 4]
        System.out.println("Rotated Array: " + Arrays.toString(nums1));

        // Example 2:
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        sol.rotate(nums2, k2);
        // Output: [3, 99, -1, -100]
        System.out.println("Rotated Array: " + Arrays.toString(nums2));
    }
}
