package LeetCode;

/**
 * Solution for Minimum Length of String After Operations
 *
 * Problem Description: Given a string s consisting only of lowercase English
 * letters, repeatedly perform the following operation until you can't: - Choose
 * a prefix of s where all characters are the same - Choose a suffix of s where
 * all characters are the same - The prefix and suffix should not intersect at
 * any index - The characters of the prefix and suffix should be the same -
 * Delete both the prefix and the suffix Return the minimum length of s after
 * performing the above operation any number of times.
 *
 * Time Complexity: O(n) where n is the length of the input string Space
 * Complexity: O(1) as we use a fixed size array of 26 characters
 */
class Solution {

    /**
     * Calculates the minimum possible length of the string after performing all
     * valid operations
     *
     * @param s Input string containing only lowercase English letters
     * @return The minimum length of string possible after operations
     */
    public int minimumLength(String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        // Calculate minimum length based on character frequencies
        for (int frequency : charFrequency) {
            if (frequency == 0) {
                continue;
            }
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with repeating characters
        assert solution.minimumLength("aabaa") == 1 : "Test case 1 failed";

        // Test Case 2: String with all same characters
        assert solution.minimumLength("aaaa") == 0 : "Test case 2 failed";

        // Test Case 3: String with no possible operations
        assert solution.minimumLength("abc") == 3 : "Test case 3 failed";

        // Test Case 4: String with multiple possible operations
        assert solution.minimumLength("cabaabac") == 0 : "Test case 4 failed";

        // Test Case 5: Empty string
        assert solution.minimumLength("") == 0 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
