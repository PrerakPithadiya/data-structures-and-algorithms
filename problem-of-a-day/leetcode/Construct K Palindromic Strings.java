
/**
 * Solution for constructing K palindromic strings from a given string.
 *
 * Problem Description:
 * Given a string s and an integer k, determine if it's possible to construct exactly k palindromic strings
 * using all characters from s exactly once.
 *
 * Approach:
 * 1. First check if length of string is less than k (impossible case)
 * 2. Count frequency of each character in the string
 * 3. Count characters with odd frequencies
 * 4. Check if number of odd-frequency characters is <= k and total length >= k
 *
 * Time Complexity: O(n) where n is the length of string s Space Complexity:
 * O(1) as we use fixed size array of 26 characters
 */
class Solution {

    /**
     * Determines if it's possible to construct exactly k palindromic strings.
     *
     * @param s The input string containing lowercase English letters
     * @param k The number of palindromic strings to construct
     * @return true if it's possible to construct k palindromic strings, false
     * otherwise
     */
    public boolean canConstruct(String s, int k) {
        // If length is less than k, we can't form k strings
        if (s.length() < k) {
            return false;
        }

        // Count frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count characters with odd frequency
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Check if number of odd-frequency characters is <= k
        // and if total length >= k
        return oddCount <= k && s.length() >= k;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with possible construction
        assert solution.canConstruct("annabelle", 2) == true;

        // Test Case 2: Impossible case - string length less than k
        assert solution.canConstruct("abc", 4) == false;

        // Test Case 3: Edge case - k equals string length
        assert solution.canConstruct("leetcode", 8) == true;

        // Test Case 4: Single character case
        assert solution.canConstruct("a", 1) == true;

        // Test Case 5: All same characters
        assert solution.canConstruct("aaaa", 2) == true;

        System.out.println("All test cases passed!");
    }
}
