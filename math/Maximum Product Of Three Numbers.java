
import java.util.Arrays;

/**
 * This class provides a solution for finding the maximum product of three
 * numbers in an array.
 */
class Solution {

    /**
     * Calculates the maximum product of three numbers in the given array.
     *
     * @param nums The input array of integers.
     * @return The maximum product of three numbers from the array.
     */
    public int maximumProduct(int[] nums) {
        // Sort the array in ascending order
        Arrays.sort(nums);

        int n = nums.length;

        // Option 1: The product of the three largest numbers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Option 2: The product of the two smallest numbers and the largest number
        int option2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two options
        return Math.max(option1, option2);
    }

    /**
     * Main method to run test cases for the maximumProduct method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Array with all positive numbers
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Test case 1: " + solution.maximumProduct(nums1)); // Expected output: 60

        // Test case 2: Array with all negative numbers
        int[] nums2 = {-5, -4, -3, -2, -1};
        System.out.println("Test case 2: " + solution.maximumProduct(nums2)); // Expected output: -6

        // Test case 3: Array with mixed positive and negative numbers
        int[] nums3 = {-10, -9, 1, 2, 3, 4};
        System.out.println("Test case 3: " + solution.maximumProduct(nums3)); // Expected output: 360

        // Test case 4: Array with zeros
        int[] nums4 = {-1, 0, 1, 2, 3};
        System.out.println("Test case 4: " + solution.maximumProduct(nums4)); // Expected output: 6

        // Test case 5: Array with minimum length (3 elements)
        int[] nums5 = {1, 2, 3};
        System.out.println("Test case 5: " + solution.maximumProduct(nums5)); // Expected output: 6
    }
}
