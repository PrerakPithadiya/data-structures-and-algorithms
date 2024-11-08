
class Solution {

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
        System.out.println(minRepeats("ww", "www")); // Output: 2
        System.out.println(minRepeats("abcd", "cdabcdab")); // Output: 3
        System.out.println(minRepeats("ab", "cab")); // Output: -1
    }
}
