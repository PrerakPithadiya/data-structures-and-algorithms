
import java.util.*;

/**
 * Solution for Valid Arrangement of Pairs problem Given a list of pairs of
 * integers, find a valid arrangement such that for each pair [i, j], the next
 * pair in the arrangement must begin with j. Time Complexity: O(E) where E is
 * the number of pairs/edges Space Complexity: O(V + E) where V is the number of
 * unique vertices
 */
class Solution {

    /**
     * Finds a valid arrangement of pairs using Hierholzer's algorithm for
     * Eulerian path
     *
     * @param pairs Array of integer pairs where each pair represents a directed
     * edge
     * @return Array of pairs representing valid arrangement
     */
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph and track in/out degrees
        Map<Integer, Queue<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new LinkedList<>()).offer(end);
            outdegree.put(start, outdegree.getOrDefault(start, 0) + 1);
            indegree.put(end, indegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find the starting node
        int startNode = pairs[0][0]; // Default start
        for (int node : graph.keySet()) {
            int out = outdegree.getOrDefault(node, 0);
            int in = indegree.getOrDefault(node, 0);
            if (out > in) {
                startNode = node;
                break;
            }
        }

        // Step 3: Perform Hierholzer's algorithm
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                // Traverse the next edge
                stack.push(graph.get(node).poll());
            } else {
                // Backtrack and add to result
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        // Step 4: Convert result to array and return
        Collections.reverse(result); // Reverse to get the correct order
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple path
        int[][] test1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        System.out.println("Test Case 1:");
        printResult(solution.validArrangement(test1));
        // Expected: [[11,9], [9,4], [4,5], [5,1]]

        // Test Case 2: Cycle
        int[][] test2 = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println("\nTest Case 2:");
        printResult(solution.validArrangement(test2));
        // Expected: [[3,1], [1,2], [2,3]] or any valid cyclic arrangement

        // Test Case 3: Single pair
        int[][] test3 = {{1, 2}};
        System.out.println("\nTest Case 3:");
        printResult(solution.validArrangement(test3));
        // Expected: [[1,2]]
    }

    private static void printResult(int[][] result) {
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(result[i]));
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
