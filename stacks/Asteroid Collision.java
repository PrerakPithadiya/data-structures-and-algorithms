
import java.util.Stack;

/**
 * Solution class for solving the Asteroid Collision problem.
 */
class Solution {

    /**
     * Simulates the collision of asteroids and returns the final state.
     *
     * @param asteroids An array of integers representing asteroids. Positive
     * integers represent asteroids moving right, negative integers represent
     * asteroids moving left.
     * @return An array of integers representing the state of asteroids after
     * all collisions.
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean isDestroyed = false;

            // Handle collisions
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop();  // destroy the top of the stack
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop();  // both are destroyed
                    isDestroyed = true;
                    break;
                } else {
                    isDestroyed = true;  // current asteroid is destroyed
                    break;
                }
            }

            // Add asteroid to stack if not destroyed
            if (!isDestroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to an array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
