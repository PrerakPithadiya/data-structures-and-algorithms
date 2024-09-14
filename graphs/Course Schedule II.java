
import java.util.*;

/**
 * Solution class for finding the order of courses to take based on
 * prerequisites.
 */
class Solution {

    /**
     * Finds the order in which courses should be taken based on their
     * prerequisites.
     *
     * @param numCourses The total number of courses.
     * @param prerequisites An array of prerequisite pairs where
     * prerequisites[i] = [ai, bi] indicates that course bi must be taken before
     * course ai.
     * @return An array representing the order in which courses should be taken,
     * or an empty array if it's impossible to finish all courses.
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // In-degree array to track prerequisites
        int[] indegree = new int[numCourses];

        // Build the graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            adjList.get(prereqCourse).add(course);
            indegree[course]++;
        }

        // Queue for courses with no prerequisites (in-degree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // List to store the topological order of courses
        List<Integer> order = new ArrayList<>();

        // Process the courses
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order.add(course);

            // Decrease the in-degree of dependent courses
            for (int dependentCourse : adjList.get(course)) {
                indegree[dependentCourse]--;
                // If in-degree becomes 0, add it to the queue
                if (indegree[dependentCourse] == 0) {
                    queue.add(dependentCourse);
                }
            }
        }

        // If all courses are processed, return the order
        if (order.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = order.get(i);
            }
            return result;
        } else {
            // If there's a cycle, return an empty array
            return new int[0];
        }
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple case with 2 courses
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[] result1 = solution.findOrder(numCourses1, prerequisites1);
        System.out.println("Test case 1 result: " + Arrays.toString(result1));

        // Test case 2: Case with 4 courses and multiple prerequisites
        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result2 = solution.findOrder(numCourses2, prerequisites2);
        System.out.println("Test case 2 result: " + Arrays.toString(result2));

        // Test case 3: Case with a cycle (impossible to complete all courses)
        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 0}, {0, 2}, {2, 1}};
        int[] result3 = solution.findOrder(numCourses3, prerequisites3);
        System.out.println("Test case 3 result: " + Arrays.toString(result3));

        // Test case 4: Case with no prerequisites
        int numCourses4 = 3;
        int[][] prerequisites4 = {};
        int[] result4 = solution.findOrder(numCourses4, prerequisites4);
        System.out.println("Test case 4 result: " + Arrays.toString(result4));
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * findOrder method with the number of courses and prerequisites array. 3. The
 * method will return an array representing the order of courses to take. 4. If
 * it's impossible to finish all courses due to a cycle, an empty array will be
 * returned.
 *
 * Example: Solution solution = new Solution(); int numCourses = 4; int[][]
 * prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}}; int[] result =
 * solution.findOrder(numCourses, prerequisites);
 *
 * Design and Implementation: - The solution uses a topological sorting
 * algorithm based on Kahn's algorithm. - It builds an adjacency list to
 * represent the graph of course dependencies. - An in-degree array is used to
 * keep track of the number of prerequisites for each course. - A queue is used
 * to process courses with no remaining prerequisites. - The algorithm processes
 * courses in topological order, removing dependencies as it goes. - If all
 * courses are processed, it returns the order. Otherwise, it detects a cycle
 * and returns an empty array. - Time Complexity: O(V + E), where V is the
 * number of courses and E is the number of prerequisites. - Space Complexity:
 * O(V + E) for the adjacency list and queue.
 */
