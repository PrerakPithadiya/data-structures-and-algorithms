
/**
 * Solution class for the "Koko Eating Bananas" problem.
 * This class implements a binary search algorithm to find the minimum eating speed
 * that allows Koko to eat all the bananas within the given time.
 */
class Solution {

    /**
     * Finds the minimum eating speed required to eat all bananas within the
     * given hours.
     *
     * @param piles An array of integers representing the number of bananas in
     * each pile.
     * @param h The maximum number of hours allowed to eat all bananas.
     * @return The minimum eating speed (bananas per hour) required.
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Checks if it's possible to eat all bananas within the given hours at a
     * specific speed.
     *
     * @param piles The array of banana piles.
     * @param speed The eating speed to check.
     * @param h The maximum number of hours allowed.
     * @return true if it's possible to eat all bananas, false otherwise.
     */
    private boolean canEatAll(int[] piles, int speed, int h) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed; // Equivalent to Math.ceil(pile / (double)speed)
        }
        return totalHours <= h;
    }

    /**
     * Finds the maximum number of bananas in a single pile.
     *
     * @param piles The array of banana piles.
     * @return The maximum number of bananas in a single pile.
     */
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }

    /**
     * Main method to run test cases for the Koko Eating Bananas problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Test case 1: " + solution.minEatingSpeed(piles1, h1)); // Expected output: 4

        // Test case 2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Test case 2: " + solution.minEatingSpeed(piles2, h2)); // Expected output: 30

        // Test case 3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Test case 3: " + solution.minEatingSpeed(piles3, h3)); // Expected output: 23
    }
}
