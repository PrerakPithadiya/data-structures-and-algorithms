
/**
 * Solution class for the "2 Key Keyboard" problem.
 * This class provides a method to calculate the minimum number of operations
 * required to display a given number of 'A' characters on the screen.
 */
class Solution {

    /**
     * Calculates the minimum number of operations required to display 'n' 'A'
     * characters.
     *
     * The problem can be reduced to finding the sum of prime factors of 'n'.
     * This is because each prime factor represents a cycle of copy-all and
     * paste operations.
     *
     * @param n The number of 'A' characters to be displayed
     * @return The minimum number of operations required
     */
    public int minSteps(int n) {
        int result = 0;

        // We try to find the smallest factor of n and reduce n accordingly
        for (int i = 2; i <= n; i++) {
            // While we can divide n by i, we factorize n by i
            while (n % i == 0) {
                result += i;
                n /= i;
            }
        }

        return result;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + solution.minSteps(n1));
        System.out.println("Expected: 3");
        System.out.println();

        // Test case 2
        int n2 = 1;
        System.out.println("Test case 2:");
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + solution.minSteps(n2));
        System.out.println("Expected: 0");
        System.out.println();

        // Test case 3
        int n3 = 12;
        System.out.println("Test case 3:");
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + solution.minSteps(n3));
        System.out.println("Expected: 7");
        System.out.println();
    }
}
