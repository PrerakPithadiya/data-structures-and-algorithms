
/**
 * This class provides a solution to the "Daily Temperatures" problem.
 * The problem involves finding the number of days you have to wait until a warmer temperature
 * for each day in a given array of daily temperatures.
 */
import java.util.*;

class Solution {

    /**
     * Calculates the number of days until a warmer temperature for each day.
     *
     * @param temperatures An array of daily temperatures
     * @return An array where each element represents the number of days until a
     * warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        // Remaining elements in the stack do not have a warmer day
        while (!stack.isEmpty()) {
            answer[stack.pop()] = 0;
        }

        return answer;
    }

    /**
     * Main method to demonstrate the usage of the dailyTemperatures method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);

        System.out.println("Input temperatures: " + Arrays.toString(temperatures));
        System.out.println("Days until warmer temperature: " + Arrays.toString(result));
    }
}
