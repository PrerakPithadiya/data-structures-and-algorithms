
import java.util.HashSet;

/**
 * Solution for LeetCode problem: Maximum Number of Integers to Choose From a
 * Range I
 *
 * Problem: Given an array of banned numbers, a range limit n, and a maximum sum
 * maxSum, find the maximum count of integers you can choose from the range [1,
 * n] such that: 1. The chosen numbers are not in the banned array 2. The sum of
 * the chosen numbers does not exceed maxSum
 *
 * Time Complexity: O(n), where n is the range limit Space Complexity: O(b),
 * where b is the length of banned array
 */
class Solution {

    /**
     * Finds the maximum count of integers that can be chosen within given
     * constraints.
     *
     * @param banned Array of banned numbers that cannot be chosen
     * @param n The upper limit of the range [1, n]
     * @param maxSum Maximum allowed sum of chosen numbers
     * @return Maximum count of integers that can be chosen
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a HashSet for quick lookup of banned numbers
        HashSet<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int currentSum = 0;
        int count = 0;

        // Loop through numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip the number if it is banned
            if (bannedSet.contains(i)) {
                continue;
            }

            // Check if adding the current number exceeds maxSum
            if (currentSum + i > maxSum) {
                break;
            }

            // Add the number to the current sum and increment count
            currentSum += i;
            count++;
        }

        return count;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.maxCount(new int[]{1, 6, 5}, 5, 6) == 2;  // [2,3,4], but can only choose [2,3]

        // Test Case 2: Empty banned array
        assert solution.maxCount(new int[]{}, 3, 10) == 3;  // Can choose [1,2,3]

        // Test Case 3: All numbers banned
        assert solution.maxCount(new int[]{1, 2, 3, 4, 5}, 5, 100) == 0;  // Cannot choose any number

        // Test Case 4: Small maxSum
        assert solution.maxCount(new int[]{1}, 10, 3) == 2;  // Can only choose [2]

        // Test Case 5: Large range with banned numbers
        assert solution.maxCount(new int[]{11, 12, 13, 14, 15}, 15, 10) == 4;  // Can choose [1,2,3,4]

        System.out.println("All test cases passed!");
    }
}
