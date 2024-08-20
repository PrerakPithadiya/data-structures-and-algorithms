import java.util.Arrays;

/**
 * This class provides a solution for compressing a character array.
 */
class Solution {
    /**
     * Compresses the given character array in-place.
     * 
     * @param chars The character array to be compressed.
     * @return The length of the compressed array.
     */
    public int compress(char[] chars) {
        int write = 0; // Pointer to write the compressed characters
        int read = 0; // Pointer to read through the chars array

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count the number of occurrences of the current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character to the compressed array
            chars[write++] = currentChar;

            // If count is greater than 1, write the digits of the count
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // The new length of the compressed array
    }

    /**
     * Main method to demonstrate the compression algorithm with examples.
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        char[] chars1 = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        int length1 = solution.compress(chars1);
        System.out.println(length1); // Output: 6
        System.out.println(Arrays.toString(Arrays.copyOf(chars1, length1))); // Output: [a, 2, b, 2, c, 3]

        // Example 2
        char[] chars2 = { 'a' };
        int length2 = solution.compress(chars2);
        System.out.println(length2); // Output: 1
        System.out.println(Arrays.toString(Arrays.copyOf(chars2, length2))); // Output: [a]

        // Example 3
        char[] chars3 = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        int length3 = solution.compress(chars3);
        System.out.println(length3); // Output: 4
        System.out.println(Arrays.toString(Arrays.copyOf(chars3, length3))); // Output: [a, b, 1, 2]
    }
}
