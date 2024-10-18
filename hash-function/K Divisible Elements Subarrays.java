
import java.util.HashSet;
import java.util.Set;

/**
 * Solution class for counting distinct subarrays with at most k elements
 * divisible by p.
 */
class Solution {

    /**
     * Counts the number of distinct subarrays in the given array where at most
     * k elements are divisible by p.
     *
     * @param nums The input array of integers.
     * @param k The maximum number of elements divisible by p allowed in each
     * subarray.
     * @param p The divisor to check divisibility.
     * @return The count of distinct subarrays satisfying the condition.
     */
    public static int countDistinct(int[] nums, int k, int p) {
        Set<String> distinctSubarrays = new HashSet<>();

        // Iterate through each starting point of subarrays
        for (int i = 0; i < nums.length; i++) {
            int countDivisible = 0;
            StringBuilder currentSubarray = new StringBuilder();

            // Build subarrays starting from index i
            for (int j = i; j < nums.length; j++) {
                currentSubarray.append(nums[j]).append(",");

                if (nums[j] % p == 0) {
                    countDivisible++;
                }

                // If the count of divisible elements exceeds k, break the loop
                if (countDivisible > k) {
                    break;
                }

                // Add the current subarray to the set
                distinctSubarrays.add(currentSubarray.toString());
            }
        }

        // The size of the set represents the number of distinct subarrays
        return distinctSubarrays.size();
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {2, 3, 3, 2, 2};
        int k1 = 2;
        int p1 = 2;
        System.out.println("Test case 1: " + countDistinct(nums1, k1, p1)); // Expected output: 11

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        int k2 = 4;
        int p2 = 1;
        System.out.println("Test case 2: " + countDistinct(nums2, k2, p2)); // Expected output: 10

        // Test case 3
        int[] nums3 = {2, 2, 2, 2, 2};
        int k3 = 2;
        int p3 = 2;
        System.out.println("Test case 3: " + countDistinct(nums3, k3, p3)); // Expected output: 6

        // Test case 4
        int[] nums4 = {1, 3, 5, 7};
        int k4 = 1;
        int p4 = 2;
        System.out.println("Test case 4: " + countDistinct(nums4, k4, p4)); // Expected output: 10
    }
}
