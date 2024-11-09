
import java.util.Arrays;

/**
 * Solution class to find the minimum sum of two numbers formed from array
 * digits. The problem involves creating two numbers from the given array digits
 * such that their sum is minimum.
 */
class Solution {

    /**
     * Finds the minimum possible sum of two numbers that can be formed using
     * array digits.
     *
     * @param arr Input array of integers (digits)
     * @return String representation of the minimum sum
     */
    public String minSum(int[] arr) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);

        // Step 2: Use two StringBuilders to construct the two numbers as strings
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Step 3: Distribute digits alternately between num1 and num2 to minimize the sum
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        // Step 4: Manually add the two large numbers represented by num1 and num2 as strings
        return addStrings(num1.toString(), num2.toString());
    }

    /**
     * Helper method to add two numbers represented as strings.
     *
     * @param num1 First number as string
     * @param num2 Second number as string
     * @return Sum of the two numbers as string
     */
    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0, p1 = num1.length() - 1, p2 = num2.length() - 1;

        // Add digits from the end towards the beginning
        while (p1 >= 0 || p2 >= 0 || carry > 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int sum = x1 + x2 + carry;

            result.append(sum % 10);
            carry = sum / 10;

            p1--;
            p2--;
        }

        // The result is reversed, so reverse it back
        String finalResult = result.reverse().toString();

        // Remove any leading zeroes from the final result
        int nonZeroIndex = 0;
        while (nonZeroIndex < finalResult.length() && finalResult.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        return nonZeroIndex == finalResult.length() ? "0" : finalResult.substring(nonZeroIndex);
    }

    /**
     * Test cases for the minSum method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] arr1 = {6, 8, 4, 5, 2, 3};
        System.out.println("Test Case 1: " + solution.minSum(arr1)); // Expected: 604

        // Test Case 2: Array with zeros
        int[] arr2 = {0, 0, 0, 1};
        System.out.println("Test Case 2: " + solution.minSum(arr2)); // Expected: 1

        // Test Case 3: Single digit
        int[] arr3 = {5};
        System.out.println("Test Case 3: " + solution.minSum(arr3)); // Expected: 5

        // Test Case 4: All same digits
        int[] arr4 = {1, 1, 1, 1};
        System.out.println("Test Case 4: " + solution.minSum(arr4)); // Expected: 22

        // Test Case 5: Large numbers
        int[] arr5 = {9, 9, 9, 9, 9, 9};
        System.out.println("Test Case 5: " + solution.minSum(arr5)); // Expected: 999999
    }
}
