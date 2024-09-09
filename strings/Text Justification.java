
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for the Text Justification problem. It takes
 * an array of words and a maximum width, and returns a list of justified
 * strings that fit within the given width.
 */
class TextJustification {

    /**
     * Justifies the given words into lines of maximum width.
     *
     * @param words An array of words to be justified
     * @param maxWidth The maximum width of each line
     * @return A list of justified strings
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int numOfLetters = 0;

        for (String word : words) {
            // Check if adding the next word would exceed maxWidth
            if (numOfLetters + word.length() + currentLine.size() > maxWidth) {
                result.add(justify(currentLine, numOfLetters, maxWidth));
                currentLine = new ArrayList<>();
                numOfLetters = 0;
            }
            // Add the current word to the line
            currentLine.add(word);
            numOfLetters += word.length();
        }

        // Handle the last line - left-justified
        result.add(justifyLastLine(currentLine, maxWidth));

        return result;
    }

    /**
     * Justifies a single line of words.
     *
     * @param words List of words in the line
     * @param numOfLetters Total number of letters in the words
     * @param maxWidth Maximum width of the line
     * @return A justified string
     */
    private String justify(List<String> words, int numOfLetters, int maxWidth) {
        StringBuilder line = new StringBuilder();
        int totalSpaces = maxWidth - numOfLetters;
        int numGaps = words.size() - 1;

        if (numGaps == 0) {
            // Single word in line, just add it followed by spaces
            return padRight(words.get(0), maxWidth);
        } else {
            int spacesBetweenGaps = totalSpaces / numGaps;
            int extraSpaces = totalSpaces % numGaps;

            for (int i = 0; i < words.size(); i++) {
                if (i > 0) {
                    int spaceCount = spacesBetweenGaps + (i <= extraSpaces ? 1 : 0);
                    line.append(" ".repeat(spaceCount));
                }
                line.append(words.get(i));
            }
        }

        return line.toString();
    }

    /**
     * Justifies the last line, which is left-justified with spaces at the end.
     *
     * @param words List of words in the last line
     * @param maxWidth Maximum width of the line
     * @return A left-justified string with spaces at the end
     */
    private String justifyLastLine(List<String> words, int maxWidth) {
        String lastLine = String.join(" ", words);
        return padRight(lastLine, maxWidth);
    }

    /**
     * Pads a string with spaces to the right to reach the specified width.
     *
     * @param s The string to pad
     * @param width The desired width
     * @return A padded string
     */
    private String padRight(String s, int width) {
        return String.format("%-" + width + "s", s);
    }

    /**
     * Main method to demonstrate the usage of the TextJustification class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        TextJustification tj = new TextJustification();

        // Example 1
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(tj.fullJustify(words1, maxWidth1));

        // Example 2
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println(tj.fullJustify(words2, maxWidth2));

        // Example 3
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println(tj.fullJustify(words3, maxWidth3));
    }
}
