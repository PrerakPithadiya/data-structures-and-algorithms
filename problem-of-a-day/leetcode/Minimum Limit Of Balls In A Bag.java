
/**
 * Solution for LeetCode problem: Minimum Limit of Balls in a Bag
 *
 * Problem Description:
 * You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
 * You can perform the following operation at most maxOperations times:
 * - Take any bag of balls and divide it into two new bags with a positive number of balls.
 * Your penalty is the maximum number of balls in a bag after the operations.
 * Return the minimum possible penalty after performing the operations.
 *
 * Time Complexity: O(n * log M) where n is length of nums and M is maximum value in nums
 * Space Complexity: O(1)
 */
class Solution {

    /**
     * Finds the minimum possible maximum number of balls in any bag after
     * operations
     *
     * @param nums Array representing number of balls in each bag
     * @param maxOperations Maximum number of splitting operations allowed
     * @return Minimum possible maximum number of balls in any bag
     */
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAchievePenalty(nums, maxOperations, mid)) {
                result = mid;
                right = mid - 1; // Try for a smaller penalty
            } else {
                left = mid + 1; // Increase the penalty
            }
        }

        return result;
    }

    /**
     * Checks if it's possible to achieve the given penalty with allowed
     * operations
     *
     * @param nums Array representing number of balls in each bag
     * @param maxOperations Maximum number of splitting operations allowed
     * @param penalty Target maximum number of balls in any bag
     * @return true if penalty is achievable, false otherwise
     */
    private boolean canAchievePenalty(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int balls : nums) {
            if (balls > penalty) {
                // Calculate how many splits are needed to make all bags <= penalty
                operations += (balls - 1) / penalty; // Integer division
            }

            // If operations exceed maxOperations, the penalty is not feasible
            if (operations > maxOperations) {
                return false;
            }
        }

        return true;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        assert solution.minimumSize(new int[]{9}, 2) == 3;

        // Test Case 2
        assert solution.minimumSize(new int[]{2, 4, 8, 2}, 4) == 2;

        // Test Case 3
        assert solution.minimumSize(new int[]{7, 17}, 2) == 7;

        // Test Case 4
        assert solution.minimumSize(new int[]{1}, 1) == 1;

        // Test Case 5
        assert solution.minimumSize(new int[]{1000000000}, 1000000000) == 1;

        System.out.println("All test cases passed!");
    }
}
