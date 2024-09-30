
/**
 * Solution class for checking perfect numbers.
 * A perfect number is a positive integer that is equal to the sum of its proper positive divisors.
 */
class Solution {

    /**
     * Checks if a given number is a perfect number.
     *
     * @param num The number to check
     * @return true if the number is perfect, false otherwise
     */
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1; // 1 is always a divisor
        int sqrt = (int) Math.sqrt(num);

        // Check divisors from 2 to sqrt(num)
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        // Return true if sum of divisors equals the number itself
        return sum == num;
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {6, 28, 496, 8128, 33550336, 12, 18, 21, 1, 0, -6};

        for (int num : testCases) {
            boolean result = solution.checkPerfectNumber(num);
            System.out.println("Is " + num + " a perfect number? " + result);
        }
    }
}
