
/**
 * Solution class for converting decimal numbers to base 7 representation.
 */
class Solution {

    /**
     * Converts a given decimal number to its base 7 representation.
     *
     * This method handles both positive and negative integers, including zero.
     * The conversion is done by repeatedly dividing the absolute value of the
     * number by 7 and collecting the remainders, which form the digits of the
     * base 7 number in reverse order.
     *
     * @param num The decimal number to be converted to base 7.
     * @return A string representing the base 7 equivalent of the input number.
     */
    public String convertToBase7(int num) {
        // Handle the case for zero
        if (num == 0) {
            return "0";
        }

        // Determine if the number is negative
        boolean isNegative = num < 0;
        num = Math.abs(num);

        // StringBuilder to store the base 7 digits
        StringBuilder base7 = new StringBuilder();

        // Convert to base 7 by repeatedly dividing by 7 and storing the remainders
        while (num > 0) {
            base7.append(num % 7);
            num /= 7;
        }

        // If the number was negative, append the minus sign
        if (isNegative) {
            base7.append("-");
        }

        // Reverse the string to get the correct order and return
        return base7.reverse().toString();
    }

    /**
     * Main method to run test cases for the convertToBase7 method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {0, 100, -7, 42, -42, 1000000, -1000000};

        for (int testCase : testCases) {
            String result = solution.convertToBase7(testCase);
            System.out.println("Decimal: " + testCase + " | Base 7: " + result);
        }
    }
}
