package GFG;

/**
 * Solution class containing method to find second largest element in an array
 */
class Solution {

    /**
     * Finds the second largest element in the given array
     *
     * @param arr Input array of integers
     * @return Second largest element in the array, or -1 if it doesn't exist
     */
    public int getSecondLargest(int[] arr) {
        // Initialize the largest and second largest to minimum possible values
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Iterate through the array
        for (int num : arr) {
            // Update largest and second largest accordingly
            if (num > largest) {
                secondLargest = largest; // Update second largest before largest
                largest = num; // Update largest
            } else if (num > secondLargest && num < largest) {
                secondLargest = num; // Update second largest if num is between largest and second largest
            }
        }

        // If second largest is still Integer.MIN_VALUE, it means it doesn't exist
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    /**
     * Test cases to verify the functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal array with distinct elements
        int[] arr1 = {12, 35, 1, 10, 34, 1};
        System.out.println("Test Case 1: " + solution.getSecondLargest(arr1)); // Expected: 34

        // Test Case 2: Array with all same elements
        int[] arr2 = {5, 5, 5, 5};
        System.out.println("Test Case 2: " + solution.getSecondLargest(arr2)); // Expected: -1

        // Test Case 3: Empty array
        int[] arr3 = {};
        System.out.println("Test Case 3: " + solution.getSecondLargest(arr3)); // Expected: -1

        // Test Case 4: Array with two elements
        int[] arr4 = {10, 5};
        System.out.println("Test Case 4: " + solution.getSecondLargest(arr4)); // Expected: 5

        // Test Case 5: Array with negative numbers
        int[] arr5 = {-1, -2, -3, -4, -5};
        System.out.println("Test Case 5: " + solution.getSecondLargest(arr5)); // Expected: -2
    }
}
