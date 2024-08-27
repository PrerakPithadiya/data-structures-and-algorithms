
/**
 * This class represents a Trie data structure, also known as a prefix tree.
 * It is used for efficient storage and retrieval of strings, particularly
 * useful for tasks like autocomplete and spell checking.
 */
class Trie {

    /**
     * The root node of the Trie.
     */
    private TrieNode root;

    /**
     * Constructs a new Trie with an empty root node.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the Trie.
     *
     * @param word The word to be inserted.
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    /**
     * Searches for a word in the Trie.
     *
     * @param word The word to search for.
     * @return true if the word is found, false otherwise.
     */
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    /**
     * Checks if there is any word in the Trie that starts with the given
     * prefix.
     *
     * @param prefix The prefix to search for.
     * @return true if there is a word with the given prefix, false otherwise.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    /**
     * Main method to demonstrate the functionality of the Trie.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1:
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

        // Additional Test Case 1:
        trie.insert("banana");
        System.out.println(trie.search("banana"));   // returns true
        System.out.println(trie.startsWith("ban"));  // returns true
        System.out.println(trie.search("banan"));    // returns false

        // Additional Test Case 2:
        trie.insert("carrot");
        trie.insert("car");
        System.out.println(trie.search("car"));      // returns true
        System.out.println(trie.startsWith("carr")); // returns true
        System.out.println(trie.search("carry"));    // returns false
    }
}

/**
 * This class represents a node in the Trie data structure. Each node contains
 * an array of child nodes and a flag indicating if it represents the end of a
 * word.
 */
class TrieNode {

    /**
     * Array of child nodes, one for each letter of the English alphabet.
     */
    TrieNode[] children;

    /**
     * Flag indicating if this node represents the end of a word.
     */
    boolean isEndOfWord;

    /**
     * Constructs a new TrieNode with initialized children array and isEndOfWord
     * flag.
     */
    public TrieNode() {
        children = new TrieNode[26]; // 26 letters of the English alphabet
        isEndOfWord = false;
    }
}
