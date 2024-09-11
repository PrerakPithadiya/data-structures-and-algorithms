
/**
 * This class provides a solution to find the median of two sorted arrays.
 * The algorithm uses a binary search approach to efficiently find the median
 * with a time complexity of O(log(min(m,n))), where m and n are the lengths of the input arrays.
 */
class Solution {

    /**
     * Finds the median of two sorted arrays.
     *
     * @param nums1 The first sorted array
     * @param nums2 The second sorted array
     * @return The median of the two sorted arrays
     * @throws IllegalArgumentException if the input arrays are not sorted or
     * valid
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                // i is too small, increase it
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i is too big, decrease it
                imax = i - 1;
            } else {
                // i is perfect, calculate the median
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                // If the total length is odd, return the max of the left side
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                // If the total length is even, calculate the average of max left and min right
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or valid.");
    }

    /**
     * Main method to demonstrate the usage of the findMedianSortedArrays
     * method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));  // Output: 2.0

        // Example 2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));  // Output: 2.5
    }
}
