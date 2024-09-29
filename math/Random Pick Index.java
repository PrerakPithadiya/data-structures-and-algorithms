
import java.util.Random;

/**
 * This class implements a solution for randomly picking an index of a target
 * value in an array. It uses reservoir sampling to ensure each occurrence of
 * the target has an equal probability of being selected.
 */
class Solution {

    private final int[] nums;
    private final Random random;

    /**
     * Constructor initializes the object with the given array.
     *
     * @param nums The input array of integers.
     */
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Picks a random index where nums[i] == target.
     *
     * @param target The target value to search for in the array.
     * @return A randomly chosen index where nums[i] == target, or -1 if target
     * is not found.
     */
    public int pick(int target) {
        int chosen = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // Reservoir sampling: replace chosen with probability 1/count
                if (random.nextInt(count) == 0) {
                    chosen = i;
                }
            }
        }
        return chosen;
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     */
    public static void main(String[] args) {
        // Test case 1: Basic functionality
        int[] nums1 = {1, 2, 3, 3, 3};
        Solution solution1 = new Solution(nums1);
        System.out.println("Test case 1:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Random index for target 3: " + solution1.pick(3));
        }

        // Test case 2: Target not in array
        int[] nums2 = {1, 2, 4, 5, 6};
        Solution solution2 = new Solution(nums2);
        System.out.println("\nTest case 2:");
        System.out.println("Random index for target 3 (not in array): " + solution2.pick(3));

        // Test case 3: Array with single element
        int[] nums3 = {1};
        Solution solution3 = new Solution(nums3);
        System.out.println("\nTest case 3:");
        System.out.println("Random index for target 1: " + solution3.pick(1));

        // Test case 4: Empty array
        int[] nums4 = {};
        Solution solution4 = new Solution(nums4);
        System.out.println("\nTest case 4:");
        System.out.println("Random index for target 1 (empty array): " + solution4.pick(1));
    }
}
