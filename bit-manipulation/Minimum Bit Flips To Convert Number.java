
/**
 * This class provides a solution to find the minimum number of bit flips required
 * to convert one integer to another.
 */
class Solution {

    /**
     * Calculates the minimum number of bit flips required to convert the start
     * integer to the goal integer.
     *
     * @param start The starting integer.
     * @param goal The target integer.
     * @return The minimum number of bit flips required.
     */
    public int minBitFlips(int start, int goal) {
        // Step 1: XOR the two numbers to find differing bits
        int xor = start ^ goal;

        // Step 2: Count the number of 1s in the XOR result
        int bitFlips = 0;
        while (xor > 0) {
            bitFlips += xor & 1; // Add 1 if the least significant bit is 1
            xor >>= 1; // Right shift to check the next bit
        }

        return bitFlips;
    }

    /**
     * Main method to demonstrate the usage of the minBitFlips method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int start1 = 10;
        int goal1 = 7;
        System.out.println("Example 1:");
        System.out.println("Start: " + start1 + ", Goal: " + goal1);
        System.out.println("Minimum bit flips: " + solution.minBitFlips(start1, goal1));

        // Example 2
        int start2 = 3;
        int goal2 = 4;
        System.out.println("\nExample 2:");
        System.out.println("Start: " + start2 + ", Goal: " + goal2);
        System.out.println("Minimum bit flips: " + solution.minBitFlips(start2, goal2));
    }
}
