
/**
 * Solution for Maximum Score After Splitting a String
 *
 * Problem Description:
 * Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings
 * (left and right). The score after splitting a string is the number of zeros in the left substring plus the number
 * of ones in the right substring.
 *
 * Approach:
 * 1. Use prefix sum array to store count of zeros from left
 * 2. Use suffix sum array to store count of ones from right
 * 3. For each possible split position, calculate total score and track maximum
 *
 * Time Complexity: O(n) where n is the length of string
 * Space Complexity: O(n) for prefix and suffix arrays
 */
class Solution {

    /**
     * Calculates the maximum score possible after splitting the string
     *
     * @param s Input string containing only '0' and '1' characters
     * @return Maximum score achievable by splitting the string
     */
    public int maxScore(String s) {
        int n = s.length();
        int i = 0, j = n - 1, count1 = 0, count2 = 0, sum = 0, maxSum = Integer.MIN_VALUE;
        int[] pref = new int[n];
        int[] suff = new int[n];

        // Build prefix and suffix arrays
        while (i < n) {
            // prefix - count of zeros from left
            if (s.charAt(i) == '0') {
                count1++;
            }
            pref[i] = count1;

            // suffix - count of ones from right
            if (s.charAt(j) == '1') {
                count2++;
            }
            suff[j] = count2;

            i++;
            j--;
        }

        // Calculate maximum score for each split position
        for (i = 0; i < n - 1; i++) {
            sum = pref[i] + suff[i + 1];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /**
     * Test cases for the maxScore method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.maxScore("011101") == 5 : "Test Case 1 Failed";

        // Test Case 2: All zeros
        assert solution.maxScore("00000") == 4 : "Test Case 2 Failed";

        // Test Case 3: All ones
        assert solution.maxScore("11111") == 4 : "Test Case 3 Failed";

        // Test Case 4: Alternating zeros and ones
        assert solution.maxScore("01010") == 3 : "Test Case 4 Failed";

        // Test Case 5: Minimum length string
        assert solution.maxScore("01") == 1 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
