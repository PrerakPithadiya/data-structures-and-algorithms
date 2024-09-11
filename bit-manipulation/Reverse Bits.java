
/**
 * This class provides a solution for reversing the bits of a 32-bit integer.
 */
class Solution {

    /**
     * Reverses the bits of a 32-bit integer.
     *
     * @param n The 32-bit integer to reverse.
     * @return The integer with its bits reversed.
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = n & 1;
            // Append the bit to result at the reversed position
            result = (result << 1) | bit;
            // Shift n to the right to process the next bit
            n >>= 1;
        }
        return result;
    }

    /**
     * Main method to demonstrate the usage of the reverseBits method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int input1 = 0b00000010100101000001111010011100;
        System.out.println("Example 1:");
        System.out.println("Input: " + Integer.toBinaryString(input1));
        int output1 = solution.reverseBits(input1);
        System.out.println("Output: " + output1 + " (" + Integer.toBinaryString(output1) + ")");

        // Example 2
        int input2 = 0b11111111111111111111111111111101;
        System.out.println("\nExample 2:");
        System.out.println("Input: " + Integer.toBinaryString(input2));
        int output2 = solution.reverseBits(input2);
        System.out.println("Output: " + output2 + " (" + Integer.toBinaryString(output2) + ")");
    }
}

/*
 * Usage Instructions:
 * 1. Compile the Java file: javac Solution.java
 * 2. Run the compiled class: java Solution
 *
 * The program will demonstrate the reverseBits method with two examples:
 * - Example 1: Reverses the bits of 0b00000010100101000001111010011100
 * - Example 2: Reverses the bits of 0b11111111111111111111111111111101
 *
 * The output will show the original input in binary format, followed by
 * the reversed result in both decimal and binary formats.
 *
 * To use the reverseBits method in your own code:
 * 1. Create an instance of the Solution class
 * 2. Call the reverseBits method with a 32-bit integer as the argument
 * 3. The method will return the integer with its bits reversed
 *
 * Example:
 *     Solution solution = new Solution();
 *     int reversed = solution.reverseBits(someInteger);
 */
