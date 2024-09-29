
/**
 * Solution class for converting Excel column titles to their corresponding column numbers.
 */
class Solution {

    /**
     * Converts an Excel column title to its corresponding column number.
     *
     * This method takes a string representation of an Excel column title (e.g.,
     * "A", "B", "Z", "AA", "AB", etc.) and returns the corresponding column
     * number as an integer.
     *
     * The conversion follows these rules: - A = 1 - B = 2 ... - Z = 26 - AA =
     * 27 - AB = 28 and so on.
     *
     * @param columnTitle The Excel column title as a string.
     * @return The corresponding column number as an integer.
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            // Convert character to corresponding number (A = 1, B = 2, ..., Z = 26)
            int value = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }

        return result;
    }

    /**
     * Main method to run test cases for the titleToNumber method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String[] testCases = {"A", "B", "Z", "AA", "AB", "ZY", "AAA"};
        int[] expectedResults = {1, 2, 26, 27, 28, 701, 703};

        for (int i = 0; i < testCases.length; i++) {
            int result = solution.titleToNumber(testCases[i]);
            System.out.printf("Input: %s, Expected: %d, Result: %d, Test %s%n",
                    testCases[i], expectedResults[i], result,
                    (result == expectedResults[i]) ? "PASSED" : "FAILED");
        }
    }
}
