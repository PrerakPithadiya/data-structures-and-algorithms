package LeetCode;

/**
 * Solution for minimizing the maximum number of products distributed to any
 * store
 *
 * Problem: Given 'n' stores and an array 'quantities' where quantities[i]
 * represents the number of products of the i-th type, distribute all products
 * to the stores such that: 1. Each store receives at most one type of product
 * 2. A store can receive multiple items of the same product type 3. Minimize
 * the maximum number of products given to any store
 */
class Solution {

    /**
     * Finds the minimum possible maximum number of products that must be
     * distributed to any store
     *
     * @param n The number of stores available
     * @param quantities Array containing the quantity of each product type
     * @return The minimized maximum number of products any store must receive
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1; // Minimum possible value of x
        int right = 0; // Maximum possible value of x
        for (int quantity : quantities) {
            right = Math.max(right, quantity); // Find the maximum quantity
        }

        // Binary search for the minimum possible maximum x
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid; // Try for a smaller maximum
            } else {
                left = mid + 1; // Increase the maximum
            }
        }

        return left; // The minimum possible maximum x
    }

    /**
     * Helper method to check if products can be distributed with given maximum
     * limit
     *
     * @param quantities Array containing the quantity of each product type
     * @param n Number of stores available
     * @param maxProducts Maximum products allowed per store
     * @return True if distribution is possible, false otherwise
     */
    private boolean canDistribute(int[] quantities, int n, int maxProducts) {
        int storesNeeded = 0;
        for (int quantity : quantities) {
            storesNeeded += (quantity + maxProducts - 1) / maxProducts; // Calculate stores needed
            if (storesNeeded > n) {
                return false; // If we need more stores than available, return false
            }
        }
        return true; // If we can distribute within n stores
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int n1 = 6;
        int[] quantities1 = {11, 6};
        assert solution.minimizedMaximum(n1, quantities1) == 3;

        // Test Case 2
        int n2 = 7;
        int[] quantities2 = {15, 10, 10};
        assert solution.minimizedMaximum(n2, quantities2) == 5;

        // Test Case 3
        int n3 = 1;
        int[] quantities3 = {1};
        assert solution.minimizedMaximum(n3, quantities3) == 1;

        // Test Case 4
        int n4 = 4;
        int[] quantities4 = {8};
        assert solution.minimizedMaximum(n4, quantities4) == 2;

        System.out.println("All test cases passed!");
    }
}
