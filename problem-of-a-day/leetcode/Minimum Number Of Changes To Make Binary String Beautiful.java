package LeetCode;

/**
 * Solution for making a binary string beautiful A binary string is considered
 * beautiful if and only if every pair of adjacent characters are equal
 */
class Solution {

    /**
     * Calculates minimum number of changes needed to make a binary string
     * beautiful
     *
     * @param s Input binary string consisting of characters '0' and '1'
     * @return Minimum number of character changes required
     */
    public int minChanges(String s) {
        int n = s.length();
        int countChanges = 0;

        // Iterate through the string in steps of 2
        for (int i = 0; i < n; i += 2) {
            // Check each pair of characters
            if (s.charAt(i) != s.charAt(i + 1)) {
                // If the characters are different, we need one change to make them the same
                countChanges++;
            }
        }

        return countChanges;
    }

    /**
     * Test cases to verify the solution
     */
    public void testCases() {
        // Test case 1: Already beautiful string
        assert minChanges("00") == 0 : "Test case 1 failed";

        // Test case 2: One change needed
        assert minChanges("10") == 1 : "Test case 2 failed";

        // Test case 3: Multiple changes needed
        assert minChanges("1010") == 2 : "Test case 3 failed";

        // Test case 4: No changes needed for longer string
        assert minChanges("0000") == 0 : "Test case 4 failed";

        // Test case 5: Alternating pattern
        assert minChanges("01010101") == 4 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
