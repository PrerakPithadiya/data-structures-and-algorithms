
/**
 * Solution class for the Gas Station problem.
 * This class provides a method to determine if it's possible to complete a circular route
 * given the gas available at each station and the cost to travel between stations.
 */
class Solution {

    /**
     * Determines the starting gas station index from which a circular route can
     * be completed.
     *
     * @param gas An array of integers representing the amount of gas available
     * at each station.
     * @param cost An array of integers representing the cost of traveling from
     * each station to the next.
     * @return The index of the starting gas station if a circular route is
     * possible, -1 otherwise.
     *
     * Algorithm: 1. Initialize variables to track total gas, total cost,
     * current gas, and potential start station. 2. Iterate through all
     * stations, updating the variables. 3. If current gas becomes negative,
     * reset it and update the potential start station. 4. After the iteration,
     * check if total gas is sufficient for the entire journey.
     *
     * Time Complexity: O(n), where n is the number of gas stations. Space
     * Complexity: O(1), as we use only a constant amount of extra space.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0, currentGas = 0, startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas += gas[i] - cost[i];

            // If current gas goes negative, reset start station
            if (currentGas < 0) {
                startStation = i + 1;
                currentGas = 0;
            }
        }

        // Check if the total gas is enough to complete the circuit
        return totalGas >= totalCost ? startStation : -1;
    }

    /**
     * Main method to demonstrate the usage of the canCompleteCircuit method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Circular route is possible
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        System.out.println("Test case 1 - Start station: " + solution.canCompleteCircuit(gas1, cost1)); // Expected output: 3

        // Test case 2: Circular route is not possible
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println("Test case 2 - Start station: " + solution.canCompleteCircuit(gas2, cost2)); // Expected output: -1
    }
}
