
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to the "Minimum Window Substring" problem. The
 * problem involves finding the smallest substring in a given string that
 * contains all characters of another string.
 */
class Solution {

    /**
     * Finds the minimum window substring that contains all characters of t in
     * s.
     *
     * @param s The source string to search in.
     * @param t The target string containing characters to be found.
     * @return The minimum window substring, or an empty string if no such
     * substring exists.
     */
    public String minWindow(String s, String t) {
        // Check for invalid input
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Create frequency map for characters in t
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int required = tFreq.size(); // Number of unique characters in t
        int l = 0, r = 0; // Left and right pointers for the sliding window
        int formed = 0; // Number of characters in t that have been satisfied in the current window
        Map<Character, Integer> windowFreq = new HashMap<>(); // Frequency map for characters in the current window
        int minLength = Integer.MAX_VALUE; // Length of the minimum window found so far
        int minLeft = 0; // Starting index of the minimum window

        // Slide the window over the string s
        while (r < s.length()) {
            // Add character from the right to the window
            char c = s.charAt(r);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            // Check if the current character satisfies a requirement in t
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window from the left
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update minimum length and starting index if a smaller window is found
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minLeft = l;
                }

                // Remove character from the left of the window
                windowFreq.put(c, windowFreq.get(c) - 1);
                if (tFreq.containsKey(c) && windowFreq.get(c) < tFreq.get(c)) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        // Return the minimum window substring or an empty string if not found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    /**
     * Main method to run test cases for the minWindow function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Test case 1:");
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s1, t1) + "\"");
        System.out.println("Expected: \"BANC\"");
        System.out.println();

        // Test case 2
        String s2 = "a";
        String t2 = "a";
        System.out.println("Test case 2:");
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s2, t2) + "\"");
        System.out.println("Expected: \"a\"");
        System.out.println();

        // Test case 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Test case 3:");
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s3, t3) + "\"");
        System.out.println("Expected: \"\"");
        System.out.println();

        // Test case 4
        String s4 = "ADOBECODEBANC";
        String t4 = "ABCC";
        System.out.println("Test case 4:");
        System.out.println("Input: s = \"" + s4 + "\", t = \"" + t4 + "\"");
        System.out.println("Output: \"" + solution.minWindow(s4, t4) + "\"");
        System.out.println("Expected: \"CODECBANC\"");
    }
}
