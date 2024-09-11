
/**
 * This class provides a solution to calculate the number of trailing zeroes in the factorial of a given number.
 */
class Solution {

    /**
     * Calculates the number of trailing zeroes in the factorial of a given
     * number.
     *
     * @param n The input number for which to calculate the factorial's trailing
     * zeroes.
     * @return The number of trailing zeroes in n!.
     */
    public int trailingZeroes(int n) {
        int count = 0;
        // Iterate through powers of 5
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    /**
     * Main method to demonstrate the usage of the trailingZeroes method.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Calculate trailing zeroes for 3!
        System.out.println("Trailing zeroes in 3!: " + solution.trailingZeroes(3));  // Output: 0

        // Example 2: Calculate trailing zeroes for 5!
        System.out.println("Trailing zeroes in 5!: " + solution.trailingZeroes(5));  // Output: 1

        // Example 3: Calculate trailing zeroes for 0!
        System.out.println("Trailing zeroes in 0!: " + solution.trailingZeroes(0));  // Output: 0
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * trailingZeroes method with the desired input number. 3. The method will
 * return the number of trailing zeroes in the factorial of the input number.
 *
 * Example: Solution solution = new Solution(); int result =
 * solution.trailingZeroes(10); System.out.println("Trailing zeroes in 10!: " +
 * result);
 *
 * Design and Implementation: - The solution uses the fact that trailing zeroes
 * in a factorial are produced by pairs of 2 and 5 as factors. - Since there are
 * always more factors of 2 than 5, we only need to count the number of factors
 * of 5. - The algorithm counts the number of factors of 5 in the given number
 * by repeatedly dividing it by 5. - Time Complexity: O(log n), where n is the
 * input number. - Space Complexity: O(1), as it uses only a constant amount of
 * extra space.
 */
