import java.util.Arrays;

/**
 * This class provides a solution to determine if two strings are close.
 * Two strings are considered close if they can be transformed into each other
 * using the following operations any number of times:
 * 1. Swap any two existing characters.
 * 2. Transform every occurrence of one existing character into another existing
 * character,
 * and do the same with the other character.
 */
class Solution {
    /**
     * Determines if two given strings are close.
     *
     * @param word1 The first string to compare.
     * @param word2 The second string to compare.
     * @return true if the strings are close, false otherwise.
     */
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        // Step 1: Create frequency arrays for both words
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }

        // Step 2: Check if both strings have the same set of characters
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] > 0 && freq2[i] == 0) || (freq1[i] == 0 && freq2[i] > 0)) {
                return false;
            }
        }

        // Step 3: Check if the frequency distribution can be rearranged to match
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }

    /**
     * Main method to demonstrate the functionality of the closeStrings method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(solution.closeStrings(word1, word2)); // Output: true

        // Example 2
        word1 = "a";
        word2 = "aa";
        System.out.println(solution.closeStrings(word1, word2)); // Output: false

        // Example 3
        word1 = "cabbba";
        word2 = "abbccc";
        System.out.println(solution.closeStrings(word1, word2)); // Output: true
    }
}
