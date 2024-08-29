
/**
 * This class provides a solution to find the longest palindromic substring in a given string.
 * It uses the expand around center approach to efficiently find palindromes.
 */
class Solution {

    /**
     * Finds the longest palindromic substring in the given string.
     *
     * @param s The input string
     * @return The longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // even-length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * Expands around the center of a potential palindrome to find its length.
     *
     * @param s The input string
     * @param left The left index of the center
     * @param right The right index of the center
     * @return The length of the palindrome
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Main method to test the Solution class with various test cases.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Multiple palindromes
        String s1 = "babad";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.longestPalindrome(s1));

        // Test case 2: Even-length palindrome
        String s2 = "cbbd";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.longestPalindrome(s2));

        // Test case 3: Single character
        String s3 = "a";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.longestPalindrome(s3));

        // Test case 4: No palindrome longer than 1
        String s4 = "ac";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.longestPalindrome(s4));

        // Test case 5: Whole string is a palindrome
        String s5 = "racecar";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + solution.longestPalindrome(s5));
    }
}
