
/**
 * Solution class for finding the complement of a given integer.
 */
class Solution {

    /**
     * Finds the complement of a given integer.
     *
     * The complement of an integer is defined as flipping all the bits in its
     * binary representation.
     *
     * @param n The input integer for which to find the complement.
     * @return The complement of the input integer.
     */
    public int findComplement(int n) {
        // Create a mask with all bits set to 1 that covers the length of the binary representation of num
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }

        // XOR num with mask to flip the bits
        return n ^ mask;
    }
}
