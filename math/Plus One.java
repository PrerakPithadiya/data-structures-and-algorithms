
/**
 * Solution class for the "Plus One" problem.
 * This class provides a method to increment a large integer represented as an array of digits.
 */
class Solution {

    /**
     * Increments the given number represented as an array of digits by one.
     *
     * @param digits An array of integers representing a non-negative number.
     * @return An array of integers representing the result of incrementing the
     * input by one.
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // If the current digit is less than 9, increment and return
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Set the current digit to 0 if it's 9
            digits[i] = 0;
        }

        // If we are here, it means all the digits were 9, so we need an extra digit
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    /**
     * Main method to run test cases for the plusOne method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case
        int[] test1 = {1, 2, 3};
        System.out.println("Test case 1:");
        System.out.println("Input: " + java.util.Arrays.toString(test1));
        System.out.println("Output: " + java.util.Arrays.toString(solution.plusOne(test1)));

        // Test case 2: Incrementing 9
        int[] test2 = {9};
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + java.util.Arrays.toString(test2));
        System.out.println("Output: " + java.util.Arrays.toString(solution.plusOne(test2)));

        // Test case 3: Incrementing 99
        int[] test3 = {9, 9};
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + java.util.Arrays.toString(test3));
        System.out.println("Output: " + java.util.Arrays.toString(solution.plusOne(test3)));

        // Test case 4: Large number
        int[] test4 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nTest case 4:");
        System.out.println("Input: " + java.util.Arrays.toString(test4));
        System.out.println("Output: " + java.util.Arrays.toString(solution.plusOne(test4)));
    }
}

/**
 * Project: Plus One
 *
 * Description: This project provides a solution to the "Plus One" problem,
 * where we need to increment a large integer represented as an array of digits.
 * The main class, Solution, contains a method plusOne that takes an array of
 * integers representing a non-negative number and returns a new array
 * representing the result of incrementing the input by one.
 *
 * Key Features: 1. Efficient in-place modification of the input array when
 * possible. 2. Handles edge cases, such as incrementing a number with all 9's.
 * 3. Includes comprehensive test cases to verify the correctness of the
 * implementation.
 *
 * Usage: To use this solution, create an instance of the Solution class and
 * call the plusOne method with an array of integers representing the number you
 * want to increment.
 *
 * Example: Solution solution = new Solution(); int[] number = {1, 2, 3}; int[]
 * result = solution.plusOne(number);
 *
 * Test Cases: The main method includes several test cases to demonstrate the
 * functionality of the plusOne method. These test cases cover various
 * scenarios, including: 1. Normal case: Incrementing a regular number. 2. Edge
 * case: Incrementing a single-digit 9. 3. Edge case: Incrementing a multi-digit
 * number with all 9's. 4. Large number: Incrementing a number with multiple
 * digits.
 *
 * Future Improvements: 1. Add more extensive error handling and input
 * validation. 2. Implement a version that works with negative numbers. 3.
 * Optimize for very large numbers by using a more memory-efficient
 * representation.
 */
