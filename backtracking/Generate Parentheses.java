
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for generating all valid combinations of
 * parentheses.
 */
class Solution {

    /**
     * Generates all valid combinations of parentheses.
     *
     * @param n The number of pairs of parentheses to generate.
     * @return A list of strings containing all valid combinations of
     * parentheses.
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * Recursive backtracking method to generate valid parentheses combinations.
     *
     * @param result The list to store all valid combinations.
     * @param current The current string being built.
     * @param open The count of open parentheses in the current string.
     * @param close The count of close parentheses in the current string.
     * @param max The maximum number of pairs of parentheses to generate.
     */
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // If the current string reaches the maximum length (2 * n), it's valid
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // If the number of open parentheses is less than max, we can add an open parenthesis
        if (open < max) {
            current.append('(');            // Add '('
            backtrack(result, current, open + 1, close, max);  // Recur for the next position
            current.deleteCharAt(current.length() - 1);        // Backtrack, remove '('
        }

        // If the number of close parentheses is less than the open ones, we can add a close parenthesis
        if (close < open) {
            current.append(')');            // Add ')'
            backtrack(result, current, open, close + 1, max);  // Recur for the next position
            current.deleteCharAt(current.length() - 1);        // Backtrack, remove ')'
        }
    }

    /**
     * Main method to demonstrate the usage of the generateParenthesis method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example 1
        System.out.println(solution.generateParenthesis(3));  // Output: ["((()))","(()())","(())()","()(())","()()()"]
        // Example 2
        System.out.println(solution.generateParenthesis(1));  // Output: ["()"]
    }
}
