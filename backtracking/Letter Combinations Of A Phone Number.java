
/**
 * This class provides a solution for generating letter combinations of a phone number.
 * It uses a backtracking algorithm to generate all possible combinations.
 */
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Mapping of digits to their corresponding letters on a phone keypad. Index
     * corresponds to the digit, and the string contains the possible letters.
     */
    private static final String[] KEYPAD = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };

    /**
     * Generates all possible letter combinations that the input digits could
     * represent.
     *
     * @param digits A string containing digits from 2-9 inclusive.
     * @return A list of all possible letter combinations.
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    /**
     * Recursive helper method that uses backtracking to generate all
     * combinations.
     *
     * @param result The list to store all generated combinations.
     * @param combination The current combination being built.
     * @param digits The input string of digits.
     * @param index The current index in the digits string being processed.
     */
    private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }

        // Get the corresponding letters for the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            combination.append(letter);
            backtrack(result, combination, digits, index + 1);
            combination.deleteCharAt(combination.length() - 1); // backtrack
        }
    }

    /**
     * Main method to run test cases and demonstrate the functionality of the
     * solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty input
        System.out.println("Test case 1:");
        System.out.println(solution.letterCombinations(""));

        // Test case 2: Single digit
        System.out.println("Test case 2:");
        System.out.println(solution.letterCombinations("2"));

        // Test case 3: Two digits
        System.out.println("Test case 3:");
        System.out.println(solution.letterCombinations("23"));

        // Test case 4: Three digits
        System.out.println("Test case 4:");
        System.out.println(solution.letterCombinations("234"));

        // Test case 5: Four digits
        System.out.println("Test case 5:");
        System.out.println(solution.letterCombinations("7890"));
    }
}
