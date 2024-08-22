
import java.util.Stack;

/**
 * Solution class for decoding encoded strings.
 */
class Solution {

    /**
     * Decodes a string that has been encoded with run-length encoding.
     *
     * The encoding rule is: k[encoded_string], where the encoded_string inside
     * the square brackets is repeated exactly k times. k is guaranteed to be a
     * positive integer.
     *
     * @param s The encoded string to decode
     * @return The decoded string
     */
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the number k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current string and repeat count onto the stack
                countStack.push(k);
                stringStack.push(currentString);
                // Reset for the next part of the string
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the last string and repeat count
                StringBuilder decodedString = stringStack.pop();
                int repeatTimes = countStack.pop();
                // Repeat the current string and append to the last string
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                // Regular character, add to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
