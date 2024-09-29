
import java.util.Arrays;
import java.util.Random;

/**
 * This class implements a solution for shuffling an array of integers. It
 * provides methods to reset the array to its original configuration and to
 * shuffle it randomly.
 */
class Solution {

    private final int[] original;
    private int[] array;
    private final Random random;

    /**
     * Constructor initializes the object with the integer array nums.
     *
     * @param nums The input array of integers to be shuffled.
     */
    public Solution(int[] nums) {
        original = nums.clone(); // Store the original configuration
        array = nums.clone(); // Create a working copy of the array
        random = new Random(); // Random number generator
    }

    /**
     * Resets the array to its original configuration and returns it.
     *
     * @return The array in its original configuration.
     */
    public int[] reset() {
        array = original.clone(); // Reset the array to the original configuration
        return array;
    }

    /**
     * Returns a random shuffling of the array using the Fisher-Yates algorithm.
     *
     * @return The shuffled array.
     */
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Pick a random index from 0 to i
            swap(array, i, j); // Swap the current element with the randomly chosen one
        }
        return array;
    }

    /**
     * Helper method to swap elements at two indices in the array.
     *
     * @param array The array in which elements are to be swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Main method to demonstrate the usage of the Solution class.
     */
    public static void main(String[] args) {
        // Test case 1: Basic functionality
        int[] nums1 = {1, 2, 3};
        Solution solution1 = new Solution(nums1);
        System.out.println("Original: " + Arrays.toString(nums1));
        System.out.println("Shuffled: " + Arrays.toString(solution1.shuffle()));
        System.out.println("Reset: " + Arrays.toString(solution1.reset()));

        // Test case 2: Empty array
        int[] nums2 = {};
        Solution solution2 = new Solution(nums2);
        System.out.println("\nOriginal: " + Arrays.toString(nums2));
        System.out.println("Shuffled: " + Arrays.toString(solution2.shuffle()));
        System.out.println("Reset: " + Arrays.toString(solution2.reset()));

        // Test case 3: Array with one element
        int[] nums3 = {42};
        Solution solution3 = new Solution(nums3);
        System.out.println("\nOriginal: " + Arrays.toString(nums3));
        System.out.println("Shuffled: " + Arrays.toString(solution3.shuffle()));
        System.out.println("Reset: " + Arrays.toString(solution3.reset()));

        // Test case 4: Large array
        int[] nums4 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums4[i] = i;
        }
        Solution solution4 = new Solution(nums4);
        System.out.println("\nOriginal (first 10 elements): " + Arrays.toString(Arrays.copyOf(nums4, 10)));
        int[] shuffled4 = solution4.shuffle();
        System.out.println("Shuffled (first 10 elements): " + Arrays.toString(Arrays.copyOf(shuffled4, 10)));
        int[] reset4 = solution4.reset();
        System.out.println("Reset (first 10 elements): " + Arrays.toString(Arrays.copyOf(reset4, 10)));
    }
}
