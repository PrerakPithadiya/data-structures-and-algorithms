package LeetCode;

/**
 * Solution for checking if a word occurs as a prefix in a sentence LeetCode
 * Problem: Check If a Word Occurs As a Prefix of Any Word in a Sentence
 */
class Solution {

    /**
     * Finds the 1-based index of the first word in the sentence that starts
     * with the given search word
     *
     * @param sentence The input sentence containing space-separated words
     * @param searchWord The prefix to search for
     * @return The 1-based index of the first word that starts with searchWord,
     * or -1 if no word matches
     */
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Iterate through the words
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with searchWord
            if (words[i].startsWith(searchWord)) {
                return i + 1; // Return 1-based index
            }
        }

        // If no word matches, return -1
        return -1;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case with match
        assert solution.isPrefixOfWord("i love eating burger", "burg") == 4;

        // Test case 2: Match at first word
        assert solution.isPrefixOfWord("hello world", "hell") == 1;

        // Test case 3: No match
        assert solution.isPrefixOfWord("i am tired", "you") == -1;

        // Test case 4: Empty search word
        assert solution.isPrefixOfWord("this is a sentence", "") == 1;

        // Test case 5: Case sensitive match
        assert solution.isPrefixOfWord("Hello hello HELLO", "hell") == 2;

        System.out.println("All test cases passed!");
    }
}
