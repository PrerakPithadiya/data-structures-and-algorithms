package bitmask;

import java.util.ArrayList;
import java.util.List;

/**
 * This class solves the problem of finding the maximum product of lengths
 * of two disjoint palindromic subsequences in a given string.
 */
class MaxPalindromeProduct {

    /**
     * Checks if a given string is a palindrome.
     *
     * @param s The string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Generates all palindromic subsequences of a given string along with their
     * bitmasks.
     *
     * @param s           The input string.
     * @param palindromes A list to store the generated palindromic subsequences.
     * @return A list of bitmasks corresponding to the palindromic subsequences.
     */
    private List<Integer> generatePalindromicSubsequences(String s, List<String> palindromes) {
        int n = s.length();
        List<Integer> masks = new ArrayList<>();

        // Iterate through all possible subsequences using bitmasking
        for (int mask = 1; mask < (1 << n); mask++) {
            StringBuilder subseq = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subseq.append(s.charAt(i));
                }
            }
            String subseqStr = subseq.toString();
            if (isPalindrome(subseqStr)) {
                palindromes.add(subseqStr);
                masks.add(mask); // Store the bitmask
            }
        }
        return masks;
    }

    /**
     * Finds the maximum product of lengths of two disjoint palindromic
     * subsequences.
     *
     * @param s The input string.
     * @return The maximum product of lengths of two disjoint palindromic
     *         subsequences.
     */
    public int maxProduct(String s) {
        List<String> palindromes = new ArrayList<>();
        List<Integer> masks = generatePalindromicSubsequences(s, palindromes);
        int maxProduct = 0;

        // Check all pairs of palindromic subsequences
        for (int i = 0; i < masks.size(); i++) {
            for (int j = i + 1; j < masks.size(); j++) {
                // Ensure the two subsequences are disjoint (no overlapping characters)
                if ((masks.get(i) & masks.get(j)) == 0) {
                    int product = palindromes.get(i).length() * palindromes.get(j).length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaxPalindromeProduct solution = new MaxPalindromeProduct();

        // Test Case 1
        String s1 = "leetcodecom";
        System.out.println("Max product for s1: " + solution.maxProduct(s1)); // Expected output: 9

        // Test Case 2
        String s2 = "bb";
        System.out.println("Max product for s2: " + solution.maxProduct(s2)); // Expected output: 1

        // Test Case 3
        String s3 = "accbcaxxcxx";
        System.out.println("Max product for s3: " + solution.maxProduct(s3)); // Expected output: 25

        // Test Case 4
        String s4 = "aaa";
        System.out.println("Max product for s4: " + solution.maxProduct(s4)); // Expected output: 3

        // Test Case 5
        String s5 = "abcdef";
        System.out.println("Max product for s5: " + solution.maxProduct(s5)); // Expected output: 1

        // Test Case 6
        String s6 = "ababab";
        System.out.println("Max product for s6: " + solution.maxProduct(s6)); // Expected output: 9
    }
}
