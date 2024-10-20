package counting;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution class for sorting characters in a string by their frequency.
 */
class Solution {

    /**
     * Sorts the characters in the input string based on their frequency in
     * descending order.
     *
     * @param s The input string to be sorted.
     * @return A new string with characters sorted by their frequency.
     */
    public String frequencySort(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max heap to sort characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap
                = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freqMap.entrySet());

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char character = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(character);
            }
        }

        // Step 4: Return the result string
        return result.toString();
    }

    /**
     * Main method for testing the frequencySort function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String input1 = "tree";
        System.out.println("Input: " + input1);
        System.out.println("Output: " + solution.frequencySort(input1));
        System.out.println("Expected: eert");

        // Test case 2
        String input2 = "cccaaa";
        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + solution.frequencySort(input2));
        System.out.println("Expected: aaaccc or cccaaa");

        // Test case 3
        String input3 = "Aabb";
        System.out.println("\nInput: " + input3);
        System.out.println("Output: " + solution.frequencySort(input3));
        System.out.println("Expected: bbAa");
    }
}
