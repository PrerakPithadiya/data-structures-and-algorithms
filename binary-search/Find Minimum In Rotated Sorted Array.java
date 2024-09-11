
/**
 * Solution class for finding the minimum element in a rotated sorted array.
 */
class Solution {

    /**
     * Finds the minimum element in a rotated sorted array.
     *
     * This method uses a modified binary search algorithm to find the minimum
     * element in O(log n) time complexity.
     *
     * @param nums The input array of integers, which is sorted in ascending
     * order and then rotated at some pivot point.
     * @return The minimum element in the array.
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the right element,
            // the minimum is in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } // Otherwise, the minimum is in the left half or could be the mid itself.
            else {
                right = mid;
            }
        }

        // When left == right, we've found the minimum element.
        return nums[left];
    }

    /**
     * Main method to demonstrate the usage of the findMin method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Rotated array with minimum at index 3
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Example 1 output: " + solution.findMin(nums1));  // Output: 1

        // Example 2: Rotated array with minimum at index 4
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Example 2 output: " + solution.findMin(nums2));  // Output: 0

        // Example 3: Sorted array (not rotated)
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Example 3 output: " + solution.findMin(nums3));  // Output: 11
    }
}

/**
 * Usage Instructions: 1. Compile the Java file: javac Solution.java 2. Run the
 * compiled class: java Solution 3. The program will output the minimum element
 * for each example array.
 *
 * To use the findMin method in your own code: 1. Create an instance of the
 * Solution class. 2. Call the findMin method with your rotated sorted array as
 * the argument. 3. The method will return the minimum element in the array.
 *
 * Example: Solution solution = new Solution(); int[] myArray = {4, 5, 6, 7, 0,
 * 1, 2}; int minElement = solution.findMin(myArray);
 * System.out.println("Minimum element: " + minElement);
 */
