
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for LeetCode problem: String Matching in an Array
 *
 * Problem Description: Given an array of string words, return all strings in
 * words that are a substring of another word. A substring is a contiguous
 * sequence of characters within a string.
 *
 * Time Complexity: O(n^2 * m) where n is the number of words and m is the
 * average length of words Space Complexity: O(n) where n is the number of words
 * that are substrings
 */
class Solution {

    /**
     * Finds all strings that are substrings of another string in the given
     * array.
     *
     * @param words Array of strings to check for substring relationships
     * @return List of strings that are substrings of another word in the array
     */
    public List<String> stringMatching(String[] words) {
        // Using HashSet to automatically handle duplicates
        Set<String> result = new HashSet<>();

        // Compare each string with all other strings
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip comparing string with itself
                if (i != j) {
                    // Check if words[i] is a substring of words[j]
                    if (words[j].contains(words[i])) {
                        result.add(words[i]);
                        // Once we find a match, we can break the inner loop
                        break;
                    }
                }
            }
        }

        // Convert Set to List and return
        return new ArrayList<>(result);
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with obvious substrings
        String[] test1 = {"mass", "as", "hero", "superhero"};
        assert solution.stringMatching(test1).containsAll(List.of("as", "hero"));

        // Test Case 2: No substrings
        String[] test2 = {"cat", "dog", "bird"};
        assert solution.stringMatching(test2).isEmpty();

        // Test Case 3: Multiple occurrences of same substring
        String[] test3 = {"leetcode", "et", "code", "leetcode"};
        assert solution.stringMatching(test3).containsAll(List.of("code", "et"));

        // Test Case 4: Empty array
        String[] test4 = {};
        assert solution.stringMatching(test4).isEmpty();

        // Test Case 5: Single character substrings
        String[] test5 = {"blue", "b", "lu"};
        assert solution.stringMatching(test5).containsAll(List.of("b", "lu"));

        System.out.println("All test cases passed!");
    }
}
