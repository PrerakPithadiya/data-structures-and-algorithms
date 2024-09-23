package bitmask;

/**
 * This class provides a solution to the Maximum Compatibility Score Sum
 * problem.
 * It uses a backtracking approach to find the maximum sum of compatibility
 * scores
 * between students and mentors.
 */
class Solution {
    /**
     * Calculates the maximum compatibility score sum for given students and
     * mentors.
     *
     * @param students 2D array representing students' answers
     * @param mentors  2D array representing mentors' answers
     * @return the maximum compatibility score sum
     */
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int[][] compatibility = new int[m][m];

        // Precompute the compatibility score for each student-mentor pair
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                compatibility[i][j] = calculateCompatibility(students[i], mentors[j]);
            }
        }

        boolean[] used = new boolean[m];
        return backtrack(compatibility, used, 0, m);
    }

    /**
     * Calculates the compatibility score between a student and a mentor.
     *
     * @param student array representing a student's answers
     * @param mentor  array representing a mentor's answers
     * @return the compatibility score
     */
    private int calculateCompatibility(int[] student, int[] mentor) {
        int score = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) {
                score++;
            }
        }
        return score;
    }

    /**
     * Performs backtracking to assign students to mentors and maximize the
     * compatibility score.
     *
     * @param compatibility 2D array of precomputed compatibility scores
     * @param used          boolean array to track used mentors
     * @param studentIndex  current student index
     * @param m             total number of students/mentors
     * @return the maximum compatibility score sum for the current state
     */
    private int backtrack(int[][] compatibility, boolean[] used, int studentIndex, int m) {
        if (studentIndex == m) {
            return 0; // All students are assigned
        }

        int maxScore = 0;
        // Try assigning current student to each mentor who hasn't been used yet
        for (int mentorIndex = 0; mentorIndex < m; mentorIndex++) {
            if (!used[mentorIndex]) {
                used[mentorIndex] = true;
                int currentScore = compatibility[studentIndex][mentorIndex]
                        + backtrack(compatibility, used, studentIndex + 1, m);
                maxScore = Math.max(maxScore, currentScore);
                used[mentorIndex] = false; // Backtrack
            }
        }

        return maxScore;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] students1 = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 1 } };
        int[][] mentors1 = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };
        System.out.println("Test case 1 result: " + solution.maxCompatibilitySum(students1, mentors1));
        // Expected output: 8

        // Test case 2
        int[][] students2 = { { 0, 0 }, { 0, 0 }, { 0, 0 } };
        int[][] mentors2 = { { 1, 1 }, { 1, 1 }, { 1, 1 } };
        System.out.println("Test case 2 result: " + solution.maxCompatibilitySum(students2, mentors2));
        // Expected output: 0

        // Test case 3
        int[][] students3 = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 1, 0 } };
        int[][] mentors3 = { { 1, 0, 1 }, { 0, 1, 1 }, { 0, 1, 0 }, { 1, 1, 0 } };
        System.out.println("Test case 3 result: " + solution.maxCompatibilitySum(students3, mentors3));
        // Expected output: 10
    }
}
