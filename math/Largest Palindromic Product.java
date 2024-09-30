
/**
 * Solution class for finding the largest palindrome that is a product of two n-digit numbers.
 * This class implements an algorithm to solve the problem efficiently.
 */
class Solution {

    /**
     * Finds the largest palindrome that is a product of two n-digit numbers.
     *
     * @param n The number of digits in the factors.
     * @return The largest palindrome product modulo 1337, or -1 if no
     * palindrome is found.
     */
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9; // Special case for 1-digit numbers
        }
        int upperLimit = (int) Math.pow(10, n) - 1;
        int lowerLimit = upperLimit / 10;

        // Iterate from largest possible palindrome downwards
        for (int left = upperLimit; left > lowerLimit; left--) {
            // Create a palindrome by reflecting the left part
            long palindrome = createPalindrome(left);

            // Check if this palindrome can be factored into two n-digit numbers
            for (long i = upperLimit; i * i >= palindrome; i--) {
                if (palindrome % i == 0) {
                    long quotient = palindrome / i;
                    // Check if the quotient is also an n-digit number
                    if (quotient >= lowerLimit && quotient <= upperLimit) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }
        return -1; // Just in case no palindrome was found (which shouldn't happen)
    }

    /**
     * Helper function to create a palindrome by reflecting the 'left' part.
     *
     * @param left The left part of the palindrome.
     * @return The created palindrome as a long value.
     */
    private long createPalindrome(int left) {
        String leftStr = Integer.toString(left);
        String rightStr = new StringBuilder(leftStr).reverse().toString();
        return Long.parseLong(leftStr + rightStr);
    }

    /**
     * Main method for testing the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: n = 1
        System.out.println("Test case 1: n = 1");
        System.out.println("Expected: 9");
        System.out.println("Actual: " + solution.largestPalindrome(1));
        System.out.println();

        // Test case 2: n = 2
        System.out.println("Test case 2: n = 2");
        System.out.println("Expected: 987");
        System.out.println("Actual: " + solution.largestPalindrome(2));
        System.out.println();

        // Test case 3: n = 3
        System.out.println("Test case 3: n = 3");
        System.out.println("Expected: 123");
        System.out.println("Actual: " + solution.largestPalindrome(3));
        System.out.println();

        // Test case 4: n = 4
        System.out.println("Test case 4: n = 4");
        System.out.println("Expected: 597");
        System.out.println("Actual: " + solution.largestPalindrome(4));
        System.out.println();
    }
}
