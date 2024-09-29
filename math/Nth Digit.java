
/**
 * Solution class for finding the Nth digit of the sequence of decimal integers.
 */
class Solution {

    /**
     * Finds the Nth digit of the sequence of decimal integers.
     *
     * This method calculates the Nth digit in the sequence formed by
     * concatenating all positive integers: 1234567891011121314...
     *
     * The algorithm works as follows: 1. Determine the range of numbers where
     * the Nth digit falls. 2. Find the exact number containing the Nth digit.
     * 3. Extract the specific digit from that number.
     *
     * @param n The position of the digit to find (1-indexed).
     * @return The Nth digit in the sequence.
     */
    public int findNthDigit(int n) {
        int digitLength = 1;  // Length of numbers (1 for 1-digit numbers, 2 for 2-digit numbers, etc.)
        long count = 9;       // Count of digits contributed by the current range
        int start = 1;        // Starting number of the current range (1 for 1-digit, 10 for 2-digit, etc.)

        // Step 1: Find the range where the nth digit falls.
        while (n > digitLength * count) {
            n -= digitLength * count;  // Subtract the number of digits in this range
            digitLength++;             // Move to the next range of longer numbers
            count *= 10;               // The count of numbers increases by a factor of 10 for the next range
            start *= 10;               // Update the starting number of the next range
        }

        // Step 2: Find the exact number in this range.
        int num = start + (n - 1) / digitLength;  // (n-1) to convert to 0-based index

        // Step 3: Find the exact digit in the number.
        String numStr = Integer.toString(num);    // Convert the number to a string
        return numStr.charAt((n - 1) % digitLength) - '0';  // Extract the specific digit and return it
    }

    /**
     * Main method for testing the findNthDigit function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Test Case 1: n = 3");
        System.out.println("Expected: 3");
        System.out.println("Result: " + solution.findNthDigit(3));

        System.out.println("\nTest Case 2: n = 11");
        System.out.println("Expected: 0");
        System.out.println("Result: " + solution.findNthDigit(11));

        System.out.println("\nTest Case 3: n = 15");
        System.out.println("Expected: 2");
        System.out.println("Result: " + solution.findNthDigit(15));

        System.out.println("\nTest Case 4: n = 1000");
        System.out.println("Expected: 3");
        System.out.println("Result: " + solution.findNthDigit(1000));
    }
}
