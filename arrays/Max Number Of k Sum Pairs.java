import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for finding the maximum number of operations to make
 * sum-pairs.
 */
class Solution {
    /**
     * Finds the maximum number of operations that can be performed on the array.
     * An operation consists of choosing two numbers from the array whose sum equals
     * k,
     * and removing them from the array.
     *
     * @param nums The input array of integers.
     * @param k    The target sum for pairs.
     * @return The maximum number of operations that can be performed.
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int target = k - num;
            if (map.getOrDefault(target, 0) > 0) {
                // If we find the complement, perform the operation
                operations++;
                map.put(target, map.get(target) - 1);
            } else {
                // Otherwise, increment the count for the current number
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return operations;
    }

    /**
     * Main method to run example test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 1, 2, 3, 4 };
        int k1 = 5;
        System.out.println(solution.maxOperations(nums1, k1)); // Output: 2

        // Example 2
        int[] nums2 = { 3, 1, 3, 4, 3 };
        int k2 = 6;
        System.out.println(solution.maxOperations(nums2, k2)); // Output: 1
    }
}
