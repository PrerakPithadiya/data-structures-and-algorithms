
/**
 * This class provides a solution for finding the bitwise AND of all numbers in a given range.
 */
class Solution {

    /**
     * Calculates the bitwise AND of all numbers in the range [left, right].
     *
     * @param left The lower bound of the range (inclusive).
     * @param right The upper bound of the range (inclusive).
     * @return The bitwise AND of all numbers in the range.
     *
     * Algorithm: 1. Find the common prefix of the binary representations of
     * left and right. 2. Shift both numbers right until they are equal
     * (removing the differing bits). 3. Count the number of shifts performed.
     * 4. Shift the common prefix back to the left by the counted number of
     * shifts.
     *
     * Time Complexity: O(log(max(left, right))) Space Complexity: O(1)
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // Keep shifting left and right until they are the same
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Shift the common prefix back to the original position
        return left << shift;
    }

    /**
     * Main method to demonstrate the usage of the rangeBitwiseAnd method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Range [5, 7]
        System.out.println("Example 1: " + solution.rangeBitwiseAnd(5, 7));  // Output: 4

        // Example 2: Range [0, 0]
        System.out.println("Example 2: " + solution.rangeBitwiseAnd(0, 0));  // Output: 0

        // Example 3: Range [1, 2147483647]
        System.out.println("Example 3: " + solution.rangeBitwiseAnd(1, 2147483647));  // Output: 0
    }
}

/**
 * Usage Instructions: 1. Instantiate the Solution class. 2. Call the
 * rangeBitwiseAnd method with two integer parameters: the lower and upper
 * bounds of the range. 3. The method will return the bitwise AND of all numbers
 * in the given range.
 *
 * Example: Solution solution = new Solution(); int result =
 * solution.rangeBitwiseAnd(5, 7); System.out.println(result); // Output: 4
 */
