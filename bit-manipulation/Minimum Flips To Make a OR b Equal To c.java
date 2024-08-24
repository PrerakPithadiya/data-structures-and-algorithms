
/**
 * This class provides a solution to the problem of finding the minimum number of bit flips
 * required to make (a OR b) equal to c, where a, b, and c are non-negative integers.
 */
class Solution {

    /**
     * Calculates the minimum number of bit flips required to make (a OR b)
     * equal to c.
     *
     * @param a The first integer input
     * @param b The second integer input
     * @param c The target integer
     * @return The minimum number of bit flips required
     */
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        // Iterate through all 32 bits of the integers
        for (int i = 0; i < 32; i++) {
            // Extract the i-th bit from each integer
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 0) {
                // Case 1: The i-th bit of c is 0
                // To make (a OR b) = 0, both bits must be 0
                if (bitA == 1) {
                    flips++;
                }
                if (bitB == 1) {
                    flips++;
                }
            } else {
                // Case 2: The i-th bit of c is 1
                // To make (a OR b) = 1, at least one of a or b should be 1
                if (bitA == 0 && bitB == 0) {
                    flips++; // We need to flip one of a or b to make it 1
                }
            }
        }

        return flips;
    }

    /**
     * Main method to demonstrate the usage of the minFlips method with example
     * inputs.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println("Example 1: " + solution.minFlips(a1, b1, c1)); // Output: 3

        // Example 2
        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println("Example 2: " + solution.minFlips(a2, b2, c2)); // Output: 1

        // Example 3
        int a3 = 1, b3 = 2, c3 = 3;
        System.out.println("Example 3: " + solution.minFlips(a3, b3, c3)); // Output: 0
    }
}
