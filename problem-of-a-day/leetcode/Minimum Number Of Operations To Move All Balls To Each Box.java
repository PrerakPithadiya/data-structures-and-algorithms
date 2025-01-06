
/**
 * Solution for LeetCode problem: Minimum Number of Operations to Move All Balls to Each Box
 *
 * Problem Description:
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty,
 * and '1' if it contains one ball. In one operation, you can move one ball from a box to an adjacent box.
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Approach:
 * 1. Use two passes through the array to calculate total operations:
 *    - First pass (left to right): Count operations needed to move balls from left side
 *    - Second pass (right to left): Count operations needed to move balls from right side
 * 2. For each position, sum both left and right operations to get total minimum operations
 *
 * Time Complexity: O(n) where n is the length of the input string
 * Space Complexity: O(1) excluding the output array
 */
class Solution {

    /**
     * Calculates minimum operations needed to move all balls to each box.
     *
     * @param boxes Binary string representing boxes with/without balls
     * @return Array where each element represents minimum operations for that
     * position
     */
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Count moves from left to right
        int ballsOnLeft = 0;
        int runningCost = 0;

        for (int i = 0; i < n; i++) {
            answer[i] = runningCost;
            if (boxes.charAt(i) == '1') {
                ballsOnLeft++;
            }
            runningCost += ballsOnLeft; // Cost increases by number of balls on left
        }

        // Count moves from right to left
        int ballsOnRight = 0;
        runningCost = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] += runningCost;
            if (boxes.charAt(i) == '1') {
                ballsOnRight++;
            }
            runningCost += ballsOnRight; // Cost increases by number of balls on right
        }

        return answer;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with alternating balls
        String test1 = "110";
        int[] result1 = solution.minOperations(test1);
        assert result1[0] == 1 : "Test case 1 failed for index 0";
        assert result1[1] == 1 : "Test case 1 failed for index 1";
        assert result1[2] == 3 : "Test case 1 failed for index 2";

        // Test Case 2: All boxes have balls
        String test2 = "111";
        int[] result2 = solution.minOperations(test2);
        assert result2[0] == 2 : "Test case 2 failed for index 0";
        assert result2[1] == 1 : "Test case 2 failed for index 1";
        assert result2[2] == 2 : "Test case 2 failed for index 2";

        // Test Case 3: Only one ball
        String test3 = "100";
        int[] result3 = solution.minOperations(test3);
        assert result3[0] == 0 : "Test case 3 failed for index 0";
        assert result3[1] == 1 : "Test case 3 failed for index 1";
        assert result3[2] == 2 : "Test case 3 failed for index 2";

        System.out.println("All test cases passed!");
    }
}
