
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the Zigzag Conversion problem. It converts
 * a given string into a zigzag pattern and then reads it line by line.
 */
class ZigzagConversion {

    /**
     * Converts the input string into a zigzag pattern and returns the result.
     *
     * @param s The input string to be converted.
     * @param numRows The number of rows in the zigzag pattern.
     * @return The converted string read line by line from the zigzag pattern.
     */
    public String convert(String s, int numRows) {
        // Handle edge cases
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Initialize a list of strings for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // Add the character to the current row
            rows.get(currentRow).append(c);

            // Change direction if we are at the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move to the next row
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows to get the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    /**
     * Main method to demonstrate the usage of the ZigzagConversion class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();

        // Example 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", numRows = " + numRows1);
        System.out.println("Output: \"" + zc.convert(s1, numRows1) + "\"");
        System.out.println();

        // Example 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Example 2:");
        System.out.println("Input: s = \"" + s2 + "\", numRows = " + numRows2);
        System.out.println("Output: \"" + zc.convert(s2, numRows2) + "\"");
        System.out.println();

        // Example 3
        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Example 3:");
        System.out.println("Input: s = \"" + s3 + "\", numRows = " + numRows3);
        System.out.println("Output: \"" + zc.convert(s3, numRows3) + "\"");
    }
}
