
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a solution to the "3Sum" problem, which finds all unique
 * triplets in an array that sum to zero.
 */
class Solution {

    /**
     * Finds all unique triplets in the given array that sum to zero.
     *
     * @param nums The input array of integers.
     * @return A list of lists, where each inner list represents a triplet that
     * sums to zero.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array to handle duplicates and for efficient two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    // Found a triplet that sums to zero
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicate elements for `left` and `right` to avoid duplicate triplets
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the threeSum method with test
     * cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Array with multiple triplets
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test case 1:");
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.threeSum(nums1));
        System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]");

        // Test case 2: Array with no triplets
        int[] nums2 = {0, 1, 1};
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.threeSum(nums2));
        System.out.println("Expected: []");

        // Test case 3: Array with all zeros
        int[] nums3 = {0, 0, 0};
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.threeSum(nums3));
        System.out.println("Expected: [[0, 0, 0]]");
    }
}
