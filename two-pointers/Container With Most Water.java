
/**
 * Container With Most Water
 *
 * This class provides a solution to the "Container With Most Water" problem.
 * The problem involves finding two lines that together with the x-axis forms a container,
 * such that the container contains the most water.
 */
class Solution {

    /**
     * Calculates the maximum area of water that can be contained.
     *
     * @param height An array of integers where each integer represents the
     * height of a vertical line.
     * @return The maximum area of water that can be contained.
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Main method to run test cases for the Container With Most Water problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: General case with multiple heights
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test case 1: " + solution.maxArea(height1)); // Expected output: 49

        // Test case 2: Minimum case with only two heights
        int[] height2 = {1, 1};
        System.out.println("Test case 2: " + solution.maxArea(height2)); // Expected output: 1

        // Test case 3: Case with repeated maximum heights
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Test case 3: " + solution.maxArea(height3)); // Expected output: 16

        // Test case 4: Case with a peak in the middle
        int[] height4 = {1, 2, 1};
        System.out.println("Test case 4: " + solution.maxArea(height4)); // Expected output: 2
    }
}
