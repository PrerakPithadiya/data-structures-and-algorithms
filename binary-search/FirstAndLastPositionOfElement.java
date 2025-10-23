
public class FirstAndLastPositionOfElement {

    public static int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private static int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }

    // Test cases
    public static void main(String[] args) {
        int[][] testArrays = {
            {5, 7, 7, 8, 8, 10},
            {5, 7, 7, 8, 8, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9},
            {2, 2, 2, 2, 2},
            {}
        };
        int[] targets = {8, 6, 4, 2, 1};
        int[][] expected = {
            {3, 4}, {-1, -1}, {3, 3}, {0, 4}, {-1, -1}
        };
        for (int i = 0; i < testArrays.length; i++) {
            int[] result = searchRange(testArrays[i], targets[i]);
            System.out.println("Test " + (i + 1) + ": " + java.util.Arrays.toString(result) + " Expected: " + java.util.Arrays.toString(expected[i]));
        }
    }
}
