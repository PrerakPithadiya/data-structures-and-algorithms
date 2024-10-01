
/**
 * Solution class for finding the largest number with monotone increasing digits.
 */
class Solution {

    /**
     * Finds the largest number less than or equal to n with monotone increasing
     * digits.
     *
     * This method takes an integer n and returns the largest number not greater
     * than n whose digits are in monotone increasing order.
     *
     * Algorithm: 1. Convert the input number to a character array. 2. Traverse
     * the array from right to left. 3. If a digit is smaller than the previous
     * digit, decrement the previous digit and mark the current position. 4. Set
     * all digits after the marked position to '9'. 5. Convert the resulting
     * array back to an integer and return.
     *
     * Time Complexity: O(d), where d is the number of digits in n. Space
     * Complexity: O(d) to store the digit array.
     *
     * @param n The input number.
     * @return The largest number less than or equal to n with monotone
     * increasing digits.
     */
    public int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int mark = digits.length;  // Mark position to change to 9

        // Traverse from right to left
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] < digits[i - 1]) {
                // If monotonicity is violated, decrease the previous digit and mark
                digits[i - 1]--;
                mark = i;
            }
        }

        // Change all digits after the marked position to '9'
        for (int i = mark; i < digits.length; i++) {
            digits[i] = '9';
        }

        // Return the final result as an integer
        return Integer.parseInt(new String(digits));
    }

    /**
     * Main method for testing the monotoneIncreasingDigits function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {10, 1234, 332, 100, 1000, 9};

        for (int testCase : testCases) {
            int result = solution.monotoneIncreasingDigits(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
    }
}
