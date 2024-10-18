
import java.util.HashSet;

/**
 * Solution class for checking if a string contains all binary codes of size K.
 */
class Solution {

    /**
     * Checks if the given string contains all binary codes of size K.
     *
     * @param s The input string containing only '0' and '1' characters.
     * @param k The size of the binary codes to check for.
     * @return true if the string contains all binary codes of size K, false
     * otherwise.
     */
    public boolean hasAllCodes(String s, int k) {
        // If the length of s is smaller than k, we can't have all binary codes of length k
        if (s.length() < k) {
            return false;
        }

        // Set to store all unique substrings of length k
        HashSet<String> seen = new HashSet<>();

        // Traverse the string with a sliding window of size k
        for (int i = 0; i <= s.length() - k; i++) {
            // Extract the substring of length k starting from index i
            String substring = s.substring(i, i + k);
            seen.add(substring);

            // Early exit: If we have found all possible binary codes of length k
            if (seen.size() == (1 << k)) {
                return true;
            }
        }

        // Check if we have found exactly 2^k unique substrings
        return seen.size() == (1 << k);
    }

    /**
     * Main method for testing the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "00110110";
        int k1 = 2;
        System.out.println("Test case 1: " + solution.hasAllCodes(s1, k1)); // Expected: true

        // Test case 2
        String s2 = "00110";
        int k2 = 2;
        System.out.println("Test case 2: " + solution.hasAllCodes(s2, k2)); // Expected: true

        // Test case 3
        String s3 = "0110";
        int k3 = 1;
        System.out.println("Test case 3: " + solution.hasAllCodes(s3, k3)); // Expected: true

        // Test case 4
        String s4 = "0110";
        int k4 = 2;
        System.out.println("Test case 4: " + solution.hasAllCodes(s4, k4)); // Expected: false

        // Test case 5
        String s5 = "0000000001011100";
        int k5 = 4;
        System.out.println("Test case 5: " + solution.hasAllCodes(s5, k5)); // Expected: false
    }
}
