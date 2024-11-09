package LeetCode;

/**
 * Solution class for finding the minimum possible value of the last element in
 * an array given specific constraints on array construction.
 */
class Solution {

    /**
     * Finds the minimum possible value for the last element in an array of
     * length n, where the first element is x and the absolute difference
     * between adjacent elements is a power of 2.
     *
     * @param n The length of the array (n ≥ 1)
     * @param x The first element of the array (x ≥ 1)
     * @return The minimum possible value for the last element
     */
    public long minEnd(int n, int x) {
        // Base case optimization
        if (n == 1) {
            return x;
        }

        // Initialize variables with more descriptive names
        long lastElement = x;  // Will store our final answer
        long stepsNeeded = n - 1;  // Number of steps we need between first and last
        long bitMask = 1;  // Used to check and set bits

        // Process bits until we've handled all steps
        while (stepsNeeded > 0) {
            // Check if current bit position is available (0 in x)
            boolean isBitAvailable = (x & bitMask) == 0;

            if (isBitAvailable) {
                // If bit is available, use it if needed
                if ((stepsNeeded & 1) == 1) {
                    lastElement |= bitMask;
                }
                // Update remaining steps
                stepsNeeded >>>= 1;
            }

            // Move to next bit position
            bitMask <<= 1;
        }

        return lastElement;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Single element array
        assert solution.minEnd(1, 5) == 5 : "Test case 1 failed";

        // Test case 2: Two elements
        assert solution.minEnd(2, 3) == 4 : "Test case 2 failed";

        // Test case 3: Larger array
        assert solution.minEnd(3, 1) == 3 : "Test case 3 failed";

        // Test case 4: Maximum difference needed
        assert solution.minEnd(5, 1) == 7 : "Test case 4 failed";

        // Test case 5: Large input
        assert solution.minEnd(10, 15) == 31 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
