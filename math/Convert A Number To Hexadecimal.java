
/**
 * Solution class for converting an integer to its hexadecimal representation.
 */
class Solution {

    /**
     * Converts an integer to its hexadecimal representation.
     *
     * This method handles both positive and negative integers using two's
     * complement representation for negative numbers. It builds the hexadecimal
     * string from right to left and then reverses it to get the correct order.
     *
     * @param num The integer to be converted to hexadecimal.
     * @return A string representing the hexadecimal value of the input integer.
     */
    public String toHex(int num) {
        // Handle the case for zero
        if (num == 0) {
            return "0";
        }

        // Use two's complement for negative numbers
        StringBuilder hex = new StringBuilder();
        char[] hexChars = "0123456789abcdef".toCharArray();

        for (int i = 0; i < 8; i++) {  // 32 bits / 4 bits per hex digit = 8 hex digits
            // Get the last 4 bits
            int lastFourBits = num & 0xF; // Extract last 4 bits
            hex.append(hexChars[lastFourBits]); // Append corresponding hex character
            num >>= 4; // Right shift by 4 to process next 4 bits
        }

        // Remove leading zeros and reverse the string
        while (hex.length() > 0 && hex.charAt(hex.length() - 1) == '0') {
            hex.deleteCharAt(hex.length() - 1);
        }

        return hex.reverse().toString(); // Return reversed string
    }

    /**
     * Main method to run test cases for the toHex method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Test Case 1: " + solution.toHex(26) + " (Expected: 1a)");
        System.out.println("Test Case 2: " + solution.toHex(-1) + " (Expected: ffffffff)");
        System.out.println("Test Case 3: " + solution.toHex(0) + " (Expected: 0)");
        System.out.println("Test Case 4: " + solution.toHex(16) + " (Expected: 10)");
        System.out.println("Test Case 5: " + solution.toHex(-2147483648) + " (Expected: 80000000)");
    }
}
