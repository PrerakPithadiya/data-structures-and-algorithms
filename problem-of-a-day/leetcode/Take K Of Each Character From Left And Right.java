package LeetCode;

/**
 * Solution for "Take K of Each Character From Left and Right" problem
 *
 * Problem: Given a string s consisting of characters 'a', 'b', and 'c' and a
 * non-negative integer k, return the minimum number of operations needed to
 * take at least k of each character from both left and right sides. If it's not
 * possible to take k of each character, return -1.
 *
 * Time Complexity: O(n) where n is the length of string s Space Complexity:
 * O(1) as we only use fixed size arrays
 */
class Solution {

    public int takeCharacters(String s, int k) {
        // Step 1: Count the occurrences of each character
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // Step 2: Check if it is possible to take k of each character
        for (int i = 0; i < 3; i++) {
            if (totalCount[i] < k) {
                return -1;
            }
        }

        // Step 3: Sliding window to find the maximum valid substring
        int n = s.length();
        int[] windowCount = new int[3];
        int maxWindowSize = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Expand the window
            windowCount[s.charAt(right) - 'a']++;

            // Shrink the window if it becomes invalid
            while (windowCount[0] > totalCount[0] - k
                    || windowCount[1] > totalCount[1] - k
                    || windowCount[2] > totalCount[2] - k) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum valid window size
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        // Step 4: Calculate the result
        return n - maxWindowSize;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        String s1 = "aabaaaacaabc";
        int k1 = 2;
        assert solution.takeCharacters(s1, k1) == 8 : "Test case 1 failed";

        // Test Case 2: Impossible case
        String s2 = "abc";
        int k2 = 2;
        assert solution.takeCharacters(s2, k2) == -1 : "Test case 2 failed";

        // Test Case 3: Minimum possible case
        String s3 = "abcabc";
        int k3 = 1;
        assert solution.takeCharacters(s3, k3) == 3 : "Test case 3 failed";

        // Test Case 4: All characters same
        String s4 = "aaaa";
        int k4 = 1;
        assert solution.takeCharacters(s4, k4) == -1 : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
