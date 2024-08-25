
/**
 * Solution class for calculating the Nth Tribonacci number.
 * The Tribonacci sequence is defined as follows:
 * T(0) = 0, T(1) = 1, T(2) = 1, and T(n+3) = T(n) + T(n+1) + T(n+2) for n >= 0.
 */
class Solution {

    /**
     * Calculates the Nth Tribonacci number.
     *
     * @param n The index of the Tribonacci number to calculate (n >= 0)
     * @return The Nth Tribonacci number
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int t0 = 0, t1 = 1, t2 = 1;
        int tn = 0;

        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }

        return tn;
    }

    /**
     * Main method to demonstrate the usage of the tribonacci method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Tribonacci(4) = " + solution.tribonacci(4));   // Output: 4
        System.out.println("Tribonacci(25) = " + solution.tribonacci(25)); // Output: 1389537
    }
}
