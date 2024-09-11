
/**
 * This class provides a solution for adding two binary strings.
 */
class Solution {

    /**
     * Adds two binary strings and returns the result as a binary string.
     *
     * @param a The first binary string
     * @param b The second binary string
     * @return The sum of the two binary strings as a binary string
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Iterate through both strings from right to left
        while (i >= 0 || j >= 0) {
            int sum = carry;

            // Add the bit from 'a' if there are still bits left
            if (i >= 0) {
                sum += a.charAt(i) - '0';  // Convert character to integer
                i--;
            }

            // Add the bit from 'b' if there are still bits left
            if (j >= 0) {
                sum += b.charAt(j) - '0';  // Convert character to integer
                j--;
            }

            // Append the current bit (sum % 2) to the result
            result.append(sum % 2);

            // Compute the new carry
            carry = sum / 2;
        }

        // If there's still a carry left, append it
        if (carry != 0) {
            result.append(carry);
        }

        // Reverse the result since we've added bits from right to left
        return result.reverse().toString();
    }

    /**
     * Main method to demonstrate the usage of the addBinary method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String a1 = "11";
        String b1 = "1";
        System.out.println("Example 1:");
        System.out.println("Input: a = \"" + a1 + "\", b = \"" + b1 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a1, b1) + "\"");  // Expected output: "100"

        // Example 2
        String a2 = "1010";
        String b2 = "1011";
        System.out.println("\nExample 2:");
        System.out.println("Input: a = \"" + a2 + "\", b = \"" + b2 + "\"");
        System.out.println("Output: \"" + solution.addBinary(a2, b2) + "\"");  // Expected output: "10101"
    }
}
