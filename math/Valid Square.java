
import java.util.HashSet;

/**
 * This class provides a solution to determine if four given points form a valid
 * square.
 */
class Solution {

    /**
     * Determines if the given four points form a valid square.
     *
     * @param p1 The coordinates of the first point as an array [x, y]
     * @param p2 The coordinates of the second point as an array [x, y]
     * @param p3 The coordinates of the third point as an array [x, y]
     * @param p4 The coordinates of the fourth point as an array [x, y]
     * @return true if the points form a valid square, false otherwise
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // Calculate all six pairwise squared distances
        int d1 = dist(p1, p2);
        int d2 = dist(p1, p3);
        int d3 = dist(p1, p4);
        int d4 = dist(p2, p3);
        int d5 = dist(p2, p4);
        int d6 = dist(p3, p4);

        // Use a set to collect unique distances
        HashSet<Integer> distances = new HashSet<>();
        distances.add(d1);
        distances.add(d2);
        distances.add(d3);
        distances.add(d4);
        distances.add(d5);
        distances.add(d6);

        // There should only be two unique distances (side and diagonal), and neither should be zero (zero would mean overlapping points)
        return distances.size() == 2 && !distances.contains(0);
    }

    /**
     * Calculates the squared distance between two points.
     *
     * @param p1 The coordinates of the first point as an array [x, y]
     * @param p2 The coordinates of the second point as an array [x, y]
     * @return The squared distance between the two points
     */
    private int dist(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }

    /**
     * Main method to run test cases for the validSquare method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Valid square
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println("Test case 1 (Valid square): " + solution.validSquare(p1, p2, p3, p4));

        // Test case 2: Invalid square (rectangle)
        int[] p5 = {0, 0};
        int[] p6 = {2, 1};
        int[] p7 = {2, 0};
        int[] p8 = {0, 1};
        System.out.println("Test case 2 (Invalid square - rectangle): " + solution.validSquare(p5, p6, p7, p8));

        // Test case 3: Invalid square (overlapping points)
        int[] p9 = {0, 0};
        int[] p10 = {0, 0};
        int[] p11 = {1, 1};
        int[] p12 = {1, 1};
        System.out.println("Test case 3 (Invalid square - overlapping points): " + solution.validSquare(p9, p10, p11, p12));
    }
}
