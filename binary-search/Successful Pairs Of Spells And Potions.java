
import java.util.Arrays;

/**
 * This class contains a solution for finding successful pairs of spells and
 * potions.
 */
class Solution {

    /**
     * Finds the number of successful pairs of spells and potions.
     *
     * @param spells An array of integers representing the strength of each
     * spell.
     * @param potions An array of integers representing the strength of each
     * potion.
     * @param success A long value representing the minimum product of spell and
     * potion strengths for a successful pair.
     * @return An array of integers where each element represents the number of
     * successful pairs for the corresponding spell.
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        // Sort the potions array for binary search
        Arrays.sort(potions);

        // Process each spell
        for (int i = 0; i < n; i++) {
            long spell = spells[i];

            // Find the smallest index where spell * potion >= success using binary search
            int low = 0;
            int high = m;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (spell * potions[mid] >= success) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            // Count the number of successful pairs
            result[i] = m - low;
        }

        return result;
    }

    /**
     * Main method to run test cases for the successfulPairs method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] spells1 = {5, 1, 3};
        int[] potions1 = {1, 2, 3, 4, 5};
        long success1 = 7;
        int[] result1 = solution.successfulPairs(spells1, potions1, success1);
        System.out.println("Test case 1: " + Arrays.toString(result1));

        // Test case 2
        int[] spells2 = {3, 1, 2};
        int[] potions2 = {8, 5, 8};
        long success2 = 16;
        int[] result2 = solution.successfulPairs(spells2, potions2, success2);
        System.out.println("Test case 2: " + Arrays.toString(result2));

        // Test case 3
        int[] spells3 = {1, 2, 3, 4, 5};
        int[] potions3 = {1, 2, 3, 4, 5};
        long success3 = 10;
        int[] result3 = solution.successfulPairs(spells3, potions3, success3);
        System.out.println("Test case 3: " + Arrays.toString(result3));
    }
}
