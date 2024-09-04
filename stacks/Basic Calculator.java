
import java.util.Stack;

/**
 * This class provides a solution for evaluating basic mathematical expressions.
 * It supports addition, subtraction, and parentheses.
 */
class Solution {

    /**
     * Calculates the result of a given mathematical expression.
     *
     * @param s The input string containing the mathematical expression.
     * @return The result of the evaluated expression.
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 represents '+' and -1 represents '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the result and the sign onto the stack
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                // Pop the sign and the previous result
                result *= stack.pop(); // pop sign
                result += stack.pop(); // pop previous result
            }
        }
        // Add the last number to the result
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    /**
     * Main method to run test cases for the calculate method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple addition
        String expression1 = "1 + 1";
        int result1 = solution.calculate(expression1);
        System.out.println("Test case 1: " + expression1 + " = " + result1);

        // Test case 2: Addition and subtraction
        String expression2 = " 2-1 + 2 ";
        int result2 = solution.calculate(expression2);
        System.out.println("Test case 2: " + expression2 + " = " + result2);

        // Test case 3: Expression with parentheses
        String expression3 = "(1+(4+5+2)-3)+(6+8)";
        int result3 = solution.calculate(expression3);
        System.out.println("Test case 3: " + expression3 + " = " + result3);

        // Test case 4: Negative numbers
        String expression4 = "1 + (-2) + 3";
        int result4 = solution.calculate(expression4);
        System.out.println("Test case 4: " + expression4 + " = " + result4);

        // Test case 5: Complex expression with nested parentheses
        String expression5 = "((2 + 3) * (4 - 1)) - (6 / 2)";
        int result5 = solution.calculate(expression5);
        System.out.println("Test case 5: " + expression5 + " = " + result5);
    }
}
