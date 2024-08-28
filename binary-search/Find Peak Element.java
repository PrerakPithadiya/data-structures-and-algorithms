
/**
 * This class provides a solution to find a peak element in an array.
 * A peak element is an element that is strictly greater than its neighbors.
 */
class Solution {

    /**
     * Finds a peak element in the given array.
     *
     * @param nums The input array of integers
     * @return The index of a peak element
     */
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    /**
     * Performs a binary search to find a peak element in the array.
     *
     * @param nums The input array of integers
     * @param left The left boundary of the search range
     * @param right The right boundary of the search range
     * @return The index of a peak element
     */
    private int binarySearch(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        // Check if the mid element is a peak element
        if ((mid == 0 || nums[mid] > nums[mid - 1])
                && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
            return mid;
        }

        // Move to the side where the peak is more likely to be
        if (mid > 0 && nums[mid] < nums[mid - 1]) {
            return binarySearch(nums, left, mid - 1);
        } else {
            return binarySearch(nums, mid + 1, right);
        }
    }

    /**
     * Main method to run test cases for the findPeakElement method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Array with a peak in the middle
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Test case 1: " + solution.findPeakElement(nums1));

        // Test case 2: Array with multiple peaks
        int[] nums2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Test case 2: " + solution.findPeakElement(nums2));

        // Test case 3: Array with a single element
        int[] nums3 = {1};
        System.out.println("Test case 3: " + solution.findPeakElement(nums3));

        // Test case 4: Array with two elements
        int[] nums4 = {1, 2};
        System.out.println("Test case 4: " + solution.findPeakElement(nums4));

        // Test case 5: Array with descending order
        int[] nums5 = {3, 2, 1};
        System.out.println("Test case 5: " + solution.findPeakElement(nums5));
    }
}
