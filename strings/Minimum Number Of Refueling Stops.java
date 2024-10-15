
import java.util.PriorityQueue;

/**
 * Solution class for the minimum number of refueling stops problem.
 */
class Solution {

    /**
     * Calculates the minimum number of refueling stops required to reach the
     * target.
     *
     * @param target The target distance to reach.
     * @param startFuel The initial amount of fuel in the car.
     * @param stations An array of refueling stations, where stations[i] =
     * [distance, fuel]. distance is the distance of the station from the
     * starting position, and fuel is the amount of fuel available at that
     * station.
     * @return The minimum number of refueling stops needed to reach the target,
     * or -1 if it's impossible.
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int currentFuel = startFuel;
        int stops = 0;
        int index = 0;
        int n = stations.length;

        // Process stations
        while (currentFuel < target) {
            // Add all reachable stations to the max-heap
            while (index < n && stations[index][0] <= currentFuel) {
                maxHeap.offer(stations[index][1]);
                index++;
            }

            // If there are no more stations to refuel and we can't reach the target
            if (maxHeap.isEmpty()) {
                return -1;
            }

            // Refuel from the station with maximum fuel
            currentFuel += maxHeap.poll();
            stops++;
        }

        return stops;
    }

    /**
     * Main method for testing the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int target1 = 1;
        int startFuel1 = 1;
        int[][] stations1 = {};
        System.out.println("Test case 1: " + solution.minRefuelStops(target1, startFuel1, stations1)); // Expected output: 0

        // Test case 2
        int target2 = 100;
        int startFuel2 = 1;
        int[][] stations2 = {{10, 100}};
        System.out.println("Test case 2: " + solution.minRefuelStops(target2, startFuel2, stations2)); // Expected output: -1

        // Test case 3
        int target3 = 100;
        int startFuel3 = 10;
        int[][] stations3 = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println("Test case 3: " + solution.minRefuelStops(target3, startFuel3, stations3)); // Expected output: 2

        // Test case 4
        int target4 = 1000;
        int startFuel4 = 83;
        int[][] stations4 = {{25, 27}, {36, 187}, {140, 186}, {378, 6}, {492, 202}, {517, 89}, {579, 234}, {673, 86}, {808, 53}, {954, 49}};
        System.out.println("Test case 4: " + solution.minRefuelStops(target4, startFuel4, stations4)); // Expected output: 5
    }
}
