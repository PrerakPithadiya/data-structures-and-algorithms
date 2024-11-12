package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for Prime Subtraction Operation problem Time Complexity: O(n * p)
 * where n is length of nums array and p is number of primes Space Complexity:
 * O(1000) for storing prime numbers
 */
class Solution {

    /**
     * Determines if it's possible to make the array strictly increasing by
     * subtracting prime numbers from each element at most once.
     *
     * @param nums The input array of integers where 1 <= nums[i] <= 1000 @
     * return true if it's possible to make the array strictly increasing, false
     * otherwise
     */
    public boolean primeSubOperation(int[] nums) {
        // Step 1: Generate all prime numbers up to 1000 using the Sieve of Eratosthenes
        boolean[] isPrime = new boolean[1001];
        for (int i = 2; i <= 1000; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Step 2: Iterate from the end of the array to the beginning
        int previous = Integer.MAX_VALUE; // Start with a large number
        for (int i = nums.length - 1; i >= 0; i--) {
            // We need to make nums[i] < previous
            if (nums[i] >= previous) {
                // Find the largest prime less than nums[i]
                for (int p : primes) {
                    if (p < nums[i]) {
                        // Try to subtract this prime from nums[i]
                        if (nums[i] - p < previous) {
                            nums[i] -= p; // Perform the operation
                            break; // Move to the next number
                        }
                    }
                }
                // After attempting to subtract, check if it's still not less than previous
                if (nums[i] >= previous) {
                    return false; // We cannot make it strictly increasing
                }
            }
            previous = nums[i]; // Update previous for the next iteration
        }

        return true; // Successfully made the array strictly increasing
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case where operation is needed
        int[] test1 = {4, 9, 6, 10};
        System.out.println("Test 1: " + solution.primeSubOperation(test1) + " (Expected: true)");

        // Test Case 2: Already strictly increasing
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + solution.primeSubOperation(test2) + " (Expected: true)");

        // Test Case 3: Impossible to make strictly increasing
        int[] test3 = {6, 8, 11, 6};
        System.out.println("Test 3: " + solution.primeSubOperation(test3) + " (Expected: false)");

        // Test Case 4: Single element array
        int[] test4 = {5};
        System.out.println("Test 4: " + solution.primeSubOperation(test4) + " (Expected: true)");

        // Test Case 5: Two elements requiring operation
        int[] test5 = {5, 4};
        System.out.println("Test 5: " + solution.primeSubOperation(test5) + " (Expected: true)");
    }
}
