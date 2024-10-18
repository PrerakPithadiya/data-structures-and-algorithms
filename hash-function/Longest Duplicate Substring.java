
import java.util.HashSet;

/**
 * Solution class for finding the longest duplicate substring in a given string.
 * This class implements the Rabin-Karp algorithm with binary search to
 * efficiently find the longest duplicate substring.
 */
class Solution {

    /**
     * Finds the longest duplicate substring in the given string.
     *
     * @param s The input string to search for duplicate substrings.
     * @return The longest duplicate substring found, or an empty string if no
     * duplicates exist.
     */
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String result = "";

        // Binary search to find the maximum length of duplicated substring
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String duplicate = searchDuplicate(s, mid);

            if (duplicate != null) {
                result = duplicate; // Found a longer duplicate
                left = mid + 1;     // Try to find even longer
            } else {
                right = mid - 1;    // Try shorter
            }
        }
        return result;
    }

    /**
     * Searches for a duplicate substring of the given length in the string.
     *
     * @param s The string to search in.
     * @param length The length of the substring to search for.
     * @return The duplicate substring if found, null otherwise.
     */
    private String searchDuplicate(String s, int length) {
        long mod = (long) 1e9 + 7;  // Large prime modulus
        long base = 26;             // Base for the hash, 26 for lowercase letters

        long hash = 0;
        long baseL = 1;             // base^length % mod

        for (int i = 0; i < length; i++) {
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
            baseL = (baseL * base) % mod;
        }

        // Set to store the hashes and check for duplicates
        HashSet<Long> seenHashes = new HashSet<>();
        seenHashes.add(hash);

        for (int i = length; i < s.length(); i++) {
            // Rolling hash: remove leading character and add the new character
            hash = (hash * base + (s.charAt(i) - 'a')) % mod;
            hash = (hash - (s.charAt(i - length) - 'a') * baseL % mod + mod) % mod;

            if (seenHashes.contains(hash)) {
                String candidate = s.substring(i - length + 1, i + 1);
                // Confirm by comparing actual substrings
                if (checkDuplicate(s, candidate, i - length + 1, length)) {
                    return candidate;
                }
            }
            seenHashes.add(hash);
        }
        return null;
    }

    /**
     * Checks if the candidate substring is a true duplicate in the string.
     *
     * @param s The original string.
     * @param candidate The candidate duplicate substring.
     * @param start The starting index of the candidate in the original string.
     * @param length The length of the candidate substring.
     * @return true if the candidate is a true duplicate, false otherwise.
     */
    private boolean checkDuplicate(String s, String candidate, int start, int length) {
        // Confirm the hash match is an actual substring match
        for (int i = 0; i < s.length() - length + 1; i++) {
            if (s.substring(i, i + length).equals(candidate) && i != start) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "banana";
        System.out.println("Test case 1:");
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.longestDupSubstring(s1));
        System.out.println("Expected: ana");

        // Test case 2
        String s2 = "abcd";
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.longestDupSubstring(s2));
        System.out.println("Expected: ");

        // Test case 3
        String s3 = "aaaaa";
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.longestDupSubstring(s3));
        System.out.println("Expected: aaaa");
    }
}
