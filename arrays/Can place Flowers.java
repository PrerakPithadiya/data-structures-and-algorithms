/**
 * Solution class for the flower planting problem.
 */
class Solution {
    /**
     * Determines if n flowers can be planted in the given flowerbed without
     * violating the no-adjacent-flowers rule.
     *
     * @param flowerbed An integer array representing the flowerbed, where 0 means
     *                  empty and 1 means planted.
     * @param n         The number of flowers to be planted.
     * @return true if n flowers can be planted, false otherwise.
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                // Check if the previous and next plots are empty (or if the current plot is on
                // the edge)
                boolean emptyPrev = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyNext = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (emptyPrev && emptyNext) {
                    // Plant the flower here
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }

        return n == 0;
    }

    /**
     * Main method to demonstrate the usage of the canPlaceFlowers method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] flowerbed1 = { 1, 0, 0, 0, 1 };
        int n1 = 1;
        System.out.println(solution.canPlaceFlowers(flowerbed1, n1)); // Output: true

        // Example 2
        int[] flowerbed2 = { 1, 0, 0, 0, 1 };
        int n2 = 2;
        System.out.println(solution.canPlaceFlowers(flowerbed2, n2)); // Output: false
    }
}