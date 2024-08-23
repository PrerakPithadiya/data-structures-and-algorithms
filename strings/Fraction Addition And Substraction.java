
/**
 * Solution class for adding and subtracting fractions represented as strings.
 */
class Solution {

    /**
     * Adds and subtracts fractions given in a string expression.
     *
     * @param expression A string containing fractions to be added or
     * subtracted. Format: "±a/b±c/d±..." where a, b, c, d are integers.
     * @return A string representing the result of the fraction operations in
     * the form "numerator/denominator".
     */
    public static String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;  // Start with a fraction 0/1

        int i = 0, n = expression.length();
        while (i < n) {
            // Read the sign
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            // Read the numerator
            int num = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Skip the '/'
            i++;

            // Read the denominator
            int denom = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                denom = denom * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Combine the current fraction with the total using the common denominator
            numerator = numerator * denom + sign * num * denominator;
            denominator = denominator * denom;

            // Reduce the fraction
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    /**
     * Calculates the Greatest Common Divisor (GCD) of two integers using the
     * Euclidean algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of a and b.
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * Main method to test the fractionAddition function with sample inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test cases
        System.out.println(fractionAddition("-1/2+1/2")); // Output: "0/1"
        System.out.println(fractionAddition("-1/2+1/2+1/3")); // Output: "1/3"
        System.out.println(fractionAddition("1/3-1/2")); // Output: "-1/6"
    }
}
