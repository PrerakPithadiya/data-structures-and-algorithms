
import java.util.ArrayList;
import java.util.List;

/**
 * Solution class for inserting and merging intervals.
 */
class Solution {

    /**
     * Inserts a new interval into a sorted list of intervals and merges
     * overlapping intervals.
     *
     * @param intervals A sorted array of intervals where each interval is
     * represented as an integer array of size 2.
     * @param newInterval The new interval to be inserted.
     * @return A new array of intervals after inserting the new interval and
     * merging overlapping intervals.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge intervals that overlap with the newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals after the newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result list to an array
        return result.toArray(new int[result.size()][]);
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = solution.insert(intervals1, newInterval1);
        System.out.println("Test case 1 result:");
        printIntervals(result1);

        // Test case 2
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = solution.insert(intervals2, newInterval2);
        System.out.println("Test case 2 result:");
        printIntervals(result2);

        // Test case 3 (empty intervals)
        int[][] intervals3 = {};
        int[] newInterval3 = {5, 7};
        int[][] result3 = solution.insert(intervals3, newInterval3);
        System.out.println("Test case 3 result:");
        printIntervals(result3);
    }

    /**
     * Helper method to print intervals.
     *
     * @param intervals Array of intervals to be printed.
     */
    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }
}

/**
 * Project Documentation
 *
 * 1. Overview: This project provides a solution for inserting a new interval
 * into a sorted list of non-overlapping intervals and merging any overlapping
 * intervals. The main class, Solution, contains the insert method that performs
 * this operation efficiently.
 *
 * 2. Classes: - Solution: Contains the main logic for inserting and merging
 * intervals.
 *
 * 3. Methods: - insert(int[][] intervals, int[] newInterval): Inserts a new
 * interval and merges overlapping ones. - main(String[] args): Runs test cases
 * to demonstrate the functionality of the insert method. -
 * printIntervals(int[][] intervals): Helper method to print intervals for
 * testing purposes.
 *
 * 4. Algorithm: The insert method uses a three-step approach: a. Add all
 * intervals that come before the new interval. b. Merge overlapping intervals
 * with the new interval. c. Add all remaining intervals after the merged
 * interval.
 *
 * 5. Time Complexity: The algorithm has a time complexity of O(n), where n is
 * the number of intervals in the input array.
 *
 * 6. Space Complexity: The space complexity is O(n) in the worst case, where n
 * is the number of intervals in the result.
 *
 * 7. Usage: To use this solution, create an instance of the Solution class and
 * call the insert method with your intervals array and new interval. The method
 * will return a new array with the merged intervals.
 *
 * 8. Testing: The main method includes three test cases to demonstrate the
 * functionality of the insert method: - Test case 1: Inserting an overlapping
 * interval - Test case 2: Inserting an interval that overlaps with multiple
 * existing intervals - Test case 3: Inserting an interval into an empty list of
 * intervals
 *
 * 9. Future Improvements: - Add more comprehensive error handling and input
 * validation. - Implement unit tests for better code coverage and reliability.
 * - Optimize memory usage by modifying the input array in-place if possible.
 */
