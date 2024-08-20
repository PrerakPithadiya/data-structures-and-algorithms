/**
 * Solution class containing the trappedRainwater method.
 */
class Solution {
    /**
     * Calculates the amount of rainwater that can be trapped between the bars
     * represented by the input array.
     *
     * @param arr An array of integers representing the height of bars.
     * @return The total amount of rainwater that can be trapped.
     */
    public static int trappedRainwater(int[] arr) {
        int n = arr.length, max = Integer.MIN_VALUE, trappedWater = 0;

        // Calculate the maximum height to the left of each bar
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;

        // Calculate the maximum height to the right of each bar
        int[] rightMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }

        // Calculate the trapped water for each bar
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - arr[i]);
        }

        return trappedWater;
    }
}
