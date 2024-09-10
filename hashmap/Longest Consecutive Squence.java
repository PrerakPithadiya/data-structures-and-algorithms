
import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a solution to find the length of the longest consecutive
 * sequence in an array of integers.
 */
class Solution {

    /**
     * Finds the length of the longest consecutive sequence in the given array.
     *
     * @param nums An array of integers
     * @return The length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {
        // Check for null or empty input
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Add all numbers to a HashSet to allow O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through the numbers
        for (int num : numSet) {
            // Check if this number is the start of a sequence (num-1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Incrementally check for consecutive numbers in the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * Main method to demonstrate the usage of the longestConsecutive method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Example 1 output: " + solution.longestConsecutive(nums1));  // Output: 4

        // Example 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Example 2 output: " + solution.longestConsecutive(nums2));  // Output: 9
    }
}

/**
 * Design and Implementation:
 *
 * The solution uses a HashSet to store all numbers from the input array. This
 * allows for O(1) lookup time.
 *
 * The algorithm works as follows: 1. Add all numbers from the input array to a
 * HashSet. 2. Iterate through each number in the set. 3. For each number, check
 * if it's the start of a sequence by verifying if (num-1) is not in the set. 4.
 * If it's the start of a sequence, count the length of the sequence by
 * incrementally checking for the next consecutive number. 5. Update the longest
 * streak if the current sequence is longer.
 *
 * Time Complexity: O(n), where n is the number of elements in the input array.
 * Space Complexity: O(n) to store the numbers in the HashSet.
 *
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * longestConsecutive method with an integer array as the argument. 3. The
 * method will return the length of the longest consecutive sequence in the
 * array.
 *
 * Example: Solution solution = new Solution(); int[] nums = {100, 4, 200, 1, 3,
 * 2}; int result = solution.longestConsecutive(nums);
 * System.out.println(result); // Output: 4
 */
