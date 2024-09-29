
/**
 * Solution class for the Nim Game problem.
 *
 * The Nim Game is played with a heap of stones, where two players take turns
 * removing 1 to 3 stones. The player who removes the last stone wins.
 */
class Solution {

    /**
     * Determines if the first player can win the Nim Game.
     *
     * @param n The number of stones in the heap.
     * @return true if the first player can win, false otherwise.
     */
    public boolean canWinNim(int n) {
        // The winning strategy is to leave a multiple of 4 stones to the opponent.
        // If the number of stones is not divisible by 4, the first player can always
        // make a move that leaves a multiple of 4 stones to the opponent, ensuring a win.
        return n % 4 != 0;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] testCases = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int n : testCases) {
            boolean result = solution.canWinNim(n);
            System.out.println("n = " + n + ": " + (result ? "First player wins" : "Second player wins"));
        }
    }
}
