
/**
 * This class provides a solution to find a single number in an array where every element appears twice except for one.
 */
class Solution {

    /**
     * Finds the single number in an array where every element appears twice
     * except for one.
     *
     * @param nums An array of integers where every element appears twice except
     * for one.
     * @return The single number that appears only once in the array.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // Apply XOR to each element
        }
        return result; // The result will be the single number
    }

    /**
     * Main method to demonstrate the functionality of the singleNumber method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Array with three elements, two of which are the same
        int[] nums1 = {2, 2, 1};
        System.out.println("Example 1 output: " + solution.singleNumber(nums1)); // Output: 1

        // Example 2: Array with five elements, four of which appear twice
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Example 2 output: " + solution.singleNumber(nums2)); // Output: 4

        // Example 3: Array with only one element
        int[] nums3 = {1};
        System.out.println("Example 3 output: " + solution.singleNumber(nums3)); // Output: 1
    }
}
