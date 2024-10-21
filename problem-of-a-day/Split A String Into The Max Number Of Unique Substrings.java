
import java.util.HashSet;

/**
 * Solution class for splitting a string into the maximum number of unique
 * substrings.
 */
class Solution {

    /**
     * Splits the input string into the maximum number of unique substrings.
     *
     * @param s The input string to be split.
     * @return The maximum number of unique substrings.
     */
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    /**
     * Helper function for backtracking to find the maximum number of unique
     * substrings.
     *
     * @param s The input string.
     * @param start The starting index for the current substring.
     * @param used A set to keep track of used substrings.
     * @return The maximum number of unique substrings for the current state.
     */
    private int backtrack(String s, int start, HashSet<String> used) {
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            // If this substring is not already used, consider it
            if (!used.contains(substring)) {
                used.add(substring); // Add the substring to the set
                maxSplits = Math.max(maxSplits, 1 + backtrack(s, end, used)); // Recur for the rest of the string
                used.remove(substring); // Backtrack and remove the substring
            }
        }

        return maxSplits;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "ababccc";
        System.out.println("Test case 1: " + s1);
        System.out.println("Expected output: 5");
        System.out.println("Actual output: " + solution.maxUniqueSplit(s1));
        System.out.println();

        // Test case 2
        String s2 = "aba";
        System.out.println("Test case 2: " + s2);
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + solution.maxUniqueSplit(s2));
        System.out.println();

        // Test case 3
        String s3 = "aa";
        System.out.println("Test case 3: " + s3);
        System.out.println("Expected output: 1");
        System.out.println("Actual output: " + solution.maxUniqueSplit(s3));
        System.out.println();

        // Test case 4
        String s4 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Test case 4: " + s4);
        System.out.println("Expected output: 26");
        System.out.println("Actual output: " + solution.maxUniqueSplit(s4));
    }
}
