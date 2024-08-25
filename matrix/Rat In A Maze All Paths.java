
/**
 * This class solves the "Rat in a Maze" problem, finding all possible paths
 * from the top-left corner to the bottom-right corner of a maze.
 */
import java.util.ArrayList;
import java.util.Scanner;

class Main {

    /**
     * Recursively finds all possible paths through the maze.
     *
     * @param maze The input maze represented as a 2D array. 1 indicates a valid
     * cell, 0 indicates a blocked cell.
     * @param path The current path being explored, represented as a 2D array.
     * @param x The current x-coordinate in the maze.
     * @param y The current y-coordinate in the maze.
     * @param N The size of the maze (N x N).
     */
    private static void findPaths(int[][] maze, int[][] path, int x, int y, int N) {
        // Base case: if the rat has reached the bottom-right corner
        if (x == N - 1 && y == N - 1) {
            path[x][y] = 1;
            printPath(path, N);
            return;
        }

        // Check if maze[x][y] is valid
        if (x < 0 || x >= N || y < 0 || y >= N || maze[x][y] == 0) {
            return;
        }

        // Mark the cell as part of the path
        path[x][y] = 1;

        // Explore all four directions (down, up, right, left)
        // Move down
        findPaths(maze, path, x + 1, y, N);
        // Move right
        findPaths(maze, path, x, y + 1, N);
        // Move up
        findPaths(maze, path, x - 1, y, N);
        // Move left
        findPaths(maze, path, x, y - 1, N);

        // Backtrack: unmark the cell as part of the path
        path[x][y] = 0;
    }

    /**
     * Prints the current path found in the maze.
     *
     * @param path The current path represented as a 2D array.
     * @param N The size of the maze (N x N).
     */
    private static void printPath(int[][] path, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.add(path[i][j]);
            }
        }
        System.out.println(result);
    }

    /**
     * The main method that reads the input, initializes the maze, and starts
     * the path-finding process.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // Read the size of the maze
            int N = sc.nextInt();
            int[][] maze = new int[N][N];

            // Read the maze configuration
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }

            // Initialize the path array and start finding paths
            int[][] path = new int[N][N];
            findPaths(maze, path, 0, 0, N);
        }
    }
}
