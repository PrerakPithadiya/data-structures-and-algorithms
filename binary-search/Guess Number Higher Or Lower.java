
/**
 * This class extends GuessGame and implements the guessNumber method to solve the "Guess Number Higher or Lower" problem.
 * The problem involves guessing a picked number within a given range using a binary search approach.
 */
public class Solution extends GuessGame {

    /**
     * Guesses the picked number using binary search.
     *
     * @param n The upper bound of the range (1 to n) in which the number is
     * picked.
     * @return The correctly guessed number.
     */
    @Override
    public int guessNumber(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            int result = guess((int) mid);

            switch (result) {
                case 0 -> {
                    return (int) mid; // Correct guess
                }
                case 1 ->
                    left = mid + 1; // Guess is lower than the picked number
                default ->
                    right = mid - 1; // Guess is higher than the picked number
                }

        }

        // In case there's an error, but according to constraints, this line should never be reached.
        return -1;
    }

    /**
     * Main method to run test cases for the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: n = 10, pick = 6
        solution.pick = 6;
        System.out.println("Test case 1: n = 10, pick = 6");
        System.out.println("Result: " + solution.guessNumber(10));
        System.out.println("Expected: 6");

        // Test case 2: n = 1, pick = 1
        solution.pick = 1;
        System.out.println("\nTest case 2: n = 1, pick = 1");
        System.out.println("Result: " + solution.guessNumber(1));
        System.out.println("Expected: 1");

        // Test case 3: n = 2, pick = 1
        solution.pick = 1;
        System.out.println("\nTest case 3: n = 2, pick = 1");
        System.out.println("Result: " + solution.guessNumber(2));
        System.out.println("Expected: 1");

        // Test case 4: n = 2, pick = 2
        solution.pick = 2;
        System.out.println("\nTest case 4: n = 2, pick = 2");
        System.out.println("Result: " + solution.guessNumber(2));
        System.out.println("Expected: 2");
    }
}
