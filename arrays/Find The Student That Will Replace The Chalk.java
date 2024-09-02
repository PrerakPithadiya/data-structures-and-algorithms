public class Solution {
    
    /**
     * Determines the index of the student who will need to replace the chalk.
     * 
     * @param chalk An array where chalk[i] indicates the amount of chalk student i needs.
     * @param k The initial number of pieces of chalk.
     * @return The index of the student who will need to replace the chalk.
     */
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalk = 0;

        // Compute the total chalk required for one complete cycle
        for (int c : chalk) {
            totalChalk += c;
        }

        // Find the remaining chalk after all possible complete cycles
        long remainingChalk = k % totalChalk;

        // Find the student who will run out of chalk
        for (int i = 0; i < n; i++) {
            remainingChalk -= chalk[i];
            if (remainingChalk < 0) {
                return i;
            }
        }

        return -1; // This line should never be reached if the problem constraints are met
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] chalk1 = {5, 1, 5};
        int k1 = 22;
        int result1 = solution.chalkReplacer(chalk1, k1);
        System.out.println("Test Case 1 Result: " + result1); // Expected: 0

        // Test Case 2
        int[] chalk2 = {3, 4, 1, 2};
        int k2 = 25;
        int result2 = solution.chalkReplacer(chalk2, k2);
        System.out.println("Test Case 2 Result: " + result2); // Expected: 1

        // Test Case 3
        int[] chalk3 = {1, 2, 3};
        int k3 = 6;
        int result3 = solution.chalkReplacer(chalk3, k3);
        System.out.println("Test Case 3 Result: " + result3); // Expected: 0

        // Test Case 4
        int[] chalk4 = {10, 20, 30, 40};
        int k4 = 100;
        int result4 = solution.chalkReplacer(chalk4, k4);
        System.out.println("Test Case 4 Result: " + result4); // Expected: 2
    }
}
