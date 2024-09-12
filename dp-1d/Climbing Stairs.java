
/**
 * Solution class for the "Climbing Stairs" problem.
 * This class provides a method to calculate the number of distinct ways to climb n stairs,
 * where each step can be either 1 or 2 stairs at a time.
 */
class Solution {

    /**
     * Calculates the number of distinct ways to climb n stairs.
     *
     * @param n The number of stairs to climb (1 <= n <= 45)
     * @return The number of distinct ways to climb n stairs
     *
     * Time Complexity: O(n), where n is the number of stairs Space Complexity:
     * O(1), as we only use a constant amount of extra space
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;  // Represents dp[0], the number of ways to climb 0 stairs
        int second = 1; // Represents dp[1], the number of ways to climb 1 stair

        // Iterate from 2 to n, calculating the number of ways for each step
        for (int i = 2; i <= n; i++) {
            int current = first + second; // dp[i] = dp[i-1] + dp[i-2]
            first = second;
            second = current;
        }

        return second;  // The number of ways to reach the nth step
    }

    /**
     * Main method to run test cases for the climbStairs method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int n1 = 2;
        int expected1 = 2;
        int result1 = solution.climbStairs(n1);
        System.out.println("Test case 1: n = " + n1);
        System.out.println("Expected: " + expected1 + ", Got: " + result1);
        System.out.println("Result: " + (result1 == expected1 ? "PASS" : "FAIL"));

        // Test case 2
        int n2 = 3;
        int expected2 = 3;
        int result2 = solution.climbStairs(n2);
        System.out.println("\nTest case 2: n = " + n2);
        System.out.println("Expected: " + expected2 + ", Got: " + result2);
        System.out.println("Result: " + (result2 == expected2 ? "PASS" : "FAIL"));

        // Test case 3
        int n3 = 5;
        int expected3 = 8;
        int result3 = solution.climbStairs(n3);
        System.out.println("\nTest case 3: n = " + n3);
        System.out.println("Expected: " + expected3 + ", Got: " + result3);
        System.out.println("Result: " + (result3 == expected3 ? "PASS" : "FAIL"));
    }
}
