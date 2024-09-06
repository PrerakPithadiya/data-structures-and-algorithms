
/**
 * This class provides a solution for calculating the square root of a non-negative integer.
 * It uses the binary search algorithm to efficiently find the integer square root.
 */
class Solution {

    /**
     * Calculates the integer square root of a given non-negative number.
     *
     * @param x The non-negative integer for which to calculate the square root.
     * @return The integer square root of x. If x is not a perfect square, it
     * returns the floor of the square root.
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1, right = x, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // To prevent overflow, we compare mid * mid with x
            if (mid <= x / mid) {
                result = mid;  // mid could be the potential answer
                left = mid + 1;  // move to the right half
            } else {
                right = mid - 1;  // move to the left half
            }
        }

        return result;
    }

    /**
     * Main method to run test cases for the mySqrt method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {0, 1, 4, 8, 9, 16, 25, 26, 100, 2147395600};

        for (int testCase : testCases) {
            int result = solution.mySqrt(testCase);
            System.out.println("Square root of " + testCase + " is: " + result);
        }
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project implements an efficient algorithm to calculate the
 * integer square root of a non-negative number using the binary search
 * approach.
 *
 * 2. Class Structure: - Solution: Contains the main logic for square root
 * calculation. - mySqrt(int x): Method to calculate the square root. -
 * main(String[] args): Method to run test cases.
 *
 * 3. Algorithm: The mySqrt method uses binary search to find the square root: -
 * It initializes the search range from 1 to x. - In each iteration, it
 * calculates the middle value and compares its square with x. - The search
 * range is adjusted based on this comparison. - The process continues until the
 * exact square root or its floor value is found.
 *
 * 4. Time Complexity: O(log n), where n is the input number.
 *
 * 5. Space Complexity: O(1), as it uses only a constant amount of extra space.
 *
 * 6. Limitations: - The method returns only the integer part of the square
 * root. - For very large inputs close to Integer.MAX_VALUE, there might be
 * precision issues.
 *
 * 7. Future Improvements: - Implement a version that returns a double for more
 * precise results. - Add error handling for negative inputs. - Optimize for
 * even faster computation for very large numbers.
 */
