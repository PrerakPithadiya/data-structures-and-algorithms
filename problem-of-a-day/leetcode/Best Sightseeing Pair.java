
/**
 * Solution for LeetCode Problem: Best Sightseeing Pair
 *
 * Problem Description:
 * You are given an array values where values[i] represents the value of the ith sightseeing spot.
 * Two sightseeing spots i and j have a score = values[i] + values[j] + i - j where i < j.
 * Return the maximum score of any valid pair of sightseeing spots.
 *
 * Approach:
 * 1. Use dynamic programming to keep track of maximum value of (values[i] + i) for previous elements
 * 2. For each position j, calculate score using current j and best previous i
 * 3. Update maximum value of (values[i] + i) for next iteration
 *
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the maximum score possible from any pair of sightseeing spots.
     *
     * @param values array containing values of sightseeing spots
     * @return maximum possible score from any valid pair
     */
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxValuePlusI = values[0] + 0; // values[i] + i

        for (int j = 1; j < values.length; j++) {
            // Calculate score using current j and best previous i
            maxScore = Math.max(maxScore, maxValuePlusI + values[j] - j);

            // Update max value of values[i] + i
            maxValuePlusI = Math.max(maxValuePlusI, values[j] + j);
        }

        return maxScore;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example from LeetCode
        int[] test1 = {8, 1, 5, 2, 6};
        assert solution.maxScoreSightseeingPair(test1) == 11 : "Test Case 1 Failed";

        // Test Case 2: Decreasing sequence
        int[] test2 = {5, 4, 3, 2, 1};
        assert solution.maxScoreSightseeingPair(test2) == 7 : "Test Case 2 Failed";

        // Test Case 3: Increasing sequence
        int[] test3 = {1, 2, 3, 4, 5};
        assert solution.maxScoreSightseeingPair(test3) == 8 : "Test Case 3 Failed";

        // Test Case 4: Minimum length array
        int[] test4 = {1, 2};
        assert solution.maxScoreSightseeingPair(test4) == 2 : "Test Case 4 Failed";

        // Test Case 5: Array with same values
        int[] test5 = {5, 5, 5, 5, 5};
        assert solution.maxScoreSightseeingPair(test5) == 9 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
