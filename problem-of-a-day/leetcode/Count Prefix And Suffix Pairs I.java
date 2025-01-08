
/**
 * Solution class for counting prefix and suffix pairs in an array of strings.
 * LeetCode Problem: Count Prefix and Suffix Pairs I
 *
 * Problem Description:
 * Given an array of strings, count the number of pairs (i,j) where:
 * - 0 <= i < j < words.length
 * - words[i] is both a prefix and suffix of words[j]
 *
 * Time Complexity: O(n^2 * m) where n is length of words array and m is average length of strings
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Counts the number of pairs where one string is both prefix and suffix of
     * another.
     *
     * @param words Array of strings to check for prefix-suffix pairs
     * @return Number of valid prefix-suffix pairs
     *
     * Example 1: Input: words = ["abc","ab","bc"] Output: 0 Explanation: No
     * string is prefix and suffix of another string
     *
     * Example 2: Input: words = ["aaa","aa"] Output: 1 Explanation: "aa" is
     * both prefix and suffix of "aaa"
     */
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Iterate through all possible pairs where i < j
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Checks if str1 is both a prefix and suffix of str2.
     *
     * @param str1 The string to check if it's a prefix and suffix
     * @param str2 The string to check against
     * @return true if str1 is both prefix and suffix of str2, false otherwise
     *
     * Example: str1 = "abc", str2 = "abcabc" -> true str1 = "abc", str2 = "abc"
     * -> true str1 = "abc", str2 = "ab" -> false
     */
    private boolean isPrefixAndSuffix(String str1, String str2) {
        // If str1 is longer than str2, it can't be a prefix or suffix
        if (str1.length() > str2.length()) {
            return false;
        }

        // Check if str1 is both a prefix and suffix of str2
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with no matches
        assert solution.countPrefixSuffixPairs(new String[]{"abc", "ab", "bc"}) == 0;

        // Test Case 2: Single match case
        assert solution.countPrefixSuffixPairs(new String[]{"aaa", "aa"}) == 1;

        // Test Case 3: Multiple matches
        assert solution.countPrefixSuffixPairs(new String[]{"a", "aa", "aaa"}) == 3;

        // Test Case 4: Empty strings
        assert solution.countPrefixSuffixPairs(new String[]{"", ""}) == 1;

        // Test Case 5: Complex strings
        assert solution.countPrefixSuffixPairs(new String[]{"abc", "abcabc", "abcd"}) == 1;

        System.out.println("All test cases passed!");
    }
}
