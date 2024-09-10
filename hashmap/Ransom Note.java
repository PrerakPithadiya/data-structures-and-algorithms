
/**
 * This class provides a solution to the "Ransom Note" problem.
 * The problem involves determining if a ransom note can be constructed
 * using letters from a given magazine.
 */
class Solution {

    /**
     * Determines if a ransom note can be constructed from a magazine.
     *
     * @param ransomNote The string representing the ransom note.
     * @param magazine The string representing the magazine.
     * @return true if the ransom note can be constructed, false otherwise.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // Create an array to store the frequency of characters in magazine
        int[] charCount = new int[26];

        // Count the frequency of each character in magazine
        for (char ch : magazine.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Check if ransomNote can be constructed from magazine's characters
        for (char ch : ransomNote.toCharArray()) {
            if (charCount[ch - 'a'] == 0) {
                // If a character in ransomNote cannot be found in magazine, return false
                return false;
            }
            // Decrease the count of the character in magazine
            charCount[ch - 'a']--;
        }

        // If all characters in ransomNote are found in magazine, return true
        return true;
    }

    /**
     * Main method to demonstrate the usage of the canConstruct method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Demonstrate a case where construction is not possible
        System.out.println(solution.canConstruct("a", "b"));  // Output: false

        // Example 2: Demonstrate another case where construction is not possible
        System.out.println(solution.canConstruct("aa", "ab"));  // Output: false

        // Example 3: Demonstrate a case where construction is possible
        System.out.println(solution.canConstruct("aa", "aab"));  // Output: true
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * canConstruct method with two string arguments: - The first argument is the
 * ransom note. - The second argument is the magazine. 3. The method will return
 * true if the ransom note can be constructed from the magazine, and false
 * otherwise.
 *
 * Example: Solution solution = new Solution(); boolean result =
 * solution.canConstruct("hello", "magazine");
 *
 * Design and Implementation Notes: - The solution uses a frequency count
 * approach to solve the problem efficiently. - An integer array of size 26 is
 * used to store the frequency of lowercase English letters. - The time
 * complexity of the solution is O(m + n), where m and n are the lengths of the
 * ransomNote and magazine strings respectively. - The space complexity is O(1)
 * as we use a fixed-size array of 26 elements.
 */
