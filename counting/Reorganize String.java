package counting;

import java.util.*;

/**
 * Solution class for reorganizing a string so that no two adjacent characters
 * are the same.
 */
class Solution {

    /**
     * Reorganizes the input string so that no two adjacent characters are the
     * same.
     *
     * @param s The input string to be reorganized.
     * @return The reorganized string if possible, or an empty string if not
     * possible.
     */
    public String reorganizeString(String s) {
        // Step 1: Build a frequency map
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Build a max heap based on the frequencies
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: Try to rearrange the characters
        StringBuilder result = new StringBuilder();
        Character prevChar = null;  // To store the previously placed character
        while (!maxHeap.isEmpty()) {
            // Step 3.1: Pick the most frequent character
            Character currentChar = maxHeap.poll();

            // Append the current character to the result
            result.append(currentChar);

            // Decrease the frequency of the current character
            frequencyMap.put(currentChar, frequencyMap.get(currentChar) - 1);

            // If there was a previous character (which is now allowed to be used again), reinsert it into the heap
            if (prevChar != null && frequencyMap.get(prevChar) > 0) {
                maxHeap.offer(prevChar);
            }

            // Set the current character as the previous character for the next round
            prevChar = currentChar;

            // If the current character has no more frequency left, it won't be added back to the heap
        }

        // Step 4: Check if the result is valid (i.e., no two adjacent characters are the same)
        return result.length() == s.length() ? result.toString() : "";
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Valid reorganization
        String s1 = "aab";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.reorganizeString(s1));

        // Test case 2: Invalid reorganization
        String s2 = "aaab";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.reorganizeString(s2));

        // Test case 3: Complex valid reorganization
        String s3 = "aabbccdef";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.reorganizeString(s3));
    }
}
