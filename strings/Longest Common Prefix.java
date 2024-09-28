
/**
 * This class provides a solution for finding the longest common prefix among an array of strings.
 */
class LongestCommonPrefix {

    /**
     * Finds the longest common prefix among an array of strings.
     *
     * @param strs An array of strings to search for a common prefix.
     * @return The longest common prefix as a string. If no common prefix
     * exists, returns an empty string.
     */
    public String longestCommonPrefix(String[] strs) {
        // Edge case: If the input array is empty or null, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize the prefix as the first string in the array
        String prefix = strs[0];

        // Loop through the remaining strings in the array
        for (int i = 1; i < strs.length; i++) {
            // Keep reducing the prefix until it matches the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the common prefix found
        return prefix;
    }

    /**
     * Main method to demonstrate the usage of the LongestCommonPrefix class.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        // Test case 1: Array with a common prefix
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Test case 1 result: " + solution.longestCommonPrefix(strs1));  // Expected output: "fl"

        // Test case 2: Array without a common prefix
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Test case 2 result: " + solution.longestCommonPrefix(strs2));  // Expected output: ""
    }
}

/*
 * Usage Instructions:
 * 1. Create an instance of the LongestCommonPrefix class.
 * 2. Call the longestCommonPrefix method with an array of strings as the argument.
 * 3. The method will return the longest common prefix as a string.
 *
 * Example:
 *     LongestCommonPrefix solution = new LongestCommonPrefix();
 *     String[] words = {"prefix", "preface", "preview"};
 *     String result = solution.longestCommonPrefix(words);
 *     System.out.println(result);  // Output: "pre"
 *
 * Time Complexity: O(S), where S is the sum of all characters in all strings.
 * Space Complexity: O(1), as we only use a constant amount of extra space.
 *
 * Note: This implementation is case-sensitive. To make it case-insensitive,
 * convert all strings to lowercase before processing.
 */
