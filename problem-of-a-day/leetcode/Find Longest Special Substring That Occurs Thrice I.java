
/**
 * LeetCode Problem: Find Longest Special Substring That Occurs Thrice I
 *
 * Problem Description:
 * Given a string s, find the longest special substring that occurs at least three times.
 * A special substring is a substring that consists of only one unique character.
 *
 * Key Concepts:
 * - Special substring: A substring where all characters are the same (e.g., "aaa", "bbb")
 * - Must occur at least three times in the original string
 * - Looking for the maximum length among all valid special substrings
 *
 * Approach:
 * 1. Binary Search on the length of substring
 * 2. For each length, check if there exists a special substring of that length occurring thrice
 * 3. Use HashMap to count occurrences of each special substring
 *
 * Time Complexity: O(n * log n) where n is the length of string
 * Space Complexity: O(n) for storing substrings in HashMap
 *
 * Example 1:
 * Input: s = "aaaa"
 * Output: 2
 * Explanation: The longest special substring that occurs at least 3 times is "aa".
 * "aa" occurs 3 times: s[0:2], s[1:3], s[2:4]
 *
 * Example 2:
 * Input: s = "abcdef"
 * Output: -1
 * Explanation: There is no special substring that occurs at least 3 times.
 *
 * Example 3:
 * Input: s = "ccccc"
 * Output: 3
 * Explanation: The longest special substring that occurs at least 3 times is "ccc".
 */
import java.util.HashMap;

class Solution {

    public int maximumLength(String s) {
        int n = s.length();
        int left = 1, right = n, maxLength = -1;

        // Binary search on the length of the substring
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(s, mid)) {
                maxLength = mid; // Update maxLength if valid
                left = mid + 1;  // Try for a longer length
            } else {
                right = mid - 1; // Try for a shorter length
            }
        }

        return maxLength;
    }

    // Check if there's any special substring of length 'len' occurring at least 3 times
    private boolean isValid(String s, int len) {
        HashMap<String, Integer> substringCount = new HashMap<>();
        int n = s.length();

        for (int i = 0; i + len <= n; i++) {
            String sub = s.substring(i, i + len);

            // Check if the substring is special
            if (isSpecial(sub)) {
                substringCount.put(sub, substringCount.getOrDefault(sub, 0) + 1);
                if (substringCount.get(sub) >= 3) {
                    return true; // Found a valid special substring
                }
            }
        }

        return false;
    }

    // Helper method to check if a string is special (all characters are the same)
    private boolean isSpecial(String str) {
        char firstChar = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }
        return true;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with multiple occurrences
        assert solution.maximumLength("aaaa") == 2 : "Test case 1 failed";

        // Test Case 2: No special substring
        assert solution.maximumLength("abcdef") == -1 : "Test case 2 failed";

        // Test Case 3: All same characters
        assert solution.maximumLength("ccccc") == 3 : "Test case 3 failed";

        // Test Case 4: Mixed case with special substrings
        assert solution.maximumLength("aaabaaaa") == 2 : "Test case 4 failed";

        // Test Case 5: Minimum length case
        assert solution.maximumLength("aaa") == 1 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
