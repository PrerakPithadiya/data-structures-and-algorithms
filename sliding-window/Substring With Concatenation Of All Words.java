
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class provides a solution for finding all starting indices of substrings
 * in a given string that are a concatenation of all words from a given array.
 */
class Solution {

    /**
     * Finds all starting indices of substrings in s that are a concatenation of
     * each word in words exactly once.
     *
     * @param s The input string to search in.
     * @param words An array of words to concatenate and search for.
     * @return A list of integers representing the starting indices of matching
     * substrings.
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        // Create a frequency map for the words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Slide over the string s with window length totalLen
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> windowFreq = new HashMap<>();
            int left = i;
            int right = i;
            int count = 0;

            while (right + wordLen <= s.length()) {
                // Get the next word in the window
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    windowFreq.put(word, windowFreq.getOrDefault(word, 0) + 1);
                    count++;

                    // Check if the word count exceeds the frequency map
                    while (windowFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowFreq.put(leftWord, windowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // Check if all words are matched
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset the window
                    windowFreq.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }

    /**
     * Main method to run test cases for the findSubstring method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case with two words
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println("Test case 1: " + solution.findSubstring(s1, words1)); // Expected: [0, 9]

        // Test case 2: No matching substrings
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println("Test case 2: " + solution.findSubstring(s2, words2)); // Expected: []

        // Test case 3: Multiple matching substrings
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println("Test case 3: " + solution.findSubstring(s3, words3)); // Expected: [6, 9, 12]

        // Test case 4: Longer words and string
        String s4 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words4 = {"fooo", "barr", "wing", "ding", "wing"};
        System.out.println("Test case 4: " + solution.findSubstring(s4, words4)); // Expected: [13]

        // Test case 5: Overlapping matches
        String s5 = "wordwordword";
        String[] words5 = {"word", "word"};
        System.out.println("Test case 5: " + solution.findSubstring(s5, words5)); // Expected: [0, 3]
    }
}
