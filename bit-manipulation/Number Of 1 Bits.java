
/**
 * This class provides a solution for counting the number of set bits (1s) in the binary representation of an integer.
 * The problem is also known as calculating the Hamming weight of a number.
 */
class Solution {

    /**
     * Counts the number of set bits (1s) in the binary representation of an
     * integer. This method uses the Brian Kernighan's algorithm, which has a
     * time complexity of O(number of set bits).
     *
     * @param n The integer for which to count the set bits.
     * @return The number of set bits in the binary representation of n.
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // Remove the least significant set bit
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Main method to demonstrate the usage of the hammingWeight function. It
     * provides three example inputs and their corresponding outputs.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int input1 = 11;  // Binary: 1011
        System.out.println("Input: " + input1 + ", Output: " + solution.hammingWeight(input1));  // Output: 3

        // Example 2
        int input2 = 128;  // Binary: 10000000
        System.out.println("Input: " + input2 + ", Output: " + solution.hammingWeight(input2));  // Output: 1

        // Example 3
        int input3 = 2147483645;  // Binary: 1111111111111111111111111111101
        System.out.println("Input: " + input3 + ", Output: " + solution.hammingWeight(input3));  // Output: 30
    }
}

/**
 * Usage Instructions: 1. Compile the Java file: javac Solution.java 2. Run the
 * compiled class: java Solution 3. To use the hammingWeight method in your own
 * code: Solution solution = new Solution(); int result =
 * solution.hammingWeight(yourInteger);
 *
 * Note: The input integer is treated as an unsigned 32-bit integer in Java.
 */
