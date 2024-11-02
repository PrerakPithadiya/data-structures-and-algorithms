package LeetCode;

/**
 * Solution for making a fancy string by removing characters to prevent three
 * consecutive same characters. A fancy string is a string where no three
 * consecutive characters are equal.
 */
class Solution {

    /**
     * Converts a given string into a fancy string by removing characters where
     * necessary.
     *
     * @param s The input string to be converted
     * @return A fancy string where no three consecutive characters are equal
     */
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            // Check the last two characters in the result
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == c && result.charAt(len - 2) == c) {
                // Skip adding this character to prevent three consecutive same characters
                continue;
            }
            // Append the character to the result
            result.append(c);
        }

        return result.toString();
    }

    /**
     * Test cases to verify the functionality of makeFancyString method.
     */
    public void testCases() {
        // Test case 1: Basic case with consecutive characters
        assert makeFancyString("leeetcode").equals("leetcode");

        // Test case 2: String with no three consecutive characters
        assert makeFancyString("aabaa").equals("aabaa");

        // Test case 3: String with multiple groups of consecutive characters
        assert makeFancyString("aaabaaaa").equals("aabaa");

        // Test case 4: Empty string
        assert makeFancyString("").equals("");

        // Test case 5: Single character
        assert makeFancyString("a").equals("a");

        // Test case 6: Two consecutive characters
        assert makeFancyString("aa").equals("aa");

        System.out.println("All test cases passed!");
    }
}
