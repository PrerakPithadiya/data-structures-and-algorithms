class Solution {
  public static int trappedRainwater(int[] arr) {
        int n = arr.length, max = Integer.MIN_VALUE, trappedWater = 0;

        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }

        max = Integer.MIN_VALUE;

        int[] rightMax = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }

        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - arr[i]);
        }

        return trappedWater;
    }
}
