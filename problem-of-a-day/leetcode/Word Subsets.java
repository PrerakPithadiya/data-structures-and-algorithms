
/**
 * Solution for LeetCode problem: Word Subsets
 *
 * Problem Description:
 * Given two string arrays words1 and words2, return a list of all the strings in words1 that are universal
 * with respect to words2. A string word is universal if for every string in words2, all the characters in
 * that string appear in word with the same or greater frequency.
 *
 * Approach:
 * 1. Calculate the maximum frequency required for each character from all strings in words2
 * 2. For each word in words1, check if it contains all required characters with sufficient frequency
 * 3. Use character frequency arrays to efficiently track and compare character counts
 *
 * Time Complexity: O(N * M) where N is total length of words1 and M is total length of words2
 * Space Complexity: O(1) as we use fixed size arrays of length 26
 */
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Finds all strings in words1 that are universal with respect to words2.
     *
     * @param words1 Array of candidate strings to check
     * @param words2 Array of strings whose characters must be covered
     * @return List of strings from words1 that are universal
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        // Get the maximum frequency of each character needed from words2
        int[] maxFreqW2 = new int[26];
        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreqW2[i] = Math.max(maxFreqW2[i], freq[i]);
            }
        }

        // Check each word in words1
        for (String word : words1) {
            int[] freqW1 = getFrequency(word);
            if (isUniversal(freqW1, maxFreqW2)) {
                result.add(word);
            }
        }

        return result;
    }

    /**
     * Calculates frequency of each character in the given word.
     *
     * @param word Input string to analyze
     * @return Array of size 26 containing frequency of each lowercase letter
     */
    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    /**
     * Checks if one frequency array contains all characters with at least the
     * frequency specified in another array.
     *
     * @param freqW1 Frequency array of the word being checked
     * @param maxFreqW2 Required minimum frequencies
     * @return true if freqW1 meets or exceeds all frequencies in maxFreqW2
     */
    private boolean isUniversal(int[] freqW1, int[] maxFreqW2) {
        for (int i = 0; i < 26; i++) {
            if (freqW1[i] < maxFreqW2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Test cases for the wordSubsets method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        assert solution.wordSubsets(words1, words2).equals(List.of("facebook", "google", "leetcode"));

        // Test Case 2: Empty words2
        String[] words1_2 = {"hello", "world"};
        String[] words2_2 = {};
        assert solution.wordSubsets(words1_2, words2_2).equals(List.of("hello", "world"));

        // Test Case 3: No matches
        String[] words1_3 = {"abc", "def"};
        String[] words2_3 = {"xyz"};
        assert solution.wordSubsets(words1_3, words2_3).isEmpty();

        // Test Case 4: Multiple character frequencies
        String[] words1_4 = {"warrior", "world"};
        String[] words2_4 = {"wr", "r"};
        assert solution.wordSubsets(words1_4, words2_4).equals(List.of("warrior"));

        System.out.println("All test cases passed!");
    }
}
