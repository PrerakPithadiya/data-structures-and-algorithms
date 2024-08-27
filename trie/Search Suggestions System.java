
import java.util.*;

/**
 * This class implements a Search Suggestions System using a Trie data
 * structure. It provides functionality to suggest products based on a search
 * word prefix.
 */
class Solution {

    /**
     * TrieNode class represents a node in the Trie data structure. Each node
     * contains an array of children nodes and a list of product suggestions.
     */
    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    /**
     * The root node of the Trie.
     */
    private TrieNode root = new TrieNode();

    /**
     * Inserts a product into the Trie and maintains the top 3 lexicographically
     * smallest suggestions at each node.
     *
     * @param product The product to be inserted into the Trie.
     */
    private void insert(String product) {
        TrieNode node = root;
        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            if (node.suggestions.size() < 3) {
                node.suggestions.add(product);
            }
        }
    }

    /**
     * Suggests products based on the given search word.
     *
     * @param products An array of product names.
     * @param searchWord The search word to generate suggestions for.
     * @return A list of lists containing suggested products for each prefix of
     * the search word.
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort products lexicographically
        Arrays.sort(products);

        // Insert each product into the Trie
        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        // Search for each prefix of searchWord
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (node != null) {
                node = node.children[index];
            }
            if (node == null) {
                result.add(new ArrayList<>()); // No suggestions available
            } else {
                result.add(new ArrayList<>(node.suggestions));
            }
        }

        return result;
    }

    /**
     * Main method to demonstrate the functionality of the Search Suggestions
     * System.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String[] products1 = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord1 = "mouse";
        System.out.println("Example 1 Results:");
        System.out.println(solution.suggestedProducts(products1, searchWord1));

        // Example 2
        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        System.out.println("Example 2 Results:");
        System.out.println(solution.suggestedProducts(products2, searchWord2));
    }
}
