/**
 * Solution class to find the maximum number of vowels in a substring of given
 * length.
 */
class Solution {
    /**
     * Finds the maximum number of vowels in any substring of length k in the given
     * string.
     *
     * @param s The input string to search for vowels.
     * @param k The length of the substring to consider.
     * @return The maximum number of vowels in any substring of length k.
     */
    public int maxVowels(String s, int k) {
        // Define the set of vowels
        String vowels = "aeiou";
        int maxVowels, currentVowels = 0;

        // Count the number of vowels in the first window of size k
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels; // Initialize maxVowels with the first window's count

        // Slide the window from left to right across the string
        for (int i = k; i < s.length(); i++) {
            // Add the new character in the window
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentVowels++;
            }

            // Remove the character that is out of the window
            if (vowels.indexOf(s.charAt(i - k)) != -1) {
                currentVowels--;
            }

            // Update the maxVowels if the current window has more vowels
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    /**
     * Main method to demonstrate the usage of the maxVowels method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println(solution.maxVowels(s1, k1)); // Output: 3

        // Example 2
        String s2 = "aeiou";
        int k2 = 2;
        System.out.println(solution.maxVowels(s2, k2)); // Output: 2

        // Example 3
        String s3 = "leetcode";
        int k3 = 3;
        System.out.println(solution.maxVowels(s3, k3)); // Output: 2
    }
}
