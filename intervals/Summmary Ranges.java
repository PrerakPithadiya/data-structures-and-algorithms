
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for summarizing ranges in an array of
 * integers. It includes a method to generate a list of strings representing the
 * ranges.
 */
class Solution {

    /**
     * Summarizes the ranges in the given array of integers.
     *
     * @param nums An array of integers to be summarized.
     * @return A list of strings representing the ranges in the input array.
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // If the current number is consecutive, just extend the range
                end = nums[i];
            } else {
                // If it's not consecutive, add the previous range to result
                addRange(result, start, end);
                // Reset the start and end to the current number
                start = nums[i];
                end = nums[i];
            }
        }

        // Add the last range
        addRange(result, start, end);

        return result;
    }

    /**
     * Helper method to add a range to the result list.
     *
     * @param result The list to which the range should be added.
     * @param start The start of the range.
     * @param end The end of the range.
     */
    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case with multiple ranges
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println("Test case 1: " + solution.summaryRanges(nums1));

        // Test case 2: Single number
        int[] nums2 = {1};
        System.out.println("Test case 2: " + solution.summaryRanges(nums2));

        // Test case 3: Empty array
        int[] nums3 = {};
        System.out.println("Test case 3: " + solution.summaryRanges(nums3));

        // Test case 4: Array with no ranges (all numbers are non-consecutive)
        int[] nums4 = {1, 3, 5, 7};
        System.out.println("Test case 4: " + solution.summaryRanges(nums4));

        // Test case 5: Array with negative numbers
        int[] nums5 = {-1, 0, 1, 2, 4, 5, 7};
        System.out.println("Test case 5: " + solution.summaryRanges(nums5));
    }
}
