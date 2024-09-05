
/**
 * This class implements a word dictionary using a Trie data structure.
 * It supports adding words and searching for words with wildcard characters.
 */
class WordDictionary {

    /**
     * TrieNode class represents a node in the Trie. Each node contains an array
     * of children nodes and a flag indicating if it's the end of a word.
     */
    private class TrieNode {

        TrieNode[] children;
        boolean isEndOfWord;

        /**
         * Constructor for TrieNode. Initializes the children array and sets
         * isEndOfWord to false.
         */
        public TrieNode() {
            this.children = new TrieNode[26]; // 26 lowercase letters
            this.isEndOfWord = false;
        }
    }

    private TrieNode root;

    /**
     * Constructor for WordDictionary. Initializes the root of the Trie.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word to the dictionary.
     *
     * @param word The word to be added.
     */
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true; // Mark the end of the word
    }

    /**
     * Searches for a word in the dictionary. The word can contain the wildcard
     * character '.'.
     *
     * @param word The word to search for.
     * @return true if the word is found, false otherwise.
     */
    public boolean search(String word) {
        return searchInNode(word, root, 0);
    }

    /**
     * Helper method to recursively search for a word in the Trie.
     *
     * @param word The word to search for.
     * @param node The current TrieNode.
     * @param pos The current position in the word.
     * @return true if the word is found, false otherwise.
     */
    private boolean searchInNode(String word, TrieNode node, int pos) {
        if (pos == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(pos);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchInNode(word, child, pos + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = c - 'a';
            TrieNode child = node.children[index];
            if (child == null) {
                return false;
            }
            return searchInNode(word, child, pos + 1);
        }
    }

    /**
     * Main method to demonstrate the usage of WordDictionary.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        // Adding words to the dictionary
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        // Searching for words
        System.out.println("Search 'pad': " + wordDictionary.search("pad")); // false
        System.out.println("Search 'bad': " + wordDictionary.search("bad")); // true
        System.out.println("Search '.ad': " + wordDictionary.search(".ad")); // true
        System.out.println("Search 'b..': " + wordDictionary.search("b..")); // true
    }
}
