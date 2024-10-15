
/**
 * Solution class for separating black and white balls.
 */
class Solution {

    /**
     * Calculates the minimum number of steps required to separate black and
     * white balls.
     *
     * @param s A string representing the arrangement of balls, where '0'
     * represents a white ball and '1' represents a black ball.
     * @return The minimum number of steps (swaps) required to separate the
     * balls.
     */
    public long minimumSteps(String s) {
        long swap = 0;
        int black = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                swap += (long) black;
            } else {
                black++;
            }
        }
        return swap;
    }

    /**
     * Test cases for the minimumSteps method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: All white balls
        assert solution.minimumSteps("000") == 0 : "Test case 1 failed";

        // Test case 2: All black balls
        assert solution.minimumSteps("111") == 0 : "Test case 2 failed";

        // Test case 3: Alternating balls
        assert solution.minimumSteps("101010") == 3 : "Test case 3 failed";

        // Test case 4: Black balls first
        assert solution.minimumSteps("11100") == 0 : "Test case 4 failed";

        // Test case 5: White balls first
        assert solution.minimumSteps("00011") == 6 : "Test case 5 failed";

        // Test case 6: Mixed arrangement
        assert solution.minimumSteps("10101110001") == 11 : "Test case 6 failed";

        System.out.println("All test cases passed!");
    }
}
