
/**
 * Solution class to find minimum number of repetitions needed to make target string a substring
 */
class Solution {

    /**
     * Determines the minimum number of times the original string needs to be
     * repeated to make the target string a substring of the repeated string.
     *
     * @param original The original string to be repeated
     * @param target The target string to search for
     * @return The minimum number of repetitions needed, or -1 if impossible
     */
    static int minRepeats(String original, String target) {
        String repeatedString = original;
        int repeatCount = 1;

        // Repeat original until its length is at least the length of target
        while (original.length() < target.length()) {
            original += repeatedString;
            repeatCount++;
        }

        // Check if target is a substring of the repeated original
        if (original.contains(target)) {
            return repeatCount;
        }

        // Append one more repetition to check the boundary case
        original += repeatedString;
        repeatCount++;

        // Check again if target is a substring
        if (original.contains(target)) {
            return repeatCount;
        }

        // If target is still not a substring, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(minRepeats("abc", "abcabc")); // Output: 2
        System.out.println(minRepeats("xyz", "xyzxyzxyz")); // Output: 3
        System.out.println(minRepeats("a", "aa")); // Output: 2
        System.out.println(minRepeats("hello", "world")); // Output: -1
        System.out.println(minRepeats("x", "x")); // Output: 1
        System.out.println(minRepeats("abc", "cabcabca")); // Output: 3
        System.out.println(minRepeats("", "")); // Output: 1
    }
}
