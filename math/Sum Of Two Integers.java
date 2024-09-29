
/**
 * Solution class for summing two integers without using the + or - operators.
 */
class Solution {

    /**
     * Calculates the sum of two integers without using the + or - operators.
     *
     * This method uses bitwise operations to perform addition. It simulates the
     * process of adding numbers by handling carry and sum separately.
     *
     * @param a The first integer to be added.
     * @param b The second integer to be added.
     * @return The sum of a and b.
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // calculate carry
            a = a ^ b;                 // sum without carry
            b = carry;                 // update b to carry
        }
        return a;
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Positive numbers
        System.out.println("Test case 1: 1 + 2 = " + solution.getSum(1, 2));

        // Test case 2: Negative and positive numbers
        System.out.println("Test case 2: -1 + 2 = " + solution.getSum(-1, 2));

        // Test case 3: Both negative numbers
        System.out.println("Test case 3: -2 + (-3) = " + solution.getSum(-2, -3));

        // Test case 4: Zero and non-zero number
        System.out.println("Test case 4: 0 + 5 = " + solution.getSum(0, 5));

        // Test case 5: Large numbers
        System.out.println("Test case 5: 1000000 + 2000000 = " + solution.getSum(1000000, 2000000));
    }
}
