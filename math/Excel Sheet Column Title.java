
/**
 * Solution class for converting integer column numbers to Excel sheet column titles.
 */
class Solution {

    /**
     * Converts a given integer column number to its corresponding Excel sheet
     * column title.
     *
     * This method implements the following algorithm: 1. Initialize an empty
     * StringBuilder to store the result. 2. While the column number is greater
     * than 0: a. Decrement the column number to adjust for 1-based indexing. b.
     * Calculate the remainder when divided by 26 (number of letters in the
     * alphabet). c. Prepend the corresponding letter to the result. d. Divide
     * the column number by 26 to move to the next digit. 3. Return the final
     * string result.
     *
     * @param columnNumber The integer column number to convert (1-based index).
     * @return The Excel sheet column title as a string.
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based index
            int remainder = columnNumber % 26;
            result.insert(0, (char) ('A' + remainder)); // Prepend the corresponding character
            columnNumber /= 26;
        }

        return result.toString();
    }

    /**
     * Main method to run test cases for the convertToTitle method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Test Case 1:");
        System.out.println("Input: 1");
        System.out.println("Output: " + solution.convertToTitle(1));
        System.out.println("Expected: A");

        System.out.println("\nTest Case 2:");
        System.out.println("Input: 26");
        System.out.println("Output: " + solution.convertToTitle(26));
        System.out.println("Expected: Z");

        System.out.println("\nTest Case 3:");
        System.out.println("Input: 27");
        System.out.println("Output: " + solution.convertToTitle(27));
        System.out.println("Expected: AA");

        System.out.println("\nTest Case 4:");
        System.out.println("Input: 701");
        System.out.println("Output: " + solution.convertToTitle(701));
        System.out.println("Expected: ZY");

        System.out.println("\nTest Case 5:");
        System.out.println("Input: 2147483647");
        System.out.println("Output: " + solution.convertToTitle(2147483647));
        System.out.println("Expected: FXSHRXW");
    }
}
