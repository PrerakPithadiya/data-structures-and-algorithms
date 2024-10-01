
/**
 * Solution class for checking if array pairs are divisible by k.
 */
class Solution {

    /**
     * Checks if it's possible to arrange the array into pairs where each pair
     * sum is divisible by k.
     *
     * @param arr The input array of integers.
     * @param k The divisor to check against.
     * @return true if the array can be arranged into pairs divisible by k,
     * false otherwise.
     */
    public boolean canArrange(int[] arr, int k) {
        // Array to store the count of remainders
        int[] remainderCount = new int[k];

        // Count how many elements give each remainder when divided by k
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // Handles both positive and negative numbers
            remainderCount[remainder]++;
        }

        // Check pairs for remainder 0
        if (remainderCount[0] % 2 != 0) {
            return false; // Must have an even number of elements divisible by k
        }

        // Check pairs for other remainders
        for (int i = 1; i <= k / 2; i++) {
            // Remainders i and k - i must have the same count
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Main method for testing the canArrange function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Should return true
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println("Test case 1: " + solution.canArrange(arr1, k1)); // Expected: true

        // Test case 2: Should return true
        int[] arr2 = {-1, 1, -2, 2, -3, 3, -4, 4};
        int k2 = 3;
        System.out.println("Test case 2: " + solution.canArrange(arr2, k2)); // Expected: true

        // Test case 3: Should return false
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int k3 = 7;
        System.out.println("Test case 3: " + solution.canArrange(arr3, k3)); // Expected: false

        // Test case 4: Should return true
        int[] arr4 = {-4, -7, 5, 2, 9, 1, 10, 4, -8, -3};
        int k4 = 3;
        System.out.println("Test case 4: " + solution.canArrange(arr4, k4)); // Expected: true
    }
}
