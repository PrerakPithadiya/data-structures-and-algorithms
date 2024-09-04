
import java.util.Stack;

/**
 * This class provides a solution for evaluating Reverse Polish Notation (RPN)
 * expressions. RPN is a mathematical notation in which operators follow their
 * operands.
 */
class Solution {

    /**
     * Evaluates the given RPN expression.
     *
     * @param tokens An array of strings representing the RPN expression.
     * @return The result of evaluating the RPN expression.
     * @throws IllegalArgumentException if the input is invalid.
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+" ->
                    stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" ->
                    stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    if (b == 0) {
                        throw new IllegalArgumentException("Division by zero");
                    }
                    stack.push(a / b);
                }
                default -> {
                    try {
                        stack.push(Integer.valueOf(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid token: " + token);
                    }
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }

        return stack.pop();
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic arithmetic
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Test case 1: " + solution.evalRPN(tokens1)); // Expected output: 9

        // Test case 2: More complex expression
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Test case 2: " + solution.evalRPN(tokens2)); // Expected output: 6

        // Test case 3: Expression with negative numbers
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Test case 3: " + solution.evalRPN(tokens3)); // Expected output: 22

        // Test case 4: Division by zero (should throw an exception)
        String[] tokens4 = {"1", "0", "/"};
        try {
            solution.evalRPN(tokens4);
        } catch (IllegalArgumentException e) {
            System.out.println("Test case 4: " + e.getMessage());
        }

        // Test case 5: Invalid token (should throw an exception)
        String[] tokens5 = {"1", "a", "+"};
        try {
            solution.evalRPN(tokens5);
        } catch (IllegalArgumentException e) {
            System.out.println("Test case 5: " + e.getMessage());
        }

        // Test case 6: Invalid RPN expression (should throw an exception)
        String[] tokens6 = {"1", "2", "3", "+"};
        try {
            solution.evalRPN(tokens6);
        } catch (IllegalArgumentException e) {
            System.out.println("Test case 6: " + e.getMessage());
        }
    }
}
