
/**
 * Solution class for calculating the power of a number.
 * This class implements an efficient algorithm to calculate x^n.
 */
class Solution {

    /**
     * Calculates x raised to the power of n.
     *
     * @param x The base number.
     * @param n The exponent.
     * @return The result of x^n.
     */
    public double myPow(double x, int n) {
        // Handle the case where n is negative
        long N = n;  // Convert to long to handle edge case when n = Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    /**
     * Helper method that implements the fast power algorithm.
     *
     * @param x The base number.
     * @param n The exponent (as a long to handle large values).
     * @return The result of x^n.
     */
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Positive exponent
        System.out.println("2^10 = " + solution.myPow(2.0, 10));  // Expected: 1024.0

        // Test case 2: Negative exponent
        System.out.println("2^-2 = " + solution.myPow(2.0, -2));  // Expected: 0.25

        // Test case 3: Zero exponent
        System.out.println("5^0 = " + solution.myPow(5.0, 0));  // Expected: 1.0

        // Test case 4: Fractional base
        System.out.println("0.5^3 = " + solution.myPow(0.5, 3));  // Expected: 0.125

        // Test case 5: Large exponent
        System.out.println("1.0001^10000 = " + solution.myPow(1.0001, 10000));  // Expected: ~2.7182 (e)

        // Test case 6: Negative base, odd exponent
        System.out.println("(-2)^3 = " + solution.myPow(-2.0, 3));  // Expected: -8.0

        // Test case 7: Negative base, even exponent
        System.out.println("(-2)^4 = " + solution.myPow(-2.0, 4));  // Expected: 16.0

        // Test case 8: Edge case - minimum integer value
        System.out.println("2^-2147483648 = " + solution.myPow(2.0, Integer.MIN_VALUE));  // Expected: 0.0
    }
}
