
import java.util.HashMap;

/**
 * This class provides a solution to the "Two Sum" problem. Given an array of
 * integers and a target sum, it finds two numbers in the array that add up to
 * the target sum and returns their indices.
 */
class Solution {

    /**
     * Finds two numbers in the given array that add up to the target sum.
     *
     * @param nums An array of integers to search through.
     * @param target The target sum to find.
     * @return An array of two integers representing the indices of the two
     * numbers that add up to the target sum.
     * @throws IllegalArgumentException if no solution is found.
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices of the current number and the complement
                return new int[]{map.get(complement), i};
            }

            // If complement is not found, store the number and its index in the map
            map.put(nums[i], i);
        }

        // This line will never be reached because the problem guarantees that exactly one solution exists
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Main method to demonstrate the usage of the twoSum method with test
     * cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println(result1[0] + ", " + result1[1]); // Expected output: 0, 1

        // Test case 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println(result2[0] + ", " + result2[1]); // Expected output: 1, 2

        // Test case 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println(result3[0] + ", " + result3[1]); // Expected output: 0, 1
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * twoSum method with an array of integers and a target sum. 3. The method will
 * return an array of two integers representing the indices of the two numbers
 * that add up to the target sum.
 *
 * Example: Solution solution = new Solution(); int[] nums = {2, 7, 11, 15}; int
 * target = 9; int[] result = solution.twoSum(nums, target);
 * System.out.println(result[0] + ", " + result[1]);
 *
 * Design and Implementation: - The solution uses a HashMap to store each number
 * and its index as we iterate through the array. - For each number, we
 * calculate its complement (target - current number) and check if it exists in
 * the HashMap. - If the complement is found, we have our solution, and we
 * return the indices of the current number and its complement. - If not found,
 * we add the current number and its index to the HashMap and continue
 * iterating. - This approach allows for O(n) time complexity and O(n) space
 * complexity.
 */
