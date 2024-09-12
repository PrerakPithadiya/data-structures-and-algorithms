
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution for counting consistent strings based on
 * allowed characters. A string is considered consistent if it only contains
 * characters from the allowed set.
 */
class Solution {

    /**
     * Counts the number of consistent strings in the given array of words.
     *
     * @param allowed A string containing all allowed characters.
     * @param words An array of strings to check for consistency.
     * @return The number of consistent strings in the words array.
     */
    public int countConsistentStrings(String allowed, String[] words) {
        // Create a set of allowed characters for fast lookup
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        // Initialize the count of consistent strings
        int consistentCount = 0;

        // Iterate over each word in the words array
        for (String word : words) {
            boolean isConsistent = true;
            // Check if every character in the word is allowed
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;  // No need to check further if the word is inconsistent
                }
            }
            // If the word is consistent, increment the count
            if (isConsistent) {
                consistentCount++;
            }
        }

        return consistentCount;
    }

    /**
     * Main method to demonstrate the usage of the countConsistentStrings
     * method. It includes several test cases to verify the correctness of the
     * implementation.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic example
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println("Test case 1 result: " + solution.countConsistentStrings(allowed1, words1));  // Expected output: 2

        // Test case 2: All words are consistent
        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println("Test case 2 result: " + solution.countConsistentStrings(allowed2, words2));  // Expected output: 7

        // Test case 3: Mixed consistency
        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println("Test case 3 result: " + solution.countConsistentStrings(allowed3, words3));  // Expected output: 4

        // Test case 4: Empty allowed string
        String allowed4 = "";
        String[] words4 = {"a", "b", "c"};
        System.out.println("Test case 4 result: " + solution.countConsistentStrings(allowed4, words4));  // Expected output: 0

        // Test case 5: Empty words array
        String allowed5 = "xyz";
        String[] words5 = {};
        System.out.println("Test case 5 result: " + solution.countConsistentStrings(allowed5, words5));  // Expected output: 0

        // Test case 6: Single character allowed
        String allowed6 = "x";
        String[] words6 = {"x", "xx", "y", "z", "xyz"};
        System.out.println("Test case 6 result: " + solution.countConsistentStrings(allowed6, words6));  // Expected output: 2
    }
}
