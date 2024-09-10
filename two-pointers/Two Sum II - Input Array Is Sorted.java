
/**
 * Solution class for the "Two Sum II - Input Array Is Sorted" problem.
 * This class provides a method to find two numbers in a sorted array that add up to a specific target.
 */
class Solution {

    /**
     * Finds two numbers in the given sorted array that add up to the target
     * sum.
     *
     * @param numbers The input array of integers, sorted in ascending order.
     * @param target The target sum to find.
     * @return An array of two integers representing the 1-based indices of the
     * two numbers that add up to the target.
     * @throws IllegalArgumentException if no solution is found (although the
     * problem guarantees a solution).
     *
     * Time Complexity: O(n), where n is the length of the input array. Space
     * Complexity: O(1), as we only use a constant amount of extra space.
     */
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers
        int left = 0;
        int right = numbers.length - 1;

        // Use the two-pointer technique
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return the 1-based indices
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // Move the left pointer to the right to increase the sum
                left++;
            } else {
                // Move the right pointer to the left to decrease the sum
                right--;
            }
        }

        // In case no solution is found (although the problem guarantees a solution)
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

        // Test cases
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println(result1[0] + ", " + result1[1]); // Output: 1, 2

        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println(result2[0] + ", " + result2[1]); // Output: 1, 3

        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println(result3[0] + ", " + result3[1]); // Output: 1, 2
    }
}
