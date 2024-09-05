
import java.util.*;

/**
 * This class implements a solution to the Word Search II problem using a Trie
 * data structure. The problem involves finding all words from a given
 * dictionary in a 2D board of characters.
 */
class WordSearch {

    /**
     * Inner class representing a node in the Trie.
     */
    private class TrieNode {

        TrieNode[] children = new TrieNode[26];  // Each node can have up to 26 children (a-z)
        String word = null;  // Stores the complete word at leaf nodes
    }

    private final TrieNode root = new TrieNode();  // Root of the Trie
    private final Set<String> result = new HashSet<>();  // Set to store unique found words

    /**
     * Builds the Trie data structure from the given list of words.
     *
     * @param words Array of words to be inserted into the Trie
     */
    public void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;  // Mark the end of the word
        }
    }

    /**
     * Performs a depth-first search (DFS) on the board to find words.
     *
     * @param board 2D character array representing the board
     * @param i Row index
     * @param j Column index
     * @param node Current TrieNode
     */
    public void dfs(char[][] board, int i, int j, TrieNode node) {
        // Boundary checks
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;  // Cell is visited or character is not in Trie
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);  // Found a word
        }

        // Mark the current cell as visited
        board[i][j] = '#';

        // Explore all 4 directions (up, down, left, right)
        dfs(board, i + 1, j, node);
        dfs(board, i - 1, j, node);
        dfs(board, i, j + 1, node);
        dfs(board, i, j - 1, node);

        // Restore the current cell
        board[i][j] = c;
    }

    /**
     * Finds all words from the given dictionary in the 2D board.
     *
     * @param board 2D character array representing the board
     * @param words Array of words to search for
     * @return List of words found in the board
     */
    public List<String> findWords(char[][] board, String[] words) {
        // Build the Trie from the words list
        buildTrie(words);

        // Iterate over every cell in the board and start DFS if valid
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root);
                }
            }
        }

        return new ArrayList<>(result);  // Return the list of found words
    }

    /**
     * Main method to demonstrate the usage of the WordSearch class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> foundWords = solution.findWords(board, words);
        System.out.println("Words found: " + foundWords);
    }
}
