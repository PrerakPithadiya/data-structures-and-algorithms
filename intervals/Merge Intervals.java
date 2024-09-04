
import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class provides a solution for merging overlapping intervals.
 */
class Solution {

    /**
     * Merges overlapping intervals in the given array.
     *
     * @param intervals A 2D array where each inner array represents an interval
     * [start, end]
     * @return A 2D array of merged intervals
     */
    public int[][] merge(int[][] intervals) {
        // Edge case: if there are no intervals, return an empty array
        if (intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a LinkedList to hold the merged intervals
        LinkedList<int[]> merged = new LinkedList<>();

        // Iterate over the intervals
        for (int[] interval : intervals) {
            // If the merged list is empty or there's no overlap with the last interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Otherwise, there's overlap, so merge the current interval with the last one
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        // Convert the LinkedList to an array and return
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case with overlapping intervals
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result1 = solution.merge(intervals1);
        System.out.println("Test case 1 result: " + Arrays.deepToString(result1));
        // Expected output: [[1,6],[8,10],[15,18]]

        // Test case 2: All intervals overlap
        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] result2 = solution.merge(intervals2);
        System.out.println("Test case 2 result: " + Arrays.deepToString(result2));
        // Expected output: [[1,5]]

        // Test case 3: No overlapping intervals
        int[][] intervals3 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] result3 = solution.merge(intervals3);
        System.out.println("Test case 3 result: " + Arrays.deepToString(result3));
        // Expected output: [[1,2],[3,4],[5,6]]

        // Test case 4: Empty input
        int[][] intervals4 = {};
        int[][] result4 = solution.merge(intervals4);
        System.out.println("Test case 4 result: " + Arrays.deepToString(result4));
        // Expected output: []

        // Test case 5: Single interval
        int[][] intervals5 = {{1, 1}};
        int[][] result5 = solution.merge(intervals5);
        System.out.println("Test case 5 result: " + Arrays.deepToString(result5));
        // Expected output: [[1,1]]
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project provides a solution for merging overlapping
 * intervals. It includes a Solution class with a merge method that takes an
 * array of intervals and returns a new array with overlapping intervals merged.
 *
 * 2. Class Structure: - Solution: The main class containing the merge method
 * and test cases.
 *
 * 3. Key Methods: - merge(int[][] intervals): Merges overlapping intervals in
 * the input array. - main(String[] args): Contains test cases to demonstrate
 * the functionality of the merge method.
 *
 * 4. Algorithm: The merge method uses the following approach: a. Sort the
 * intervals based on their start times. b. Iterate through the sorted
 * intervals, merging overlapping ones. c. Use a LinkedList to store the merged
 * intervals for efficient insertion and deletion. d. Convert the final
 * LinkedList to a 2D array before returning.
 *
 * 5. Time Complexity: The time complexity of the merge method is O(n log n),
 * where n is the number of intervals. This is due to the initial sorting of the
 * intervals.
 *
 * 6. Space Complexity: The space complexity is O(n) in the worst case, where n
 * is the number of intervals. This occurs when no intervals overlap, and we
 * need to store all of them.
 *
 * 7. Test Cases: The main method includes five test cases covering various
 * scenarios: - Normal case with overlapping intervals - All intervals
 * overlapping - No overlapping intervals - Empty input - Single interval
 *
 * 8. Usage: To use this solution, create an instance of the Solution class and
 * call the merge method with your array of intervals. The method will return a
 * new array with merged intervals.
 *
 * 9. Future Improvements: - Add input validation to ensure the intervals are
 * valid (start <= end). - Implement error handling for invalid inputs. -
 * Consider using a more memory-efficient data structure for very large inputs.
 */
