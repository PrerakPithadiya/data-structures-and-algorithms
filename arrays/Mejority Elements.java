
/**
 * Solution class for finding the majority element in an array.
 * The majority element is defined as the element that appears more than ⌊n/2⌋ times,
 * where n is the size of the array.
 */
class Solution {

    /**
     * Finds the majority element in the given array using Boyer-Moore Voting
     * Algorithm.
     *
     * @param nums The input array of integers
     * @return The majority element in the array
     *
     * Time Complexity: O(n), where n is the length of the input array Space
     * Complexity: O(1), as it uses only constant extra space
     */
    public int majorityElement(int[] nums) {
        // Step 1: Find a candidate using Boyer-Moore Voting Algorithm
        int candidate = nums[0];
        int count = 0;

        // Iterate through the array to find the candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // Assign new candidate when count becomes zero
            }
            count += (num == candidate) ? 1 : -1;  // Increment count for candidate, decrement for others
        }

        // Step 2: The candidate is guaranteed to be the majority element
        // Note: This algorithm assumes that a majority element always exists in the array
        return candidate;
    }

    /**
     * Main method to demonstrate the usage of the majorityElement method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 3};
        System.out.println("Example 1 output: " + solution.majorityElement(nums1));  // Output: 3

        // Example 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Example 2 output: " + solution.majorityElement(nums2));  // Output: 2
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * majorityElement method with an integer array as the argument. 3. The method
 * will return the majority element in the array.
 *
 * Example: Solution solution = new Solution(); int[] nums = {2, 2, 1, 1, 1, 2,
 * 2}; int result = solution.majorityElement(nums); System.out.println("Majority
 * element: " + result);
 *
 * Note: This implementation assumes that a majority element always exists in
 * the input array. If this assumption doesn't hold, additional verification
 * might be needed.
 */
