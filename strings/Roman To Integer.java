
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution for converting Roman numerals to integers. It
 * implements a method that takes a Roman numeral string as input and returns
 * the corresponding integer value.
 */
class RomanToInteger {

    /**
     * Converts a Roman numeral string to its integer equivalent.
     *
     * @param s The Roman numeral string to be converted.
     * @return The integer value of the Roman numeral.
     */
    public int romanToInt(String s) {
        // Create a map for Roman numerals and their values
        Map<Character, Integer> romanMap = createRomanNumeralMap();

        int result = 0;
        int n = s.length();

        // Traverse the string from left to right
        for (int i = 0; i < n; i++) {
            // Get the value of the current Roman numeral
            int currentVal = romanMap.get(s.charAt(i));

            // Check if the current numeral is smaller than the next one (for subtraction cases)
            if (i < n - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                // Subtract current value if the next numeral is larger
                result -= currentVal;
            } else {
                // Otherwise, add the current value
                result += currentVal;
            }
        }

        return result;
    }

    /**
     * Creates and returns a map of Roman numeral characters to their
     * corresponding integer values.
     *
     * @return A Map containing Roman numeral characters as keys and their
     * integer values as values.
     */
    private Map<Character, Integer> createRomanNumeralMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }

    /**
     * Main method to demonstrate the usage of the RomanToInteger class. It
     * creates an instance of the class and tests it with various Roman numeral
     * inputs.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();

        // Test cases
        System.out.println("Test case 1 result: " + solution.romanToInt("III"));      // Output: 3
        System.out.println("Test case 2 result: " + solution.romanToInt("LVIII"));    // Output: 58
        System.out.println("Test case 3 result: " + solution.romanToInt("MCMXCIV"));  // Output: 1994
    }
}
