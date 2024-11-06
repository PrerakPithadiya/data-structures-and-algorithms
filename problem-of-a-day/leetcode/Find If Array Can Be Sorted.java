package LeetCode;

/**
 * Solution class for determining if an array can be sorted by swapping elements
 * with same bit count
 */
class Solution {

    /**
     * Determines if the input array can be sorted by swapping elements that
     * have the same number of set bits (1s) in their binary representation.
     *
     * @param nums The input array of integers to check
     * @return true if the array can be sorted, false otherwise
     */
    public boolean canSortArray(int[] nums) {
        short previousMax = 0, currentMin = 0, currentMax = 0;
        byte previousBitCount = 0;

        for (int value : nums) {
            byte currentBitCount = (byte) Integer.bitCount(value);

            if (previousBitCount == currentBitCount) {
                // Update the current min and max for the same bit count group
                currentMin = (short) Math.min(currentMin, value);
                currentMax = (short) Math.max(currentMax, value);
            } else {
                // Check if previous group's max exceeds current group's min
                if (currentMin < previousMax) {
                    return false;
                } else {
                    // Move to the next bit count group
                    previousMax = currentMax;
                    currentMin = currentMax = (short) value;
                    previousBitCount = currentBitCount;
                }
            }
        }

        // Final check to ensure last group's min is greater than or equal to previous group's max
        return currentMin >= previousMax;
    }

    /**
     * Test cases to verify the functionality of canSortArray method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array that can be sorted
        int[] test1 = {8, 4, 2, 30, 15};
        System.out.println("Test 1: " + solution.canSortArray(test1)); // Expected: true

        // Test Case 2: Array that cannot be sorted
        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + solution.canSortArray(test2)); // Expected: false

        // Test Case 3: Array with same bit count elements
        int[] test3 = {3, 5, 6, 12};
        System.out.println("Test 3: " + solution.canSortArray(test3)); // Expected: true

        // Test Case 4: Empty array
        int[] test4 = {};
        System.out.println("Test 4: " + solution.canSortArray(test4)); // Expected: true

        // Test Case 5: Single element array
        int[] test5 = {1};
        System.out.println("Test 5: " + solution.canSortArray(test5)); // Expected: true
    }
}
