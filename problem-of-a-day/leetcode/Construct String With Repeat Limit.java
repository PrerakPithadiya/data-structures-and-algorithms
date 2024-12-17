
/**
 * Solution for LeetCode Problem: Construct String With Repeat Limit
 *
 * Problem Description:
 * Given a string s and an integer repeatLimit, construct a new string by repeating
 * characters from s such that no letter appears more than repeatLimit times in a row.
 * Return the lexicographically largest possible string that can be constructed.
 *
 * Approach:
 * 1. Count frequency of each character in input string
 * 2. Use max heap to process characters in lexicographically descending order
 * 3. Build result string while respecting repeat limit:
 *    - Use maximum possible occurrences of current largest char
 *    - If more occurrences remain, use next largest char as breaker
 *
 * Time Complexity: O(n log k) where n is length of input string, k is unique characters
 * Space Complexity: O(1) as we use fixed size arrays and heap of max 26 characters
 */
import java.util.PriorityQueue;

class Solution {

    /**
     * Constructs a string with repeat limit from given input string.
     *
     * @param s Input string containing lowercase English letters
     * @param repeatLimit Maximum number of times a character can appear
     * consecutively
     * @return Lexicographically largest possible string respecting the repeat
     * limit
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        // Step 1: Frequency count
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max heap to store characters sorted by lexicographical order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // Store character index and its frequency
            }
        }

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll(); // Get the largest character
            int charIndex = current[0];
            int charCount = current[1];

            // How many times can we use this character now?
            int limit = Math.min(repeatLimit, charCount);

            // Append the character 'limit' times
            for (int i = 0; i < limit; i++) {
                result.append((char) (charIndex + 'a'));
            }

            // Update remaining count
            charCount -= limit;

            // If the current character still has remaining count
            if (charCount > 0) {
                if (maxHeap.isEmpty()) {
                    // No breaker character available; stop
                    break;
                }

                // Use the next largest character as a breaker
                int[] next = maxHeap.poll();
                int nextCharIndex = next[0];
                int nextCharCount = next[1];

                // Append the breaker character once
                result.append((char) (nextCharIndex + 'a'));
                nextCharCount--;

                // Reinsert both characters with updated counts
                if (nextCharCount > 0) {
                    maxHeap.offer(new int[]{nextCharIndex, nextCharCount});
                }
                maxHeap.offer(new int[]{charIndex, charCount});
            }
        }

        return result.toString();
    }

    /**
     * Test cases for the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.repeatLimitedString("cczazcc", 3).equals("zzcccac") : "Test case 1 failed";

        // Test Case 2: Single character
        assert solution.repeatLimitedString("aaa", 1).equals("a") : "Test case 2 failed";

        // Test Case 3: Two characters
        assert solution.repeatLimitedString("aaabb", 2).equals("aabab") : "Test case 3 failed";

        // Test Case 4: Empty string
        assert solution.repeatLimitedString("", 1).equals("") : "Test case 4 failed";

        // Test Case 5: Large repeat limit
        assert solution.repeatLimitedString("abc", 10).equals("cba") : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
