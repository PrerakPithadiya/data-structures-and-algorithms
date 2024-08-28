
/**
 * This class provides a solution to find the highest altitude reached during a journey.
 * The journey starts at altitude 0 and the altitude changes are given as an array of integers.
 */
class Solution {

    /**
     * Calculates the highest altitude reached during the journey.
     *
     * @param gain An array of integers representing the altitude changes
     * between points.
     * @return The highest altitude reached.
     */
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }

        return maxAltitude;
    }

    /**
     * Main method to run test cases for the largestAltitude method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Mixed positive and negative changes
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Test case 1: " + solution.largestAltitude(gain1)); // Expected output: 1

        // Test case 2: Mostly negative changes with a positive peak
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Test case 2: " + solution.largestAltitude(gain2)); // Expected output: 0

        // Test case 3: All positive changes
        int[] gain3 = {1, 2, 3, 4, 5};
        System.out.println("Test case 3: " + solution.largestAltitude(gain3)); // Expected output: 15

        // Test case 4: No altitude changes
        int[] gain4 = {0, 0, 0, 0};
        System.out.println("Test case 4: " + solution.largestAltitude(gain4)); // Expected output: 0

        // Test case 5: Large positive and negative changes
        int[] gain5 = {44, -32, -60, 21, -12, 29};
        System.out.println("Test case 5: " + solution.largestAltitude(gain5)); // Expected output: 44
    }
}
