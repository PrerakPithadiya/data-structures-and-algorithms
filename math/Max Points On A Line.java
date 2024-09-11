
/**
 * Solution class for finding the maximum number of points that lie on the same straight line.
 */
class Solution {

    /**
     * Finds the maximum number of points that lie on the same straight line.
     *
     * @param points A 2D array representing the coordinates of points. Each
     * inner array contains two integers [x, y].
     * @return The maximum number of points that lie on the same straight line.
     */
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }

        int maxPointsOnLine = 1;

        for (int i = 0; i < points.length; i++) {
            // HashMap to store the count of points for each slope
            HashMap<String, Integer> slopeCount = new HashMap<>();
            int duplicatePoints = 0;
            int currentMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    // Points are the same
                    duplicatePoints++;
                    continue;
                }

                int gcd = gcd(dx, dy); // Reduce the slope (dy/dx) to its simplest form
                dx /= gcd;
                dy /= gcd;

                // Ensure that the slope's sign is normalized (dy should be positive)
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = Math.abs(dy); // Handle the vertical line case
                }

                String slope = dx + "/" + dy;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeCount.get(slope));
            }

            maxPointsOnLine = Math.max(maxPointsOnLine, currentMax + duplicatePoints + 1); // Include the current point
        }

        return maxPointsOnLine;
    }

    /**
     * Helper function to calculate the greatest common divisor (GCD) using the
     * Euclidean algorithm.
     *
     * @param a First integer
     * @param b Second integer
     * @return The greatest common divisor of a and b
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(solution.maxPoints(points1)); // Output: 3

        // Example 2
        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(solution.maxPoints(points2)); // Output: 4
    }
}

/**
 * This class solves the "Max Points on a Line" problem.
 *
 * Problem Description: Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane, return the maximum number of points that
 * lie on the same straight line.
 *
 * Algorithm: 1. If there are less than 3 points, return the number of points.
 * 2. Iterate through each point as a reference point. 3. For each reference
 * point, calculate the slope with every other point. 4. Use a HashMap to count
 * the number of points with the same slope. 5. Keep track of duplicate points
 * and the maximum count for each slope. 6. Update the overall maximum number of
 * points on a line. 7. Return the maximum number of points found.
 *
 * Time Complexity: O(n^2), where n is the number of points. Space Complexity:
 * O(n) for the HashMap storing slope counts.
 *
 * Usage: 1. Create an instance of the Solution class. 2. Call the maxPoints
 * method with a 2D array of points. 3. The method will return the maximum
 * number of points on the same line.
 *
 * Example: Solution solution = new Solution(); int[][] points = {{1, 1}, {2,
 * 2}, {3, 3}}; int result = solution.maxPoints(points);
 * System.out.println(result); // Output: 3
 */
