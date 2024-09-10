
import java.util.HashMap;

/**
 * This class provides a solution to the "Contains Duplicate II" problem. The
 * problem is to determine if an array contains two distinct indices i and j
 * such that nums[i] == nums[j] and the absolute difference between i and j is
 * at most k.
 */
class Solution {

    /**
     * Checks if the given array contains nearby duplicate elements.
     *
     * @param nums The input array of integers.
     * @param k The maximum distance between two duplicate elements.
     * @return true if nearby duplicates exist, false otherwise.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store the value and its most recent index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number already exists in the map
            if (map.containsKey(nums[i])) {
                // If the difference between indices is less than or equal to k, return true
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // Update the map with the current index of the number
            map.put(nums[i], i);
        }

        // If no such pair is found, return false
        return false;
    }

    /**
     * Main method to demonstrate the usage of the containsNearbyDuplicate
     * method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(solution.containsNearbyDuplicate(nums1, k1)); // Expected output: true

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(solution.containsNearbyDuplicate(nums2, k2)); // Expected output: true

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(solution.containsNearbyDuplicate(nums3, k3)); // Expected output: false
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * containsNearbyDuplicate method with an integer array and a value for k. 3.
 * The method will return true if nearby duplicates exist, false otherwise.
 *
 * Example: Solution solution = new Solution(); int[] nums = {1, 2, 3, 1}; int k
 * = 3; boolean result = solution.containsNearbyDuplicate(nums, k);
 *
 * Time Complexity: O(n), where n is the length of the input array. Space
 * Complexity: O(min(n, k)), as the HashMap will store at most min(n, k)
 * elements.
 */
