package counting;

/**
 * Solution for the Bulls and Cows problem.
 */
class Solution {

    /**
     * Calculates the hint for the Bulls and Cows game.
     *
     * @param secret The secret number as a string.
     * @param guess The guessed number as a string.
     * @return A string in the format "xAyB", where x is the number of bulls and
     * y is the number of cows.
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        // Array to count frequency of unmatched digits in secret and guess
        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        // Traverse through the strings to count bulls and store unmatched digits
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                // Count as bull if both digits match at the same index
                bulls++;
            } else {
                // If not a bull, increment the frequency of unmatched digits
                secretFreq[s - '0']++;
                guessFreq[g - '0']++;
            }
        }

        // Count cows by finding minimum overlap of unmatched digits
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        // Return the result in the required format
        return bulls + "A" + cows + "B";
    }

    /**
     * Main method for testing the Solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String secret1 = "1807";
        String guess1 = "7810";
        System.out.println("Test case 1: " + solution.getHint(secret1, guess1)); // Expected output: "1A3B"

        // Test case 2
        String secret2 = "1123";
        String guess2 = "0111";
        System.out.println("Test case 2: " + solution.getHint(secret2, guess2)); // Expected output: "1A1B"

        // Test case 3
        String secret3 = "1";
        String guess3 = "0";
        System.out.println("Test case 3: " + solution.getHint(secret3, guess3)); // Expected output: "0A0B"

        // Test case 4
        String secret4 = "1";
        String guess4 = "1";
        System.out.println("Test case 4: " + solution.getHint(secret4, guess4)); // Expected output: "1A0B"
    }
}
