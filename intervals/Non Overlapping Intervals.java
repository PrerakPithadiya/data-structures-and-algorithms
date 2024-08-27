
/**
 * This class provides a solution to the "Non-overlapping Intervals" problem.
 * The problem involves finding the minimum number of intervals to remove to make the remaining intervals non-overlapping.
 */
class Solution {

    /**
     * Calculates the minimum number of intervals to remove to make the
     * remaining intervals non-overlapping.
     *
     * @param intervals A 2D array where each inner array represents an interval
     * with a start and end time.
     * @return The minimum number of intervals that must be removed.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlapping interval, must remove one
                count++;
            } else {
                // No overlap, update the end time
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }

    /**
     * Main method to demonstrate the functionality of the Solution class. It
     * includes several test cases to verify the correctness of the
     * eraseOverlapIntervals method.
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Mixed intervals with some overlap
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Test Case 1 Result: " + solution.eraseOverlapIntervals(intervals1));
        // Expected: 1

        // Test case 2: Completely overlapping intervals
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println("Test Case 2 Result: " + solution.eraseOverlapIntervals(intervals2));
        // Expected: 2

        // Test case 3: Non-overlapping intervals
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println("Test Case 3 Result: " + solution.eraseOverlapIntervals(intervals3));
        // Expected: 0

        // Test case 4: Complex overlapping intervals
        int[][] intervals4 = {{1, 4}, {2, 3}, {3, 4}, {2, 5}};
        System.out.println("Test Case 4 Result: " + solution.eraseOverlapIntervals(intervals4));
        // Expected: 2

        // Test case 5: Non-overlapping intervals with negative values
        int[][] intervals5 = {{-10, -5}, {-9, -4}, {-8, -3}, {-7, -2}, {-6, -1}};
        System.out.println("Test Case 5 Result: " + solution.eraseOverlapIntervals(intervals5));
        // Expected: 0
    }
}
