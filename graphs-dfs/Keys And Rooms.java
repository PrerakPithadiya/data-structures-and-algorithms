
/**
 * This class provides a solution to the "Keys and Rooms" problem.
 * The problem involves determining if all rooms in a set of rooms can be visited,
 * given that each room may contain keys to other rooms.
 */
import java.util.*;

class Solution {

    /**
     * Determines if all rooms can be visited starting from room 0.
     *
     * @param rooms A list of lists where each inner list represents the keys in
     * a room. The index of the outer list represents the room number.
     * @return true if all rooms can be visited, false otherwise.
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start from room 0
        visited[0] = true;

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        // Check if all rooms are visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method to demonstrate the functionality of the canVisitAllRooms
     * method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: All rooms can be visited
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));
        rooms1.add(Arrays.asList(2));
        rooms1.add(Arrays.asList(3));
        rooms1.add(new ArrayList<>());
        System.out.println("Example 1 result: " + solution.canVisitAllRooms(rooms1)); // Output: true

        // Example 2: Not all rooms can be visited
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));
        System.out.println("Example 2 result: " + solution.canVisitAllRooms(rooms2)); // Output: false
    }
}
