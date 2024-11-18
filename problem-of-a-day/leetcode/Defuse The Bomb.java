package LeetCode;

/**
 * Solution for LeetCode problem: Defuse the Bomb
 *
 * Problem: You have a bomb to defuse, and your time is running out! Your
 * informer will provide you with a circular array code of length n and a key k.
 * To decrypt the code, you must replace every number with the sum of the next k
 * numbers (or previous k numbers if k is negative). If k = 0, replace each
 * number with 0.
 *
 * Time Complexity: O(n) where n is the length of the input array Space
 * Complexity: O(n) for the result array
 */
class Solution {

    /**
     * Decrypts the given code array based on the key k
     *
     * @param code The input circular array
     * @param k The key that determines how many numbers to sum (positive for
     * next k numbers, negative for previous k numbers)
     * @return The decrypted array
     */
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result; // All elements replaced by 0
        }

        int start = k > 0 ? 1 : n + k; // Start index for summing
        int end = k > 0 ? k : n - 1;  // End index for summing

        int sum = 0;
        // Initial sum calculation
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }

        // Sliding window approach
        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum -= code[(start++) % n]; // Remove the element leaving the window
            sum += code[(++end) % n];  // Add the element entering the window
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Positive k
        int[] test1 = {5, 7, 1, 4};
        int k1 = 3;
        int[] result1 = solution.decrypt(test1, k1);
        System.out.println("Test 1 - Expected: [12,10,16,13], Got: " + java.util.Arrays.toString(result1));

        // Test case 2: Negative k
        int[] test2 = {1, 2, 3, 4};
        int k2 = -2;
        int[] result2 = solution.decrypt(test2, k2);
        System.out.println("Test 2 - Expected: [3,4,5,6], Got: " + java.util.Arrays.toString(result2));

        // Test case 3: k = 0
        int[] test3 = {2, 4, 9, 3};
        int k3 = 0;
        int[] result3 = solution.decrypt(test3, k3);
        System.out.println("Test 3 - Expected: [0,0,0,0], Got: " + java.util.Arrays.toString(result3));
    }
}
