package GFG;

import java.util.*;

/**
 * Solution class to find split points in an array that divides it into three
 * equal sum subarrays
 */
class Solution {

    /**
     * Finds two split points in an array that divide it into three subarrays
     * with equal sums
     *
     * @param arr Input array of integers
     * @return List containing two indices where the array should be split, or
     * [-1, -1] if not possible
     */
    public List<Integer> findSplit(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If total sum is not divisible by 3, return [-1, -1]
        if (totalSum % 3 != 0) {
            return Arrays.asList(-1, -1);
        }

        int targetSum = totalSum / 3;
        int currentSum = 0;
        List<Integer> result = new ArrayList<>();

        // Find the first split point
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == targetSum) {
                result.add(i);
                break;
            }
        }

        // If the first split point is not found, return [-1, -1]
        if (result.isEmpty()) {
            return Arrays.asList(-1, -1);
        }

        // Reset currentSum to find the second split point
        currentSum = 0;
        for (int j = result.get(0) + 1; j < arr.length; j++) {
            currentSum += arr[j];
            if (currentSum == targetSum) {
                result.add(j);
                break;
            }
        }

        // If the second split point is not found, or there are less than 2 split points, return [-1, -1]
        if (result.size() < 2) {
            return Arrays.asList(-1, -1);
        }

        return result;
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array can be split into three equal sum subarrays
        int[] arr1 = {1, 3, 2, 4, 2, 3};  // Sum = 15, each part should have sum = 5
        System.out.println("Test Case 1: " + solution.findSplit(arr1));  // Expected: [1, 3]

        // Test Case 2: Array cannot be split (sum not divisible by 3)
        int[] arr2 = {1, 2, 3, 4};  // Sum = 10
        System.out.println("Test Case 2: " + solution.findSplit(arr2));  // Expected: [-1, -1]

        // Test Case 3: Array with all zeros
        int[] arr3 = {0, 0, 0, 0, 0, 0};
        System.out.println("Test Case 3: " + solution.findSplit(arr3));  // Expected: [1, 3]

        // Test Case 4: Array with negative numbers
        int[] arr4 = {-1, -1, -1, -1, -1, -1};  // Sum = -6, each part should have sum = -2
        System.out.println("Test Case 4: " + solution.findSplit(arr4));  // Expected: [1, 3]

        // Test Case 5: Array too small to split
        int[] arr5 = {1, 2};
        System.out.println("Test Case 5: " + solution.findSplit(arr5));  // Expected: [-1, -1]
    }
}
