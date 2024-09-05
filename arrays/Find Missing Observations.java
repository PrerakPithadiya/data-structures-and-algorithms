
import java.util.*;

/**
 * This class provides a solution for finding missing dice roll observations to
 * achieve a given mean across all rolls.
 */
class Solution {

    /**
     * Calculates the missing dice rolls to achieve a given mean.
     *
     * @param rolls An array of known dice roll results
     * @param mean The desired mean across all rolls (known and missing)
     * @param n The number of missing rolls to calculate
     * @return An array of the missing roll values, or an empty array if it's
     * impossible
     */
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        // Calculate the total required sum of n + m rolls
        int totalSum = mean * (n + m);

        // Calculate the sum of the known m rolls
        int knownSum = 0;
        for (int roll : rolls) {
            knownSum += roll;
        }

        // Calculate the sum of the missing n rolls
        int missingSum = totalSum - knownSum;

        // Check if the missing sum can be distributed among n rolls
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0];  // It's impossible to achieve the desired mean
        }

        // Distribute the missing sum across n rolls
        int[] result = new int[n];
        Arrays.fill(result, 1);  // Start by assigning 1 to each roll

        missingSum -= n;  // We have already assigned 1 to each roll

        // Distribute the remaining sum to each roll
        for (int i = 0; i < n; i++) {
            int add = Math.min(5, missingSum);  // Each roll can be increased by at most 5 (to make it 6)
            result[i] += add;
            missingSum -= add;
            if (missingSum == 0) {
                break;
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the missingRolls function.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;

        int[] result = solution.missingRolls(rolls, mean, n);

        System.out.println("Known rolls: " + Arrays.toString(rolls));
        System.out.println("Desired mean: " + mean);
        System.out.println("Number of missing rolls: " + n);
        System.out.println("Missing rolls: " + Arrays.toString(result));
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project provides a solution to find missing dice roll
 * observations given a set of known rolls, a desired mean, and the number of
 * missing rolls.
 *
 * 2. Class Structure: - Solution: The main class containing the algorithm and
 * example usage.
 *
 * 3. Key Methods: - missingRolls: Calculates the missing dice rolls. - main:
 * Demonstrates the usage of the missingRolls method.
 *
 * 4. Algorithm Explanation: The missingRolls method works as follows: a.
 * Calculate the total sum required to achieve the desired mean. b. Calculate
 * the sum of known rolls. c. Determine the sum needed for the missing rolls. d.
 * Check if it's possible to achieve the desired mean with valid dice rolls
 * (1-6). e. If possible, distribute the missing sum across n rolls, starting
 * with 1 for each roll and then adding the remaining sum evenly, ensuring no
 * roll exceeds 6.
 *
 * 5. Usage: To use this solution, create an instance of the Solution class and
 * call the missingRolls method with appropriate parameters. See the main method
 * for an example.
 *
 * 6. Limitations: - The solution assumes that dice rolls are integers between 1
 * and 6. - If it's impossible to achieve the desired mean, an empty array is
 * returned.
 *
 * 7. Future Improvements: - Add input validation to ensure all parameters are
 * within expected ranges. - Implement error handling for edge cases. - Optimize
 * the algorithm for larger datasets if needed.
 */
