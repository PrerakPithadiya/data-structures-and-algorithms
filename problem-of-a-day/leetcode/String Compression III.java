package LeetCode;

/**
 * Solution class for string compression problem This class provides a method to
 * compress strings by counting consecutive characters
 */
class Solution {

    /**
     * Compresses a string by counting consecutive characters (up to 9) and
     * representing them as count+character For example: "aaa" becomes "3a",
     * "aabb" becomes "2a2b"
     *
     * @param word the input string to compress
     * @return the compressed string representation
     */
    public String compressString(String word) {
        StringBuilder comp = new StringBuilder();
        int i = 0;

        while (i < word.length()) {
            char currentChar = word.charAt(i);
            int count = 0;

            // Count up to 9 consecutive identical characters
            while (i < word.length() && word.charAt(i) == currentChar && count < 9) {
                count++;
                i++;
            }

            // Append count followed by the character to comp
            comp.append(count).append(currentChar);
        }

        return comp.toString();
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic compression
        assert solution.compressString("aaa").equals("3a");

        // Test case 2: Different characters
        assert solution.compressString("aabb").equals("2a2b");

        // Test case 3: More than 9 consecutive characters
        assert solution.compressString("aaaaaaaaaa").equals("9a1a");

        // Test case 4: Single characters
        assert solution.compressString("abc").equals("1a1b1c");

        // Test case 5: Empty string
        assert solution.compressString("").equals("");

        System.out.println("All test cases passed!");
    }
}
