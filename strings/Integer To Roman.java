
/**
 * This class provides functionality to convert integer numbers to Roman numerals.
 */
class IntegerToRoman {

    /**
     * Converts an integer to its Roman numeral representation.
     *
     * @param num The integer to be converted (should be positive and less than
     * 4000)
     * @return The Roman numeral representation of the input integer
     */
    public String intToRoman(int num) {
        // Define the Roman numeral mappings
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Iterate through the values and symbols arrays
        for (int i = 0; i < values.length; i++) {
            // While the current value can be subtracted from num
            while (num >= values[i]) {
                // Append the corresponding symbol to the result
                roman.append(symbols[i]);
                // Subtract the value from num
                num -= values[i];
            }
        }

        return roman.toString();
    }

    /**
     * Main method to demonstrate the usage of the IntegerToRoman converter.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();

        // Example 1
        int num1 = 3749;
        System.out.println("Input: " + num1);
        System.out.println("Output: " + converter.intToRoman(num1)); // Output: "MMMDCCXLIX"

        // Example 2
        int num2 = 58;
        System.out.println("Input: " + num2);
        System.out.println("Output: " + converter.intToRoman(num2)); // Output: "LVIII"

        // Example 3
        int num3 = 1994;
        System.out.println("Input: " + num3);
        System.out.println("Output: " + converter.intToRoman(num3)); // Output: "MCMXCIV"
    }
}

/*
 * Usage Instructions:
 * 1. Create an instance of the IntegerToRoman class.
 * 2. Call the intToRoman method with an integer argument.
 * 3. The method will return the Roman numeral representation as a String.
 *
 * Example:
 *     IntegerToRoman converter = new IntegerToRoman();
 *     String result = converter.intToRoman(3749);
 *     System.out.println(result); // Outputs: MMMDCCXLIX
 *
 * Note: This implementation works for positive integers up to 3999.
 * For numbers outside this range, the method may produce incorrect results.
 */
