
/**
 * LeetCode Problem: Take Gifts From the Richest Pile
 *
 * Problem Description:
 * You are given an integer array gifts denoting the number of gifts in various piles.
 * Every second, you do the following:
 * 1. Choose the pile with the maximum number of gifts
 * 2. Take the square root of the number of gifts in that pile
 * 3. Floor the result and replace the original pile with that number
 * This process repeats for exactly k seconds.
 * Return the total number of gifts remaining after k seconds.
 *
 * Solution Approach:
 * 1. Sort the array to easily access maximum pile
 * 2. For k iterations:
 *    - Take the last element (maximum)
 *    - Replace it with floor(sqrt(max))
 *    - Use binary search to find correct position for new value
 *    - Shift elements and maintain sorted order
 * 3. Sum up remaining gifts and return total
 *
 * Time Complexity: O(k * n log n) where n is the length of gifts array
 * Space Complexity: O(1) as we modify the array in-place
 */
import java.util.Arrays;

class Solution {

    /**
     * Processes the gifts array for k seconds and returns the total remaining
     * gifts.
     *
     * @param gifts Integer array representing number of gifts in each pile
     * @param k Number of seconds to process
     * @return Total number of gifts remaining after k seconds
     */
    public long pickGifts(int[] gifts, int k) {
        // Sort the array to start with
        Arrays.sort(gifts);

        while (k-- > 0) {
            // Get the largest pile (last element in sorted array)
            int maxPile = gifts[gifts.length - 1];

            // Replace the largest pile with floor(sqrt(maxPile))
            int reducedPile = (int) Math.floor(Math.sqrt(maxPile));
            gifts[gifts.length - 1] = reducedPile;

            // Re-sort the last element back into the array (O(log n) with binary search)
            int pos = Arrays.binarySearch(gifts, 0, gifts.length - 1, reducedPile);
            if (pos < 0) {
                pos = -pos - 1;
            }

            // Shift elements and insert the reducedPile at the correct position
            System.arraycopy(gifts, pos, gifts, pos + 1, gifts.length - 1 - pos);
            gifts[pos] = reducedPile;
        }

        // Calculate the total sum of remaining gifts
        long total = 0;
        for (int gift : gifts) {
            total += gift;
        }
        return total;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] gifts1 = {25, 64, 9, 4, 100};
        int k1 = 4;
        System.out.println("Test Case 1: " + solution.pickGifts(gifts1, k1)); // Expected: 29

        // Test Case 2: Single element
        int[] gifts2 = {1};
        int k2 = 1;
        System.out.println("Test Case 2: " + solution.pickGifts(gifts2, k2)); // Expected: 1

        // Test Case 3: All same elements
        int[] gifts3 = {16, 16, 16, 16};
        int k3 = 2;
        System.out.println("Test Case 3: " + solution.pickGifts(gifts3, k3)); // Expected: 56

        // Test Case 4: k = 0
        int[] gifts4 = {10, 20, 30};
        int k4 = 0;
        System.out.println("Test Case 4: " + solution.pickGifts(gifts4, k4)); // Expected: 60

        // Test Case 5: Large numbers
        int[] gifts5 = {1000000, 1000000};
        int k5 = 1;
        System.out.println("Test Case 5: " + solution.pickGifts(gifts5, k5)); // Expected: 1001000
    }
}
