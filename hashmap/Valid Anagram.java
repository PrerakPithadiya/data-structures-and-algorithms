
/**
 * Solution class for checking if two strings are anagrams.
 */
class Solution {

    /**
     * Determines if two strings are anagrams of each other.
     *
     * @param s The first input string.
     * @param t The second input string.
     * @return true if the strings are anagrams, false otherwise.
     */
    public boolean isAnagram(String s, String t) {
        // If lengths are not the same, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Array to store character counts for 'a' to 'z'
        int[] charCount = new int[26];

        // Traverse through both strings
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment count for char in s
            charCount[t.charAt(i) - 'a']--; // Decrement count for char in t
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false; // If any count is non-zero, s and t are not anagrams
            }
        }

        return true; // All counts are zero, s and t are anagrams
    }

    /**
     * Main method to demonstrate the usage of the isAnagram method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isAnagram("anagram", "nagaram")); // Expected output: true
        System.out.println(solution.isAnagram("rat", "car")); // Expected output: false
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * isAnagram method with two strings as arguments. 3. The method will return
 * true if the strings are anagrams, false otherwise.
 *
 * Example: Solution solution = new Solution(); boolean result =
 * solution.isAnagram("listen", "silent");
 *
 * Design: - The solution uses a character counting approach to determine if two
 * strings are anagrams. - It first checks if the lengths of the input strings
 * are equal. If not, they can't be anagrams. - It then uses an integer array to
 * keep track of character counts. - The array indices correspond to lowercase
 * letters (a-z). - It increments the count for characters in the first string
 * and decrements for the second. - If the strings are anagrams, all counts
 * should be zero at the end.
 *
 * Implementation Details: - Time Complexity: O(n), where n is the length of the
 * input strings. - Space Complexity: O(1), as the character count array has a
 * fixed size of 26. - The solution assumes that the input strings contain only
 * lowercase English letters. - It uses ASCII value manipulation to map
 * characters to array indices.
 */
