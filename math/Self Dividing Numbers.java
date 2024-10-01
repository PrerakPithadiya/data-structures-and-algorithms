
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for finding self-dividing numbers within a
 * given range. A self-dividing number is a number that is divisible by all of
 * its digits.
 */
class Solution {

    /**
     * Finds all self-dividing numbers within the given range (inclusive).
     *
     * @param left The lower bound of the range (inclusive)
     * @param right The upper bound of the range (inclusive)
     * @return A list of all self-dividing numbers within the given range
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }

        return result;
    }

    /**
     * Checks if a number is self-dividing.
     *
     * @param num The number to check
     * @return true if the number is self-dividing, false otherwise
     */
    private boolean isSelfDividing(int num) {
        int originalNum = num;

        while (num > 0) {
            int digit = num % 10;
            // Check if the digit is 0 or if it does not divide the original number
            if (digit == 0 || originalNum % digit != 0) {
                return false;
            }
            num /= 10; // Remove the last digit
        }

        return true; // It is a self-dividing number
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        List<Integer> result1 = solution.selfDividingNumbers(1, 22);
        System.out.println("Test case 1 (1 to 22): " + result1);
        // Expected output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

        // Test case 2
        List<Integer> result2 = solution.selfDividingNumbers(47, 85);
        System.out.println("Test case 2 (47 to 85): " + result2);
        // Expected output: [48, 55, 66, 77]

        // Test case 3
        List<Integer> result3 = solution.selfDividingNumbers(100, 150);
        System.out.println("Test case 3 (100 to 150): " + result3);
        // Expected output: [111, 112, 115, 122, 124, 126, 128, 132, 135, 144]
    }
}
