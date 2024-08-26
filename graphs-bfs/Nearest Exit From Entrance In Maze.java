
/**
 * Solution class for finding the nearest exit from an entrance in a maze.
 */
class Solution {

    /**
     * Finds the nearest exit from the entrance in a maze.
     *
     * @param maze A 2D character array representing the maze. '.' represents
     * empty cells, '+' represents walls.
     * @param entrance An integer array of length 2 representing the entrance
     * coordinates [row, col].
     * @return The minimum number of steps to reach an exit, or -1 if no exit is
     * reachable.
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        // Directions for up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+'; // Mark entrance as visited

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int steps = current[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check if the new position is within bounds and not a wall
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                    // Check if it's an exit
                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                        return steps + 1;
                    }
                    // Mark the cell as visited and add it to the queue
                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        return -1; // No exit found
    }

    /**
     * Main method to demonstrate the usage of the nearestExit method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        char[][] maze1 = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance1 = {1, 2};
        System.out.println("Test case 1 result: " + solution.nearestExit(maze1, entrance1)); // Expected output: 1

        // Test case 2
        char[][] maze2 = {
            {'+', '+', '+'},
            {'.', '.', '.'},
            {'+', '+', '+'}
        };
        int[] entrance2 = {1, 0};
        System.out.println("Test case 2 result: " + solution.nearestExit(maze2, entrance2)); // Expected output: 2

        // Test case 3
        char[][] maze3 = {
            {'.', '+'}
        };
        int[] entrance3 = {0, 0};
        System.out.println("Test case 3 result: " + solution.nearestExit(maze3, entrance3)); // Expected output: -1
    }
}
