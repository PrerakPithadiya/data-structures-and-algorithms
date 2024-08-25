
/**
 * Solution class for the Increasing Triplet Subsequence problem.
 * This class provides a method to determine if there exists a strictly increasing subsequence of length 3 in an array.
 */
class Solution {

    /**
     * Determines if there exists a strictly increasing subsequence of length 3
     * in the given array.
     *
     * @param nums The input array of integers.
     * @return true if a strictly increasing subsequence of length 3 exists,
     * false otherwise.
     */
    public boolean increasingTriplet(int[] nums) {
        // Initialize the two smallest values to the maximum possible values
        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for (int num : nums) {
            if (num <= min1) {
                // Update min1 if current num is smaller or equal
                min1 = num;
            } else if (num <= min2) {
                // Update min2 if current num is larger than min1 but smaller or equal to min2
                min2 = num;
            } else {
                // We have found a number greater than min2, hence a valid triplet exists
                return true;
            }
        }
        // No valid triplet found
        return false;
    }

    /**
     * Main method to run test cases for the increasingTriplet method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // Output: true
        System.out.println(solution.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // Output: false
        System.out.println(solution.increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // Output: true
    }
}
