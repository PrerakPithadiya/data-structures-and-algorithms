
class Solution {

    public String reverseWords(String s) {
        // Step 1: Trim the input string to remove leading and trailing spaces
        s = s.trim();

        // Step 2: Split the string into words using regular expression to handle multiple spaces
        String[] words = s.split("\\s+");

        // Step 3: Reverse the words in the array
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");  // Add a space between words
            }
        }

        // Step 4: Return the reversed words as a single string
        return reversed.toString();
    }
}
