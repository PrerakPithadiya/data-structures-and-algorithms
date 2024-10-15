package greedy;

import java.util.Arrays;

/**
 * This class provides a solution for creating the maximum number from two
 * arrays.
 */
class Solution {

    /**
     * Creates the maximum number of length k from two given arrays.
     *
     * @param nums1 The first input array
     * @param nums2 The second input array
     * @param k The length of the desired maximum number
     * @return An array representing the maximum number
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] best = new int[k];

        // Try all splits of k: i digits from nums1 and k-i digits from nums2
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] candidate = merge(maxSubsequence(nums1, i), maxSubsequence(nums2, k - i));
            if (greater(candidate, 0, best, 0)) {
                best = candidate;
            }
        }

        return best;
    }

    /**
     * Gets the maximum subsequence of length k from the given array.
     *
     * @param nums The input array
     * @param k The length of the desired subsequence
     * @return The maximum subsequence of length k
     */
    private int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] subsequence = new int[k];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // Ensure the subsequence we are building is lexicographically largest
            while (idx > 0 && subsequence[idx - 1] < nums[i] && n - i + idx > k) {
                idx--;
            }
            if (idx < k) {
                subsequence[idx++] = nums[i];
            }
        }
        return subsequence;
    }

    /**
     * Merges two subsequences into the largest possible number.
     *
     * @param nums1 The first subsequence
     * @param nums2 The second subsequence
     * @return The merged array representing the largest possible number
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m || j < n) {
            if (greater(nums1, i, nums2, j)) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        return merged;
    }

    /**
     * Compares two subsequences to decide which one is larger.
     *
     * @param nums1 The first subsequence
     * @param i The starting index for the first subsequence
     * @param nums2 The second subsequence
     * @param j The starting index for the second subsequence
     * @return true if the first subsequence is greater, false otherwise
     */
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        int m = nums1.length, n = nums2.length;
        while (i < m && j < n && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == n || (i < m && nums1[i] > nums2[j]);
    }

    /**
     * Test cases for the maxNumber method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] result1 = solution.maxNumber(nums1, nums2, k);
        System.out.println("Test case 1: " + Arrays.toString(result1));
        // Expected output: [9, 8, 6, 5, 3]

        // Test case 2
        int[] nums3 = {6, 7};
        int[] nums4 = {6, 0, 4};
        int k2 = 5;
        int[] result2 = solution.maxNumber(nums3, nums4, k2);
        System.out.println("Test case 2: " + Arrays.toString(result2));
        // Expected output: [6, 7, 6, 0, 4]

        // Test case 3
        int[] nums5 = {3, 9};
        int[] nums6 = {8, 9};
        int k3 = 3;
        int[] result3 = solution.maxNumber(nums5, nums6, k3);
        System.out.println("Test case 3: " + Arrays.toString(result3));
        // Expected output: [9, 8, 9]
    }
}
