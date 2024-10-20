package counting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution class for finding the top K frequent words in an array.
 */
class Solution {

    /**
     * Finds the top K frequent words in the given array of words.
     *
     * @param words The input array of words.
     * @param k The number of top frequent words to return.
     * @return A list of the top K frequent words.
     */
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Create a frequency map
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Use a priority queue (min-heap) to keep the top k frequent words
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1, w2) -> frequencyMap.get(w1).equals(frequencyMap.get(w2))
                ? w2.compareTo(w1) : frequencyMap.get(w1) - frequencyMap.get(w2)
        );

        // Step 3: Push each word into the heap, keeping its size limited to k
        for (String word : frequencyMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Extract elements from the heap and build the result in reverse order
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        // Step 5: Since we want the most frequent words first, reverse the result list
        Collections.reverse(result);

        return result;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println("Test case 1:");
        System.out.println("Input: words = " + java.util.Arrays.toString(words1) + ", k = " + k1);
        System.out.println("Output: " + solution.topKFrequent(words1, k1));
        System.out.println();

        // Test case 2
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println("Test case 2:");
        System.out.println("Input: words = " + java.util.Arrays.toString(words2) + ", k = " + k2);
        System.out.println("Output: " + solution.topKFrequent(words2, k2));
    }
}
