package LeetCode;

/**
 * Solution for LeetCode problem: Rotate String Given two strings s and goal,
 * return true if and only if s can become goal after some number of shifts. A
 * shift on s consists of moving the leftmost character of s to the rightmost
 * position.
 */
class Solution {

    /**
     * Determines if one string can be rotated to form another string.
     *
     * @param s The source string
     * @param goal The target string to match through rotation
     * @return true if s can be rotated to form goal, false otherwise
     */
    public boolean rotateString(String s, String goal) {
        // Check if the lengths are different
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself
        String doubleS = s + s;

        // Check if goal is a substring of doubleS
        return doubleS.contains(goal);
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic rotation
        assert solution.rotateString("abcde", "cdeab") == true : "Test case 1 failed";

        // Test Case 2: No rotation possible
        assert solution.rotateString("abcde", "abced") == false : "Test case 2 failed";

        // Test Case 3: Empty strings
        assert solution.rotateString("", "") == true : "Test case 3 failed";

        // Test Case 4: Same strings
        assert solution.rotateString("hello", "hello") == true : "Test case 4 failed";

        // Test Case 5: Different lengths
        assert solution.rotateString("abc", "abcd") == false : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
