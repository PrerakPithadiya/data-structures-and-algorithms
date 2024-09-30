
/**
 * Solution class for constructing a rectangle with a given area.
 */
class Solution {

    /**
     * Constructs a rectangle with the given area, returning its length and
     * width.
     *
     * @param area The area of the rectangle to be constructed.
     * @return An array of two integers [L, W] where L is the length and W is
     * the width.
     */
    public int[] constructRectangle(int area) {
        // Start from the square root of the area
        int w = (int) Math.sqrt(area);

        // Find the largest width 'w' such that w divides the area
        while (area % w != 0) {
            w--;
        }

        // L is area / W
        int l = area / w;

        // Return the result as [L, W]
        return new int[]{l, w};
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int area1 = 4;
        int[] result1 = solution.constructRectangle(area1);
        System.out.println("Test case 1 - Area: " + area1);
        System.out.println("Result: [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2
        int area2 = 37;
        int[] result2 = solution.constructRectangle(area2);
        System.out.println("Test case 2 - Area: " + area2);
        System.out.println("Result: [" + result2[0] + ", " + result2[1] + "]");

        // Test case 3
        int area3 = 122122;
        int[] result3 = solution.constructRectangle(area3);
        System.out.println("Test case 3 - Area: " + area3);
        System.out.println("Result: [" + result3[0] + ", " + result3[1] + "]");
    }
}

/*
     * Usage Instructions:
     * 1. Instantiate the Solution class.
     * 2. Call the constructRectangle method with the desired area as the argument.
     * 3. The method will return an array of two integers [L, W] representing the length and width.
     *
     * Design and Implementation:
     * - The algorithm starts with the square root of the area as the initial width.
     * - It then decrements the width until it finds a value that evenly divides the area.
     * - The length is calculated by dividing the area by the width.
     * - This approach ensures that the difference between length and width is minimized,
     *   and that length is always greater than or equal to width.
     *
     * Time Complexity: O(√n), where n is the input area.
     * Space Complexity: O(1), as it uses only a constant amount of extra space.
 */
