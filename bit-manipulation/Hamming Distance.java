/**
 * <h2>Hamming Distance</h2>
 *
 * <p>
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * </p>
 *
 * <p>
 * Given two integers <code>x</code> and <code>y</code>, this solution
 * calculates the Hamming distance.
 * </p>
 *
 * <h3>Example:</h3>
 * <p>
 * Input: x = 1, y = 4
 * </p>
 * <p>
 * Output: 2
 * </p>
 *
 * <p>
 * Explanation:
 * </p>
 * <p>
 * 1 (0 0 0 1)
 * </p>
 * <p>
 * 4 (0 1 0 0)
 * </p>
 * <p>
 * &uarr; &uarr;
 * </p>
 * <p>
 * The arrows point to the positions where the corresponding bits are different.
 * </p>
 *
 * <h3>Significance:</h3>
 * <p>
 * The Hamming distance is a fundamental concept in computer science and
 * telecommunications, crucial for error detection and correction in data
 * transmission (coding theory). It measures the dissimilarity between two
 * strings of equal length, ensuring data integrity over noisy channels. It also
 * finds applications in cryptography and bioinformatics.
 * </p>
 */
public class Solution {
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
