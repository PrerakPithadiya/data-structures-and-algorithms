
/**
 * Solution class for determining if a number can be expressed as the sum of two square numbers.
 */
class Solution {

    /**
     * Determines if the given number can be expressed as the sum of two square
     * numbers.
     *
     * @param c The target number to be checked.
     * @return true if c can be expressed as the sum of two square numbers,
     * false otherwise.
     */
    public boolean judgeSquareSum(int c) {
        // Two pointers: a starts from 0, b starts from sqrt(c)
        long a = 0;
        long b = (long) Math.sqrt(c);

        while (a <= b) {
            long sumOfSquares = a * a + b * b;

            if (sumOfSquares == c) {
                return true;
            } else if (sumOfSquares < c) {
                a++;  // Increase a to increase the sum
            } else {
                b--;  // Decrease b to decrease the sum
            }
        }

        return false;  // No valid pair (a, b) found
    }

    /**
     * Main method to run test cases for the judgeSquareSum method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {5, 3, 4, 2, 1, 0, 100000000};

        for (int testCase : testCases) {
            boolean result = solution.judgeSquareSum(testCase);
            System.out.println("Is " + testCase + " a sum of square numbers? " + result);
        }
    }
}

/*
 *
 * The program will execute the test cases defined in the main method and print the results.
 * To test additional numbers, you can modify the testCases array in the main method.
 *
 * Design and Implementation Notes:
 * - The solution uses a two-pointer approach to efficiently check if a number can be expressed as the sum of two squares.
 * - It initializes two pointers: 'a' starting from 0 and 'b' starting from the square root of the input number.
 * - The algorithm iterates while 'a' is less than or equal to 'b', calculating the sum of their squares in each iteration.
 * - If the sum equals the target number, it returns true.
 * - If the sum is less than the target, it increments 'a' to increase the sum.
 * - If the sum is greater than the target, it decrements 'b' to decrease the sum.
 * - If no valid pair is found after the loop, it returns false.
 * - The use of long data type for calculations prevents integer overflow for large input values.
 *
 * Time Complexity: O(sqrt(c)), where c is the input number.
 * Space Complexity: O(1), as it uses only a constant amount of extra space.
 */
