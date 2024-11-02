package LeetCode;

/**
 * Solution for LeetCode problem: Circular Sentence
 *
 * A circular sentence is a sentence where every word connects with the next
 * word in a circular manner. The last character of each word matches the first
 * character of the next word, and the last character of the last word matches
 * the first character of the first word.
 */
class Solution {

    /**
     * Determines if a given sentence is circular.
     *
     * @param sentence The input sentence to check
     * @return true if the sentence is circular, false otherwise
     *
     * Example 1: Input: sentence = "leetcode exercises sound delightful"
     * Output: true Explanation: The last character of each word matches the
     * first character of the next word. "leetcodE" -> "exerciseS" -> "sounD" ->
     * "delightfuL" -> "leetcodE"
     *
     * Example 2: Input: sentence = "eetcode" Output: true Explanation: The
     * first and last characters match, making it circular.
     *
     * Example 3: Input: sentence = "Leetcode is cool" Output: false
     * Explanation: "Leetcode" and "is" do not share the same first/last
     * characters.
     */
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");

        // Loop through each word to check circular condition
        for (int i = 0; i < words.length; i++) {
            // Get the last character of the current word
            char lastChar = words[i].charAt(words[i].length() - 1);
            // Get the first character of the next word (circularly)
            char firstChar = words[(i + 1) % words.length].charAt(0);

            // Check if the last character of the current word matches the first character of the next word
            if (lastChar != firstChar) {
                return false;
            }
        }

        // If all checks passed, the sentence is circular
        return true;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String test1 = "leetcode exercises sound delightful";
        System.out.println("Test 1: " + solution.isCircularSentence(test1)); // Expected: true

        // Test case 2
        String test2 = "eetcode";
        System.out.println("Test 2: " + solution.isCircularSentence(test2)); // Expected: true

        // Test case 3
        String test3 = "Leetcode is cool";
        System.out.println("Test 3: " + solution.isCircularSentence(test3)); // Expected: false

        // Additional test case
        String test4 = "happy programming person";
        System.out.println("Test 4: " + solution.isCircularSentence(test4)); // Expected: false
    }
}
