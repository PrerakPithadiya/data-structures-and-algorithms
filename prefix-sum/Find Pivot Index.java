
/**
 * This class provides a solution to find the pivot index in an array.
 * The pivot index is the index where the sum of all numbers to the left
 * of the index is equal to the sum of all numbers to the right of the index.
 */
class Solution {

    /**
     * Finds the pivot index in the given array.
     *
     * @param nums The input array of integers.
     * @return The pivot index if it exists, otherwise -1.
     */
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }

    /**
     * Main method to run test cases for the pivotIndex method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Array with a pivot index
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Test case 1: " + solution.pivotIndex(nums1)); // Expected output: 3

        // Test case 2: Array without a pivot index
        int[] nums2 = {1, 2, 3};
        System.out.println("Test case 2: " + solution.pivotIndex(nums2)); // Expected output: -1

        // Test case 3: Array with pivot index at the beginning
        int[] nums3 = {2, 1, -1};
        System.out.println("Test case 3: " + solution.pivotIndex(nums3)); // Expected output: 0

        // Test case 4: Array with negative numbers and pivot index at the beginning
        int[] nums4 = {-1, -1, -1, 0, 1, 1};
        System.out.println("Test case 4: " + solution.pivotIndex(nums4)); // Expected output: 0
    }
}
