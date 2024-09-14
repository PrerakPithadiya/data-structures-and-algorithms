
import java.util.*;

/**
 * Solution class for the Word Ladder problem. This class implements a method to
 * find the shortest transformation sequence from a begin word to an end word,
 * changing only one letter at a time.
 */
class Solution {

    /**
     * Finds the length of the shortest transformation sequence from beginWord
     * to endWord.
     *
     * @param beginWord The starting word
     * @param endWord The target word
     * @param wordList A list of valid words that can be used in the
     * transformation
     * @return The length of the shortest transformation sequence, or 0 if no
     * such sequence exists
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);  // To allow O(1) lookups
        if (!wordSet.contains(endWord)) {
            return 0;  // If endWord is not in wordList, return 0
        }

        // Queue for BFS: stores the current word and the number of transformation steps
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;  // Start with 1 because we count the beginWord as the first step

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process each word in the current level
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try all possible one-letter transformations
                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];

                    // Change the j-th character to every possible letter ('a' to 'z')
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;  // Skip if it's the same character
                        }
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        // If we find the endWord, return the number of steps
                        if (newWord.equals(endWord)) {
                            return level + 1;  // Found the endWord, so return the path length
                        }

                        // If the new word is in the wordSet and not visited, add it to the queue
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }

                    // Restore the original character after exploring all possibilities
                    wordArray[j] = originalChar;
                }
            }

            // Increment level after exploring all nodes at the current level
            level++;
        }

        // If we exhaust the BFS without finding endWord, return 0
        return 0;
    }

    /**
     * Main method to run test cases for the Word Ladder problem.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String beginWord1 = "hit";
        String endWord1 = "cog";
        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result1 = solution.ladderLength(beginWord1, endWord1, wordList1);
        System.out.println("Test case 1 result: " + result1);  // Expected output: 5

        // Test case 2
        String beginWord2 = "hit";
        String endWord2 = "cog";
        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int result2 = solution.ladderLength(beginWord2, endWord2, wordList2);
        System.out.println("Test case 2 result: " + result2);  // Expected output: 0

        // Test case 3
        String beginWord3 = "a";
        String endWord3 = "c";
        List<String> wordList3 = Arrays.asList("a", "b", "c");
        int result3 = solution.ladderLength(beginWord3, endWord3, wordList3);
        System.out.println("Test case 3 result: " + result3);  // Expected output: 2
    }
}
