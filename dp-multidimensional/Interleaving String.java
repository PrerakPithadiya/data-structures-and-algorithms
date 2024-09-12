
/**
 * Solution class for the Interleaving String problem.
 * This class provides a method to determine if s3 is formed by interleaving s1 and s2.
 */
class Solution {

    /**
     * Determines if s3 is formed by interleaving s1 and s2.
     *
     * @param s1 The first string
     * @param s2 The second string
     * @param s3 The string to check if it's formed by interleaving s1 and s2
     * @return true if s3 is formed by interleaving s1 and s2, false otherwise
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();

        // If the lengths don't add up, return false
        if (m + n != s3.length()) {
            return false;
        }

        // DP table
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty s1 and s2 forms empty s3
        dp[0][0] = true;

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Check if we can form dp[i][j] from s1 and s3
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                // Check if we can form dp[i][j] from s2 and s3
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Test case 1: " + solution.isInterleave(s1, s2, s3)); // Expected: true

        // Test case 2
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println("Test case 2: " + solution.isInterleave(s1, s2, s3)); // Expected: false

        // Test case 3
        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println("Test case 3: " + solution.isInterleave(s1, s2, s3)); // Expected: true

        // Test case 4
        s1 = "a";
        s2 = "b";
        s3 = "ab";
        System.out.println("Test case 4: " + solution.isInterleave(s1, s2, s3)); // Expected: true

        // Test case 5
        s1 = "a";
        s2 = "b";
        s3 = "ba";
        System.out.println("Test case 5: " + solution.isInterleave(s1, s2, s3)); // Expected: true
    }
}

/*
 * Design and Implementation:
 * 
 * The solution uses dynamic programming to solve the Interleaving String problem.
 * 
 * 1. We first check if the sum of lengths of s1 and s2 equals the length of s3.
 *    If not, we return false as s3 cannot be formed by interleaving s1 and s2.
 * 
 * 2. We create a 2D boolean array dp where dp[i][j] represents whether the first
 *    i characters of s1 and first j characters of s2 can form the first i+j
 *    characters of s3.
 * 
 * 3. We initialize dp[0][0] as true since empty strings interleave to form an empty string.
 * 
 * 4. We then fill the dp table:
 *    - If the current character of s1 matches the current character of s3,
 *      we check if dp[i-1][j] is true.
 *    - If the current character of s2 matches the current character of s3,
 *      we check if dp[i][j-1] is true.
 *    - If either of these conditions is true, we mark dp[i][j] as true.
 * 
 * 5. Finally, dp[m][n] gives us the answer for the entire strings.
 * 
 * Time Complexity: O(m*n), where m and n are the lengths of s1 and s2 respectively.
 * Space Complexity: O(m*n) for the dp table.
 * 
 * Usage Instructions:
 * 1. Create an instance of the Solution class.
 * 2. Call the isInterleave method with three string parameters: s1, s2, and s3.
 * 3. The method will return true if s3 is formed by interleaving s1 and s2, and false otherwise.
 * 
 * Example:
 * Solution solution = new Solution();
 * boolean result = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
 * System.out.println(result); // This will print: true
 */
