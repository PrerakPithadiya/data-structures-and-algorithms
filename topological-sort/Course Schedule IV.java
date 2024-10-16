
import java.util.*;

/**
 * Solution class for checking course prerequisites.
 */
class Solution {

    /**
     * Determines if courses are prerequisites for others based on given
     * prerequisites and queries.
     *
     * @param numCourses The total number of courses.
     * @param prerequisites Array of prerequisite pairs where prerequisites[i] =
     * [a, b] means 'a' is a prerequisite of 'b'.
     * @param queries Array of query pairs where queries[i] = [c, d] asks if 'c'
     * is a prerequisite of 'd'.
     * @return List of boolean values corresponding to each query.
     */
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 1: Set direct prerequisites
        for (int[] prerequisite : prerequisites) {
            reachable[prerequisite[0]][prerequisite[1]] = true;
        }

        // Step 2: Floyd-Warshall to compute the transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Answer each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }

    /**
     * Test cases for the checkIfPrerequisite method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        List<Boolean> result1 = solution.checkIfPrerequisite(numCourses1, prerequisites1, queries1);
        System.out.println("Test case 1 result: " + result1); // Expected: [false, true]

        // Test case 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        List<Boolean> result2 = solution.checkIfPrerequisite(numCourses2, prerequisites2, queries2);
        System.out.println("Test case 2 result: " + result2); // Expected: [false, false]

        // Test case 3
        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = {{1, 0}, {1, 2}};
        List<Boolean> result3 = solution.checkIfPrerequisite(numCourses3, prerequisites3, queries3);
        System.out.println("Test case 3 result: " + result3); // Expected: [true, true]
    }
}
