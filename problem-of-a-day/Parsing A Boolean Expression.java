
import java.util.Stack;

/**
 * This class provides a solution for parsing and evaluating boolean
 * expressions. It supports the following operators: NOT (!), AND (&), and OR
 * (|).
 */
class Solution {

    /**
     * Parses and evaluates a boolean expression.
     *
     * @param expression The boolean expression to parse and evaluate.
     * @return The result of the boolean expression.
     */
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        // Traverse the expression character by character
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                // Process the subexpression inside the parentheses
                Stack<Character> temp = new Stack<>();

                // Pop until we reach '('
                while (stack.peek() != '(') {
                    temp.push(stack.pop());
                }
                // Pop the '('
                stack.pop();

                // Get the operator before '('
                char operator = stack.pop();

                // Evaluate the subexpression
                boolean result = evaluateSubexpression(temp, operator);

                // Push the result back to the stack as 't' or 'f'
                stack.push(result ? 't' : 'f');
            } else if (c != ',') {
                // Push all characters except commas
                stack.push(c);
            }
        }

        // Final result will be at the top of the stack
        return stack.pop() == 't';
    }

    /**
     * Helper function to evaluate a subexpression.
     *
     * @param temp The stack containing the operands of the subexpression.
     * @param operator The operator of the subexpression.
     * @return The result of evaluating the subexpression.
     */
    private boolean evaluateSubexpression(Stack<Character> temp, char operator) {
        switch (operator) {
            case '!' -> {
                // NOT operator, it only has one operand
                return temp.pop() == 'f';  // NOT 'f' is true, NOT 't' is false
            }
            case '&' -> {
                // AND operator, all operands must be true
                boolean result = true;
                while (!temp.isEmpty()) {
                    result &= (temp.pop() == 't');
                }
                return result;
            }
            case '|' -> {
                // OR operator, at least one operand must be true
                boolean result = false;
                while (!temp.isEmpty()) {
                    result |= (temp.pop() == 't');
                }
                return result;
            }
            default -> {
            }
        }
        return false;  // Shouldn't reach here
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple NOT
        String expr1 = "!(f)";
        System.out.println("Test case 1: " + expr1 + " = " + solution.parseBoolExpr(expr1));

        // Test case 2: Simple AND
        String expr2 = "&(t,f)";
        System.out.println("Test case 2: " + expr2 + " = " + solution.parseBoolExpr(expr2));

        // Test case 3: Simple OR
        String expr3 = "|(t,f)";
        System.out.println("Test case 3: " + expr3 + " = " + solution.parseBoolExpr(expr3));

        // Test case 4: Complex expression
        String expr4 = "&(|(f,t),!(t))";
        System.out.println("Test case 4: " + expr4 + " = " + solution.parseBoolExpr(expr4));

        // Test case 5: Nested expressions
        String expr5 = "|(&(t,f,t),!(|(f,f,f)))";
        System.out.println("Test case 5: " + expr5 + " = " + solution.parseBoolExpr(expr5));
    }
}
