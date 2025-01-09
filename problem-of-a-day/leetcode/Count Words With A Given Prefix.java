
/**
 * Solution for LeetCode problem: Count Words With A Given Prefix
 *
 * This class provides a method to count the number of strings in an array that start with a given prefix.
 * Time Complexity: O(n * m) where n is the number of words and m is the average length of prefix
 * Space Complexity: O(1) as we only use a constant amount of extra space
 */
class Solution {

    /**
     * Counts the number of strings in the given array that start with the
     * specified prefix.
     *
     * @param words An array of strings to check
     * @param pref The prefix to search for
     * @return The number of strings that start with the given prefix
     *
     * Example 1: Input: words = ["pay","attention","practice","attend"], pref =
     * "at" Output: 2 Explanation: "attention" and "attend" start with prefix
     * "at"
     *
     * Example 2: Input: words = ["leetcode"], pref = "lee" Output: 1
     * Explanation: Only "leetcode" starts with prefix "lee"
     *
     * Example 3: Input: words = ["hello","world"], pref = "x" Output: 0
     * Explanation: No words start with prefix "x"
     */
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        // Iterate through each word in the array
        for (String word : words) {
            // Check if the current word starts with the prefix
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] test1 = {"pay", "attention", "practice", "attend"};
        assert solution.prefixCount(test1, "at") == 2 : "Test case 1 failed";

        // Test case 2
        String[] test2 = {"leetcode"};
        assert solution.prefixCount(test2, "lee") == 1 : "Test case 2 failed";

        // Test case 3
        String[] test3 = {"hello", "world"};
        assert solution.prefixCount(test3, "x") == 0 : "Test case 3 failed";

        // Test case 4: Empty array
        String[] test4 = {};
        assert solution.prefixCount(test4, "test") == 0 : "Test case 4 failed";

        // Test case 5: Empty prefix
        String[] test5 = {"test", "testing"};
        assert solution.prefixCount(test5, "") == 2 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
