
/**
 * Solution class for the Maximum Swap problem.
 * This class provides a method to find the maximum number that can be formed
 * by swapping at most one pair of digits in a given integer.
 */
class Solution {

    /**
     * Finds the maximum number that can be formed by swapping at most one pair
     * of digits.
     *
     * @param num The input integer
     * @return The maximum number after at most one swap
     */
    public int maximumSwap(int num) {
        // Convert the number to a character array for easy manipulation
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        // Record the last position of each digit from 0 to 9
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        // Traverse the digits and look for the first opportunity to swap
        for (int i = 0; i < n; i++) {
            // Look for a larger digit to swap with the current one
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap digits[i] with digits[last[d]]
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;

                    // Return the resulting number after swapping
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // No swap needed, return the original number
        return num;
    }

    /**
     * Main method to run test cases for the maximumSwap method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: No swap needed
        int test1 = 9973;
        System.out.println("Test 1: Input = " + test1 + ", Output = " + solution.maximumSwap(test1));

        // Test case 2: Swap first and last digit
        int test2 = 2736;
        System.out.println("Test 2: Input = " + test2 + ", Output = " + solution.maximumSwap(test2));

        // Test case 3: Swap middle digits
        int test3 = 9973;
        System.out.println("Test 3: Input = " + test3 + ", Output = " + solution.maximumSwap(test3));

        // Test case 4: Single digit number
        int test4 = 5;
        System.out.println("Test 4: Input = " + test4 + ", Output = " + solution.maximumSwap(test4));

        // Test case 5: All digits are the same
        int test5 = 1111;
        System.out.println("Test 5: Input = " + test5 + ", Output = " + solution.maximumSwap(test5));
    }
}
