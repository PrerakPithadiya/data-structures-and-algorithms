
import java.util.HashMap;
import java.util.Map;

class LongestEvenVowelSubstring {

    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask
        Map<Integer, Integer> bitmaskMap = new HashMap<>();
        // Initialize with bitmask 0 at index -1 (to handle cases where the substring starts from index 0)
        bitmaskMap.put(0, -1);

        int bitmask = 0;  // To track the parity of vowels
        int maxLength = 0; // To track the length of the longest valid substring

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Update the bitmask based on the current character
            switch (c) {
                case 'a' ->
                    bitmask ^= (1); // Flip bit 0 for 'a'
                case 'e' ->
                    bitmask ^= (1 << 1); // Flip bit 1 for 'e'
                case 'i' ->
                    bitmask ^= (1 << 2); // Flip bit 2 for 'i'
                case 'o' ->
                    bitmask ^= (1 << 3); // Flip bit 3 for 'o'
                case 'u' ->
                    bitmask ^= (1 << 4); // Flip bit 4 for 'u'
                default -> {
                }
            }

            // Check if we've seen this bitmask before
            if (bitmaskMap.containsKey(bitmask)) {
                // If yes, calculate the length of the substring
                int previousIndex = bitmaskMap.get(bitmask);
                maxLength = Math.max(maxLength, i - previousIndex);
            } else {
                // If no, store the current index as the first occurrence of this bitmask
                bitmaskMap.put(bitmask, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestEvenVowelSubstring solution = new LongestEvenVowelSubstring();

        // Test cases
        String s1 = "eleetminicoworoep";
        System.out.println("Test case 1 result: " + solution.findTheLongestSubstring(s1));  // Output: 13

        String s2 = "leetcodeisgreat";
        System.out.println("Test case 2 result: " + solution.findTheLongestSubstring(s2));  // Output: 5

        String s3 = "bcbcbc";
        System.out.println("Test case 3 result: " + solution.findTheLongestSubstring(s3));  // Output: 6
    }
}
