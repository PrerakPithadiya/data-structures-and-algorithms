
import java.util.*;

/**
 * Solution class for finding the length of the Longest Increasing Subsequence
 * (LIS).
 */
class Solution {

    /**
     * Finds the length of the Longest Increasing Subsequence in the given
     * array.
     *
     * This method uses a dynamic programming approach with binary search to
     * efficiently compute the length of the LIS. It maintains a list 'sub' that
     * represents the smallest tail of all increasing subsequences of a given
     * length.
     *
     * Time Complexity: O(n log n), where n is the length of the input array.
     * Space Complexity: O(n) in the worst case.
     *
     * @param nums The input array of integers.
     * @return The length of the Longest Increasing Subsequence.
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            if (sub.isEmpty() || num > sub.get(sub.size() - 1)) {
                sub.add(num); // Append to the list if num is greater than the last element
            } else {
                // Binary search to find the position to replace
                int idx = Collections.binarySearch(sub, num);
                if (idx < 0) {
                    idx = -(idx + 1); // Get the correct insertion point if num is not found
                }
                sub.set(idx, num); // Replace the element at index idx
            }
        }

        return sub.size(); // The size of the list is the length of the LIS
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic increasing sequence
        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Test case 1: " + solution.lengthOfLIS(nums1)); // Expected output: 4

        // Test case 2: All elements are the same
        int[] nums2 = {7, 7, 7, 7, 7, 7, 7};
        System.out.println("Test case 2: " + solution.lengthOfLIS(nums2)); // Expected output: 1

        // Test case 3: Decreasing sequence
        int[] nums3 = {4, 3, 2, 1};
        System.out.println("Test case 3: " + solution.lengthOfLIS(nums3)); // Expected output: 1

        // Test case 4: Empty array
        int[] nums4 = {};
        System.out.println("Test case 4: " + solution.lengthOfLIS(nums4)); // Expected output: 0

        // Test case 5: Long sequence with multiple increasing subsequences
        int[] nums5 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println("Test case 5: " + solution.lengthOfLIS(nums5)); // Expected output: 6
    }
}
