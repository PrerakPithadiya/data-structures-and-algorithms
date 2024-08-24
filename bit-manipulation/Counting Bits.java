
/**
 * This class provides a solution for counting the number of 1's in the binary representation
 * of all numbers from 0 to n.
 */
class Solution {

    /**
     * Counts the number of 1's in the binary representation of all numbers from
     * 0 to n.
     *
     * @param n The upper limit of the range (inclusive)
     * @return An array where the i-th element represents the count of 1's in
     * the binary representation of i
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        // Fill the ans array using the previously described relation
        for (int i = 0; i <= n; i++) {
            // The number of 1's in i is equal to the number of 1's in i/2 plus the least significant bit of i
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    /**
     * Main method to demonstrate the usage of the countBits method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Count bits for n = 2
        int n1 = 2;
        int[] result1 = solution.countBits(n1);
        System.out.println("Example 1 (n = 2): " + java.util.Arrays.toString(result1)); // Output: [0, 1, 1]

        // Example 2: Count bits for n = 5
        int n2 = 5;
        int[] result2 = solution.countBits(n2);
        System.out.println("Example 2 (n = 5): " + java.util.Arrays.toString(result2)); // Output: [0, 1, 1, 2, 1, 2]
    }
}
