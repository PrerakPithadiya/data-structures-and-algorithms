
/**
 * Solution class for finding the single number in an array where every element appears three times except for one.
 */
class Solution {

    /**
     * Finds the single number in an array where every element appears three
     * times except for one.
     *
     * @param nums An array of integers where every element appears three times
     * except for one.
     * @return The single number that appears only once.
     */
    public int singleNumber(int[] nums) {
        int result = 0;

        // Iterate over all 32 bit positions
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            int bitMask = 1 << i;  // Mask to isolate the i-th bit

            // Count the number of 1s for the i-th bit in all numbers
            for (int num : nums) {
                if ((num & bitMask) != 0) {
                    sum++;
                }
            }

            // If sum is not a multiple of 3, it means the single number has a 1 in this bit
            if (sum % 3 != 0) {
                result |= bitMask;  // Set the i-th bit in the result
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the singleNumber method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums1));  // Output: 3

        // Example 2
        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(solution.singleNumber(nums2));  // Output: 99
    }
}

/**
 * Design and Implementation:
 *
 * This solution uses a bit manipulation approach to find the single number in
 * an array where every other number appears exactly three times. The algorithm
 * works as follows:
 *
 * 1. We iterate through each of the 32 bits of an integer (assuming 32-bit
 * integers). 2. For each bit position, we count the number of 1s in that
 * position across all numbers in the array. 3. If the count of 1s is not a
 * multiple of 3, it means the single number has a 1 in that bit position. 4. We
 * construct the result by setting the appropriate bits based on this count.
 *
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * Space Complexity: O(1), as we only use a constant amount of extra space.
 *
 * Usage Instructions:
 *
 * 1. Create an instance of the Solution class. 2. Call the singleNumber method
 * with an integer array as the argument. 3. The method will return the single
 * number that appears only once in the array.
 *
 * Example: Solution solution = new Solution(); int[] nums = {2, 2, 3, 2}; int
 * result = solution.singleNumber(nums); System.out.println(result); // Output:
 * 3
 */
