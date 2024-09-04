
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This class provides a solution to check if a string of parentheses, brackets,
 * and braces is valid. A string is considered valid if: 1. Open brackets must
 * be closed by the same type of brackets. 2. Open brackets must be closed in
 * the correct order. 3. Every close bracket has a corresponding open bracket of
 * the same type.
 */
class Solution {

    /**
     * Checks if the input string of parentheses, brackets, and braces is valid.
     *
     * @param s The input string to be validated.
     * @return true if the string is valid, false otherwise.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Map of matching pairs for quick lookup
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                // If current char is a closing bracket
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                // If current char is an opening bracket
                stack.push(c);
            }
        }

        // Return true if stack is empty, false otherwise
        return stack.isEmpty();
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testCases = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "",
            "((()))",
            "((())",
            ")(",
            "({[]})"
        };

        for (String testCase : testCases) {
            boolean result = solution.isValid(testCase);
            System.out.println("Input: \"" + testCase + "\" | Is Valid: " + result);
        }
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project provides a solution to the "Valid Parentheses"
 * problem, which is a common coding interview question. The main goal is to
 * determine if a given string of parentheses, brackets, and braces is valid.
 *
 * 2. Class Structure: - Solution: The main class containing the isValid method
 * and test cases.
 *
 * 3. Algorithm: The solution uses a stack-based approach to check the validity
 * of the input string: - It iterates through each character in the input
 * string. - Opening brackets are pushed onto the stack. - When a closing
 * bracket is encountered, it's matched against the top of the stack. - If the
 * match is correct, the top element is popped off the stack. - If the match is
 * incorrect or the stack is empty, the string is invalid. - After processing
 * all characters, the string is valid if the stack is empty.
 *
 * 4. Time and Space Complexity: - Time Complexity: O(n), where n is the length
 * of the input string. - Space Complexity: O(n) in the worst case, where all
 * characters are opening brackets.
 *
 * 5. Test Cases: The main method includes various test cases to verify the
 * correctness of the solution. These test cases cover different scenarios,
 * including valid and invalid inputs.
 *
 * 6. Future Improvements: - Add more comprehensive error handling and input
 * validation. - Extend the solution to handle more types of brackets or custom
 * bracket pairs. - Implement a command-line interface for user input.
 *
 * 7. Maintenance: - Regularly review and update the code to ensure it follows
 * the latest best practices. - Add new test cases as edge cases are discovered.
 * - Keep the documentation up-to-date with any changes to the code or
 * algorithm.
 */
