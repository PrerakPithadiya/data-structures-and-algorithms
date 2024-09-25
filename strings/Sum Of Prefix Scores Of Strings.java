import java.util.*;

class Solution {
    // Trie node class to store character and prefix count
    class TrieNode {
        TrieNode[] children;
        int prefixCount; // How many words have this prefix
        
        TrieNode() {
            children = new TrieNode[26]; // for lowercase English letters
            prefixCount = 0;
        }
    }
    
    // Trie class to handle insertion and score calculation
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        // Insert a word into the Trie and update prefix counts
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.prefixCount++;
            }
        }
        
        // Calculate the total score of all prefixes of the word
        public int getScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                score += node.prefixCount;
            }
            return score;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }
        
        // Calculate the sum of prefix scores for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getScore(words[i]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example 1
        String[] words1 = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(sol.sumPrefixScores(words1))); // Output: [5, 4, 3, 2]

        // Example 2
        String[] words2 = {"abcd"};
        System.out.println(Arrays.toString(sol.sumPrefixScores(words2))); // Output: [4]
    }
}
