
/**
 * This class provides a solution to find the length of the last word in a given string.
 */
class Solution {

    /**
     * Calculates the length of the last word in the given string.
     *
     * @param s The input string containing words separated by spaces.
     * @return The length of the last word in the string.
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Skip any trailing spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    /**
     * Main method to demonstrate the usage of the lengthOfLastWord method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: A simple string with two words
        String s1 = "Hello World";
        System.out.println("Length of the last word: " + solution.lengthOfLastWord(s1)); // Output: 5

        // Test case 2: A string with multiple spaces between words and at the end
        String s2 = "   fly me   to   the moon  ";
        System.out.println("Length of the last word: " + solution.lengthOfLastWord(s2)); // Output: 4

        // Test case 3: A string with no trailing spaces
        String s3 = "luffy is still joyboy";
        System.out.println("Length of the last word: " + solution.lengthOfLastWord(s3)); // Output: 6
    }
}

/*
     * Usage Instructions:
     * 1. Create an instance of the Solution class.
     * 2. Call the lengthOfLastWord method with a string as an argument.
     * 3. The method will return the length of the last word in the string.
     *
     * Example:
     *     Solution solution = new Solution();
     *     int length = solution.lengthOfLastWord("Hello World");
     *     System.out.println(length); // Output: 5
     *
     * Note: The method handles trailing spaces and multiple spaces between words.
 */
