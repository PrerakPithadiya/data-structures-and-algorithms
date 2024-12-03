
/**
 * Solution for LeetCode problem: Adding Spaces to a String
 * Given a string s and an array of integers spaces that describes the indices in the original string
 * where spaces should be added, return the modified string after adding spaces.
 *
 * Time Complexity: O(n) where n is the length of input string
 * Space Complexity: O(n) for storing the result string
 */
class Solution {

    /**
     * Adds spaces to a string at specified indices
     *
     * @param s The input string to add spaces to
     * @param spaces Array of indices where spaces should be added
     * @return Modified string with spaces added at specified positions
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int spaceIndex = 0;
        int sLength = s.length();
        int spacesLength = spaces.length;

        for (int i = 0; i < sLength; i++) {
            // Check if we need to add a space before the current character
            if (spaceIndex < spacesLength && i == spaces[spaceIndex]) {
                result.append(' '); // Add space
                spaceIndex++; // Move to the next space index
            }
            result.append(s.charAt(i)); // Add the current character
        }

        return result.toString();
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "LeetcodeHelpsMeLearn";
        int[] spaces1 = {8, 13, 15};
        System.out.println("Test 1: " + solution.addSpaces(s1, spaces1)); // Expected: "Leetcode Helps Me Learn"

        // Test case 2
        String s2 = "icodeinpython";
        int[] spaces2 = {1, 5, 7, 9};
        System.out.println("Test 2: " + solution.addSpaces(s2, spaces2)); // Expected: "i code in py thon"

        // Test case 3
        String s3 = "spacing";
        int[] spaces3 = {0, 1, 2, 3, 4, 5, 6};
        System.out.println("Test 3: " + solution.addSpaces(s3, spaces3)); // Expected: " s p a c i n g"
    }
}
