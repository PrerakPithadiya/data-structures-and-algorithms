package bitmask;

import java.util.HashMap;

/**
 * This class provides a solution for counting the number of square-free subsets
 * in an array.
 * A subset is considered square-free if the product of all its elements is not
 * divisible by any perfect square greater than 1.
 */
class Solution {
    private static final int MOD = 1000000007;
    private static final int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 }; // Primes up to 30
    private static final HashMap<Integer, Integer> primeMasks = new HashMap<>();

    // Precompute the prime factor bitmask for numbers 1 to 30
    static {
        for (int num = 1; num <= 30; num++) {
            int mask = 0;
            int n = num;
            for (int i = 0; i < PRIMES.length; i++) {
                int prime = PRIMES[i];
                if (n % prime == 0) {
                    mask |= (1 << i); // Set the bit for the current prime
                    n /= prime;
                    if (n % prime == 0) { // If the prime appears more than once, it's not square-free
                        mask = -1;
                        break;
                    }
                }
            }
            primeMasks.put(num, mask);
        }
    }

    /**
     * Counts the number of square-free subsets in the given array.
     * 
     * @param nums An array of integers, each in the range [1, 30].
     * @return The number of square-free subsets, modulo 10^9 + 7.
     */
    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        long[] dp = new long[1 << PRIMES.length]; // DP array to track subsets by prime masks
        dp[0] = 1; // Base case: one empty subset

        // Count occurrences of number '1' in the array (as it doesn't affect any other
        // number)
        int countOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                countOnes++;
                continue;
            }
            int primeMask = primeMasks.get(num);
            if (primeMask == -1)
                continue; // Skip non-square-free numbers

            // Update the DP array
            for (int mask = (1 << PRIMES.length) - 1; mask >= 0; mask--) {
                if ((mask & primeMask) == 0) { // Check if adding num keeps the subset square-free
                    dp[mask | primeMask] = (dp[mask | primeMask] + dp[mask]) % MOD;
                }
            }
        }

        // Sum all non-empty subsets
        long result = 0;
        for (long x : dp) {
            result = (result + x) % MOD;
        }
        result--; // Exclude the empty subset

        // Include subsets made entirely of '1's
        if (countOnes > 0) {
            result = (result * modPow(2, countOnes, MOD)) % MOD; // Multiply by 2^countOnes
        }

        return (int) result;
    }

    /**
     * Performs fast modular exponentiation.
     * 
     * @param base The base number.
     * @param exp  The exponent.
     * @param mod  The modulus.
     * @return (base^exp) % mod
     */
    private long modPow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    /**
     * Test cases for the squareFreeSubsets method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 3, 4, 4, 5 };
        System.out.println("Test case 1: " + solution.squareFreeSubsets(nums1)); // Expected output: 3

        // Test case 2
        int[] nums2 = { 1 };
        System.out.println("Test case 2: " + solution.squareFreeSubsets(nums2)); // Expected output: 1

        // Test case 3
        int[] nums3 = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        System.out.println("Test case 3: " + solution.squareFreeSubsets(nums3)); // Expected output: 1023

        // Test case 4
        int[] nums4 = { 1, 1, 1, 1, 1 };
        System.out.println("Test case 4: " + solution.squareFreeSubsets(nums4)); // Expected output: 31

        // Test case 5
        int[] nums5 = { 2, 4, 6, 8, 10 };
        System.out.println("Test case 5: " + solution.squareFreeSubsets(nums5)); // Expected output: 2
    }
}