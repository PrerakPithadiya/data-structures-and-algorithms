
import java.util.HashSet;

/**
 * This class provides a solution to find the length of the longest substring
 * without repeating characters in a given string.
 */
class Solution {

    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * This method uses a sliding window approach with a HashSet to keep track
     * of unique characters in the current window. It iterates through the
     * string, expanding the window to the right and contracting from the left
     * when a duplicate character is found.
     *
     * Time Complexity: O(n), where n is the length of the input string. Space
     * Complexity: O(min(m, n)), where m is the size of the character set.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Remove characters from the set until the duplicate is removed
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(currentChar);
            // Update the maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Main method to run test cases for the lengthOfLongestSubstring method.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case with repeating characters
        String s1 = "abcabcbb";
        System.out.println("Test case 1: " + s1);
        System.out.println("Expected: 3, Actual: " + solution.lengthOfLongestSubstring(s1));

        // Test case 2: All repeating characters
        String s2 = "bbbbb";
        System.out.println("Test case 2: " + s2);
        System.out.println("Expected: 1, Actual: " + solution.lengthOfLongestSubstring(s2));

        // Test case 3: No repeating characters
        String s3 = "abcde";
        System.out.println("Test case 3: " + s3);
        System.out.println("Expected: 5, Actual: " + solution.lengthOfLongestSubstring(s3));

        // Test case 4: Empty string
        String s4 = "";
        System.out.println("Test case 4: " + s4);
        System.out.println("Expected: 0, Actual: " + solution.lengthOfLongestSubstring(s4));

        // Test case 5: String with spaces and special characters
        String s5 = "ab c!de";
        System.out.println("Test case 5: " + s5);
        System.out.println("Expected: 6, Actual: " + solution.lengthOfLongestSubstring(s5));
    }
}
