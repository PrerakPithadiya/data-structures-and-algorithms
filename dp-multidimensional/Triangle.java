
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the Triangle problem. The problem involves
 * finding the minimum path sum from top to bottom in a triangle of numbers.
 */
class Solution {

    /**
     * Calculates the minimum path sum from top to bottom of the given triangle.
     *
     * @param triangle A List of Lists representing the triangle of numbers.
     * @return The minimum path sum from top to bottom.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Start from the second last row and move upwards
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                // Update each element to be the sum of itself and the minimum of the two elements below
                int below = triangle.get(row + 1).get(col);
                int belowRight = triangle.get(row + 1).get(col + 1);
                int minSum = triangle.get(row).get(col) + Math.min(below, belowRight);
                triangle.get(row).set(col, minSum);
            }
        }

        // The top element now contains the minimum path sum
        return triangle.get(0).get(0);
    }

    /**
     * Main method to demonstrate the usage of the Solution class. It includes
     * three test cases to verify the correctness of the minimumTotal method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: A triangle with multiple rows
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(List.of(2));
        triangle1.add(List.of(3, 4));
        triangle1.add(List.of(6, 5, 7));
        triangle1.add(List.of(4, 1, 8, 3));
        System.out.println("Test case 1 result: " + solution.minimumTotal(triangle1));

        // Test case 2: A triangle with only one element
        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(List.of(-10));
        System.out.println("Test case 2 result: " + solution.minimumTotal(triangle2));

        // Test case 3: A triangle with three rows
        List<List<Integer>> triangle3 = new ArrayList<>();
        triangle3.add(List.of(1));
        triangle3.add(List.of(2, 3));
        triangle3.add(List.of(4, 5, 6));
        System.out.println("Test case 3 result: " + solution.minimumTotal(triangle3));
    }
}
