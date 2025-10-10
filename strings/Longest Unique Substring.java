
// Finds the length of the longest substring without repeating characters in a given string
class LongestUniqueSubstring {

    /**
     * Returns the length of the longest substring without repeating characters.
     * Uses a sliding window and character index array for efficient lookup.
     *
     * @param s Input string
     * @return Length of longest unique substring
     */
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; // Stores last index + 1 of each character
        int maxLen = 0, left = 0;

        // Expand the window with 'right', update 'left' to skip duplicates
        for (int right = 0; right < s.length(); right++) {
            left = Math.max(index[s.charAt(right)], left); // Move left if duplicate found
            maxLen = Math.max(maxLen, right - left + 1);   // Update max length
            index[s.charAt(right)] = right + 1;            // Store next index for character
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // Test case 1: Example from problem statement
        String s1 = "abcabcbb";
        System.out.println("Test 1: 'abcabcbb' => " + lengthOfLongestSubstring(s1)); // Expected: 3

        // Test case 2: All unique characters
        String s2 = "abcdef";
        System.out.println("Test 2: 'abcdef' => " + lengthOfLongestSubstring(s2)); // Expected: 6

        // Test case 3: All same characters
        String s3 = "aaaaaa";
        System.out.println("Test 3: 'aaaaaa' => " + lengthOfLongestSubstring(s3)); // Expected: 1

        // Test case 4: Empty string
        String s4 = "";
        System.out.println("Test 4: '' => " + lengthOfLongestSubstring(s4)); // Expected: 0

        // Test case 5: String with spaces and symbols
        String s5 = "a b!c@d#e$";
        System.out.println("Test 5: 'a b!c@d#e$' => " + lengthOfLongestSubstring(s5)); // Expected: 10
    }
}
