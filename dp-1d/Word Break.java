
import java.util.*;

/**
 * Solution class for the Word Break problem. This class provides a method to
 * determine if a given string can be segmented into words from a dictionary.
 */
class Solution {

    /**
     * Determines if a string can be segmented into words from the given
     * dictionary.
     *
     * @param s The input string to be segmented.
     * @param wordDict A list of words that act as a dictionary.
     * @return true if the string can be segmented, false otherwise.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Use a HashSet for fast lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Empty string can be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further if s[0:i] can be segmented
                }
            }
        }

        return dp[n];  // Final result for the entire string
    }

    /**
     * Main method to run test cases for the wordBreak method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "leetcode";
        List<String> wordDict1 = Arrays.asList("leet", "code");
        System.out.println("Test case 1: " + solution.wordBreak(s1, wordDict1));  // Expected: true

        // Test case 2
        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        System.out.println("Test case 2: " + solution.wordBreak(s2, wordDict2));  // Expected: true

        // Test case 3
        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog");
        System.out.println("Test case 3: " + solution.wordBreak(s3, wordDict3));  // Expected: false

        // Test case 4
        String s4 = "aaaaaaa";
        List<String> wordDict4 = Arrays.asList("aaaa", "aaa");
        System.out.println("Test case 4: " + solution.wordBreak(s4, wordDict4));  // Expected: true

        // Test case 5
        String s5 = "goalspecial";
        List<String> wordDict5 = Arrays.asList("go", "goal");
        System.out.println("Test case 5: " + solution.wordBreak(s5, wordDict5));  // Expected: true
    }
}

/*
        Usage Instructions:
        1. Compile the Java file: javac Solution.java
        2. Run the compiled class: java Solution

        The main method includes several test cases that demonstrate the usage of the wordBreak method.
        You can add more test cases or modify existing ones as needed.

        Design and Implementation:
        - The solution uses dynamic programming to solve the Word Break problem efficiently.
        - A boolean array 'dp' is used to store intermediate results.
        - dp[i] is true if the substring s[0:i] can be segmented into words from the dictionary.
        - The time complexity is O(n^2), where n is the length of the input string.
        - The space complexity is O(n) for the dp array and O(m) for the HashSet, where m is the number of words in the dictionary.

        The wordBreak method:
        1. Converts the word dictionary to a HashSet for faster lookups.
        2. Initializes a boolean array 'dp' with length n+1 (n is the length of the input string).
        3. Sets dp[0] to true, as an empty string is always considered segmentable.
        4. Iterates through the string, checking if each substring can be segmented.
        5. For each position i, it checks if there's a valid word ending at i and if the preceding part is segmentable.
        6. If a valid segmentation is found, it marks dp[i] as true and moves to the next position.
        7. The final result is stored in dp[n], which represents whether the entire string can be segmented.
 */
