/**
 * This class provides a solution for finding the greatest common divisor (GCD)
 * of two strings.
 */
class Solution {
    /**
     * Finds the greatest common divisor of two strings.
     *
     * @param str1 The first input string
     * @param str2 The second input string
     * @return The greatest common divisor string, or an empty string if no GCD
     *         exists
     */
    public String gcdOfStrings(String str1, String str2) {
        // Step 1: Check if str1 + str2 equals str2 + str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Step 2: Find the GCD of the lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());

        // Step 3: Return the substring of length gcdLength from str1
        return str1.substring(0, gcdLength);
    }

    /**
     * Helper method to calculate the greatest common divisor of two integers using
     * Euclidean algorithm.
     *
     * @param a The first integer
     * @param b The second integer
     * @return The greatest common divisor of a and b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Main method to demonstrate the usage of the gcdOfStrings method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(solution.gcdOfStrings(str1, str2)); // Output: "ABC"

        // Example 2
        str1 = "ABABAB";
        str2 = "ABAB";
        System.out.println(solution.gcdOfStrings(str1, str2)); // Output: "AB"

        // Example 3
        str1 = "LEET";
        str2 = "CODE";
        System.out.println(solution.gcdOfStrings(str1, str2)); // Output: ""
    }
}
