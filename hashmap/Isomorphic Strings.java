
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution to determine if two strings are isomorphic.
 * Two strings are considered isomorphic if the characters in one string can be
 * replaced to get the second string.
 */
class Solution {

    /**
     * Determines if two given strings are isomorphic.
     *
     * @param s The first input string
     * @param t The second input string
     * @return true if the strings are isomorphic, false otherwise
     */
    public boolean isIsomorphic(String s, String t) {
        // Check if the lengths of both strings are equal
        if (s.length() != t.length()) {
            return false;
        }

        // Maps to track character mappings
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        // Traverse both strings simultaneously
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check mapping from s to t
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false; // Mismatch in mapping
                }
            } else {
                sToT.put(sChar, tChar);
            }

            // Check reverse mapping from t to s
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false; // Mismatch in reverse mapping
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }

        return true; // No conflicts in the mapping
    }

    /**
     * Main method to demonstrate the usage of the isIsomorphic method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isIsomorphic("egg", "add")); // Expected output: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Expected output: false
        System.out.println(solution.isIsomorphic("paper", "title")); // Expected output: true
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * isIsomorphic method with two strings as arguments. 3. The method will return
 * true if the strings are isomorphic, false otherwise.
 *
 * Example: Solution solution = new Solution(); boolean result =
 * solution.isIsomorphic("egg", "add");
 *
 * Design: - The solution uses two HashMaps to keep track of character mappings
 * between the two strings. - It ensures that each character from the first
 * string maps to a unique character in the second string, and vice versa.
 *
 * Implementation Details: - The method first checks if the lengths of both
 * strings are equal. If not, they cannot be isomorphic. - It then iterates
 * through both strings simultaneously, checking and updating the mappings. - If
 * a conflict in mapping is found at any point, the method returns false. - If
 * the entire strings are traversed without conflicts, the method returns true.
 *
 * Time Complexity: O(n), where n is the length of the input strings. Space
 * Complexity: O(1), as the size of the HashMaps is limited by the number of
 * possible characters.
 */
