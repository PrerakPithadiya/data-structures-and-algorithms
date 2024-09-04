import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Direction vectors for north, east, south, and west respectively.
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;  // Start facing north
        int x = 0, y = 0;  // Start position
        int maxDistSquared = 0;

        // Store obstacles as a set of strings for quick lookup.
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands) {
            if (command == -2) {
                // Turn left: move counterclockwise in the direction array
                directionIndex = (directionIndex + 3) % 4;
            } else if (command == -1) {
                // Turn right: move clockwise in the direction array
                directionIndex = (directionIndex + 1) % 4;
            } else {
                // Move forward 'command' steps in the current direction
                for (int step = 0; step < command; step++) {
                    int nextX = x + directions[directionIndex][0];
                    int nextY = y + directions[directionIndex][1];
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        // Calculate the squared distance from origin
                        maxDistSquared = Math.max(maxDistSquared, x * x + y * y);
                    } else {
                        // Stop moving if there's an obstacle
                        break;
                    }
                }
            }
        }
        return maxDistSquared;
    }
}
