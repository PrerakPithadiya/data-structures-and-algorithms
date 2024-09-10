
import java.util.HashMap;

;

/**
 * This class provides a solution to the Word Pattern problem. It checks if a
 * given pattern matches a given string of words.
 */
class Solution {

    /**
     * Determines if a given pattern matches a given string of words.
     *
     * @param pattern The pattern string, where each character represents a
     * word.
     * @param s The string of words, separated by spaces.
     * @return true if the pattern matches the string, false otherwise.
     */
    public boolean wordPattern(String pattern, String s) {
        // Split the string `s` into words
        String[] words = s.split(" ");

        // If the number of words is not equal to the number of characters in the pattern, return false
        if (words.length != pattern.length()) {
            return false;
        }

        // Create two hash maps to store the character-to-word and word-to-character mappings
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        // Iterate through the pattern and the corresponding words in `s`
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check if the character is already mapped to a different word
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            // Check if the word is already mapped to a different character
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        // If all checks pass, return true
        return true;
    }

    /**
     * Main method to demonstrate the usage of the wordPattern method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Pattern "abba" matches "dog cat cat dog"
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));  // Output: true

        // Example 2: Pattern "abba" does not match "dog cat cat fish"
        System.out.println(solution.wordPattern("abba", "dog cat cat fish"));  // Output: false

        // Example 3: Pattern "aaaa" does not match "dog cat cat dog"
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog"));  // Output: false
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * wordPattern method with two arguments: - The first argument is the pattern
 * string, where each character represents a word. - The second argument is the
 * string of words, separated by spaces. 3. The method will return true if the
 * pattern matches the string, and false otherwise.
 *
 * Example: Solution solution = new Solution(); boolean result =
 * solution.wordPattern("abba", "dog cat cat dog"); System.out.println(result);
 * // Output: true
 *
 * Design and Implementation: - The solution uses two HashMaps to maintain
 * bidirectional mappings between characters in the pattern and words in the
 * string. - It first checks if the number of words matches the number of
 * characters in the pattern. - Then, it iterates through the pattern and words
 * simultaneously, checking and updating the mappings. - If any inconsistency is
 * found in the mappings, the method returns false. - If all checks pass, the
 * method returns true, indicating a valid pattern match. - Time Complexity:
 * O(n), where n is the length of the pattern or the number of words. - Space
 * Complexity: O(k), where k is the number of unique characters in the pattern
 * or unique words in the string.
 */
