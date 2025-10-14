
class Solution {

    /**
     * Calculates the Hamming distance between two integers.
     *
     * @param x The first integer.
     * @param y The second integer.
     * @return The Hamming distance between x and y.
     */
    public int hammingDistance(int x, int y) {
        // The XOR operation (x ^ y) results in a number where each bit is set to 1
        // if the corresponding bits of x and y are different, and 0 otherwise.
        int xorResult = x ^ y;

        // Integer.bitCount() efficiently counts the number of set bits (1s) in an integer.
        // This count is exactly the Hamming distance.
        return Integer.bitCount(xorResult);
    }

    /**
     * Main method to demonstrate the functionality of the hammingDistance
     * method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: The example from the problem description
        int x1 = 1, y1 = 4;
        System.out.println("Example 1 (x=1, y=4): " + solution.hammingDistance(x1, y1)); // Expected: 2

        // Example 2: Numbers with a single bit difference
        int x2 = 3, y2 = 1;
        System.out.println("Example 2 (x=3, y=1): " + solution.hammingDistance(x2, y2)); // Expected: 1

        // Example 3: More complex numbers
        int x3 = 93, y3 = 73;
        System.out.println("Example 3 (x=93, y=73): " + solution.hammingDistance(x3, y3)); // Expected: 2

        // Example 4: Identical numbers
        int x4 = 255, y4 = 255;
        System.out.println("Example 4 (x=255, y=255): " + solution.hammingDistance(x4, y4)); // Expected: 0
    }
}
