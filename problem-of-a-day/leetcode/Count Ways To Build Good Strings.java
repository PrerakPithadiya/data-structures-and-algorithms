
class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;

        // dp[i] represents the number of valid strings of length i
        int[] dp = new int[high + 1];

        // Empty string is one way to form length 0
        dp[0] = 1;

        // For each length, calculate number of possible strings
        for (int i = 1; i <= high; i++) {
            // Try adding zeros
            if (i >= zero) {
                dp[i] = dp[i - zero];
            }

            // Try adding ones
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
        }

        // Sum up all possibilities from low to high
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % MOD;
        }

        return result;
    }
}
