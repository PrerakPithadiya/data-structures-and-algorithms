
import java.util.Arrays;

/**
 * This class provides a solution to the "Minimum Number of Arrows to Burst
 * Balloons" problem. The problem involves finding the minimum number of arrows
 * needed to burst all balloons. Each balloon is represented by a range of its
 * start and end coordinates on a number line.
 */
class Solution {

    /**
     * Finds the minimum number of arrows required to burst all balloons.
     *
     * @param points A 2D array where each sub-array represents a balloon's
     * start and end coordinates.
     * @return The minimum number of arrows needed to burst all balloons.
     */
    public int findMinArrowShots(int[][] points) {
        // Handle edge cases
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the points by their end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1; // Start with one arrow
        int end = points[0][1]; // Initialize end to the first balloon's end coordinate

        // Iterate through the sorted balloons
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow's end, we need a new arrow
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
            // If the current balloon overlaps with the previous one, no new arrow is needed
        }

        return arrows;
    }

    /**
     * Main method to run test cases for the findMinArrowShots method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Overlapping balloons
        int[][] points1 = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Test Case 1 Result: " + solution.findMinArrowShots(points1));
        // Expected: 2

        // Test case 2: Non-overlapping balloons
        int[][] points2 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println("Test Case 2 Result: " + solution.findMinArrowShots(points2));
        // Expected: 4

        // Test case 3: Partially overlapping balloons
        int[][] points3 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println("Test Case 3 Result: " + solution.findMinArrowShots(points3));
        // Expected: 2

        // Test case 4: One large balloon covering all others
        int[][] points4 = {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        System.out.println("Test Case 4 Result: " + solution.findMinArrowShots(points4));
        // Expected: 1

        // Test case 5: Non-overlapping balloons with gaps
        int[][] points5 = {{1, 5}, {6, 10}, {11, 15}, {16, 20}};
        System.out.println("Test Case 5 Result: " + solution.findMinArrowShots(points5));
        // Expected: 4
    }
}
