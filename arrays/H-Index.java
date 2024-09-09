
import java.util.Arrays;

/**
 * This class provides a solution to calculate the h-index of a researcher based
 * on their citation counts. The h-index is defined as the maximum value h such
 * that the researcher has published h papers that have each been cited at least
 * h times.
 */
class Solution {

    /**
     * Calculates the h-index for a given array of citation counts.
     *
     * @param citations An array of integers representing the number of
     * citations for each paper.
     * @return The h-index of the researcher.
     */
    public int hIndex(int[] citations) {
        // Sort the citations in non-increasing order
        Arrays.sort(citations);

        int n = citations.length;

        // Iterate over the sorted array to find the h-index
        for (int i = 0; i < n; i++) {
            // Check if the current citation count is enough for the h-index
            if (citations[n - 1 - i] < i + 1) {
                return i;
            }
        }

        // If all papers have at least n citations, return n
        return n;
    }

    /**
     * Main method to demonstrate the usage of the hIndex method with example
     * inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("H-index for citations1: " + sol.hIndex(citations1));  // Output: 3

        // Example 2
        int[] citations2 = {1, 3, 1};
        System.out.println("H-index for citations2: " + sol.hIndex(citations2));  // Output: 1
    }
}
