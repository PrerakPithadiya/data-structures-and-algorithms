
import java.util.PriorityQueue;

/**
 * Solution class for generating the longest happy string. A string is
 * considered happy if it does not have a letter appearing more than twice in a
 * row.
 */
class Solution {

    /**
     * Generates the longest possible happy string with the given counts of 'a',
     * 'b', and 'c'.
     *
     * @param a The count of 'a' characters available.
     * @param b The count of 'b' characters available.
     * @param c The count of 'c' characters available.
     * @return The longest happy string that can be generated.
     */
    public String longestDiverseString(int a, int b, int c) {
        // Max-heap to keep track of characters sorted by count.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[1] - x[1]);

        // Add available characters with their counts.
        if (a > 0) {
            maxHeap.offer(new int[]{'a', a});
        }
        if (b > 0) {
            maxHeap.offer(new int[]{'b', b});
        }
        if (c > 0) {
            maxHeap.offer(new int[]{'c', c});
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Get the character with the highest remaining count.
            int[] first = maxHeap.poll();

            // Check if we can add this character (no triple repetition).
            if (result.length() >= 2
                    && result.charAt(result.length() - 1) == first[0]
                    && result.charAt(result.length() - 2) == first[0]) {

                // If we can't add this character, check the next one in the heap.
                if (maxHeap.isEmpty()) {
                    break; // No other character to add, so stop.
                }

                // Get the second character from the heap.
                int[] second = maxHeap.poll();
                result.append((char) second[0]);
                second[1]--;

                // If the second character has more occurrences left, reinsert it.
                if (second[1] > 0) {
                    maxHeap.offer(second);
                }

                // Reinsert the first character back into the heap for later use.
                maxHeap.offer(first);
            } else {
                // Append the character since no triple repetition.
                result.append((char) first[0]);
                first[1]--;

                // If this character has more occurrences left, reinsert it.
                if (first[1] > 0) {
                    maxHeap.offer(first);
                }
            }
        }

        return result.toString();
    }

    /**
     * Main method for testing the longestDiverseString function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        System.out.println(solution.longestDiverseString(1, 1, 7)); // Expected output: "ccaccbcc"

        // Test case 2
        System.out.println(solution.longestDiverseString(2, 2, 1)); // Expected output: "aabbc"

        // Test case 3
        System.out.println(solution.longestDiverseString(7, 1, 0)); // Expected output: "aabaa"

        // Test case 4
        System.out.println(solution.longestDiverseString(0, 0, 0)); // Expected output: ""

        // Test case 5
        System.out.println(solution.longestDiverseString(3, 3, 3)); // Expected output: "aabbcc" or any permutation
    }
}
