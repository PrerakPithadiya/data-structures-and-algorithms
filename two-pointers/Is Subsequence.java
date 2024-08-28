
/**
 * This class provides a solution to the "Is Subsequence" problem.
 * It determines whether a string 's' is a subsequence of another string 't'.
 */
class Solution {

    /**
     * Determines if string 's' is a subsequence of string 't'.
     *
     * @param s The potential subsequence string.
     * @param t The main string to check against.
     * @return true if 's' is a subsequence of 't', false otherwise.
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * Main method to run test cases for the isSubsequence method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic positive case
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println("Test case 1: " + solution.isSubsequence(s1, t1));  // Expected: true

        // Test case 2: Basic negative case
        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println("Test case 2: " + solution.isSubsequence(s2, t2));  // Expected: false

        // Test case 3: Empty subsequence
        String s3 = "";
        String t3 = "ahbgdc";
        System.out.println("Test case 3: " + solution.isSubsequence(s3, t3));  // Expected: true

        // Test case 4: Empty main string
        String s4 = "abc";
        String t4 = "";
        System.out.println("Test case 4: " + solution.isSubsequence(s4, t4));  // Expected: false
    }
}
