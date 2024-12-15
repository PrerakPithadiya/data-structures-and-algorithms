
/**
 * LeetCode Problem: Maximum Average Pass Ratio
 *
 * Problem Description:
 * There is a school that has classes of students and metrics for the passing ratio of each class.
 * You are given a 2D integer array classes where classes[i] = [passi, totali]:
 * - passi: number of students who pass the class i
 * - totali: total number of students in class i
 * You are also given an integer extraStudents which denotes the number of extra students you can add.
 * You want to maximize the average pass ratio across all classes.
 *
 * Solution Approach:
 * 1. Use a max heap (PriorityQueue) to store classes based on improvement in pass ratio
 * 2. For each class, calculate potential improvement if we add one student
 * 3. Repeatedly add students to classes that give maximum improvement
 * 4. Finally calculate average pass ratio across all classes
 *
 * Time Complexity: O(E * log N) where E is extraStudents and N is number of classes
 * Space Complexity: O(N) for the priority queue
 */
import java.util.PriorityQueue;

class Solution {

    /**
     * Calculates the maximum average pass ratio after adding extra students
     * optimally
     *
     * @param classes 2D array where each inner array contains [pass_count,
     * total_count]
     * @param extraStudents number of additional students that can be added
     * @return maximum possible average pass ratio across all classes
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes based on the largest improvement
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Calculate the initial improvement for each class and add to the heap
        for (int[] c : classes) {
            int passi = c[0], totali = c[1];
            double improvement = calcImprovement(passi, totali);
            maxHeap.offer(new double[]{improvement, passi, totali});
        }

        // Assign extra students
        while (extraStudents > 0) {
            double[] top = maxHeap.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];

            // Update the class by adding one student
            passi++;
            totali++;
            extraStudents--;

            // Recalculate improvement and push back to heap
            double newImprovement = calcImprovement(passi, totali);
            maxHeap.offer(new double[]{newImprovement, passi, totali});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int passi = (int) top[1];
            int totali = (int) top[2];
            totalRatio += (double) passi / totali;
        }

        return totalRatio / classes.length;
    }

    /**
     * Calculates the improvement in pass ratio if one student is added to a
     * class
     *
     * @param passi current number of passing students
     * @param totali current total number of students
     * @return difference between new ratio and current ratio
     */
    private double calcImprovement(int passi, int totali) {
        double currentRatio = (double) passi / totali;
        double newRatio = (double) (passi + 1) / (totali + 1);
        return newRatio - currentRatio;
    }

    /**
     * Test cases for the maxAverageRatio method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.println("Test Case 1: " + solution.maxAverageRatio(classes1, extraStudents1));
        // Expected: 0.78333

        // Test Case 2: All classes already have 100% pass ratio
        int[][] classes2 = {{2, 2}, {4, 4}, {1, 1}};
        int extraStudents2 = 4;
        System.out.println("Test Case 2: " + solution.maxAverageRatio(classes2, extraStudents2));
        // Expected: 1.00000

        // Test Case 3: Single class
        int[][] classes3 = {{0, 1}};
        int extraStudents3 = 1;
        System.out.println("Test Case 3: " + solution.maxAverageRatio(classes3, extraStudents3));
        // Expected: 0.50000

        // Test Case 4: Large number of extra students
        int[][] classes4 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents4 = 10;
        System.out.println("Test Case 4: " + solution.maxAverageRatio(classes4, extraStudents4));
        // Expected: 0.96667
    }
}
