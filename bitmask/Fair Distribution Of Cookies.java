package bitmask;

/**
 * Solution class for the Fair Distribution of Cookies problem.
 * This class implements a backtracking algorithm to distribute cookies among
 * children
 * while minimizing the unfairness of the distribution.
 */
class Solution {
    /**
     * Distributes cookies among k children to minimize unfairness.
     * 
     * @param cookies An array of integers representing the number of cookies in
     *                each bag.
     * @param k       The number of children to distribute cookies to.
     * @return The minimum unfairness achievable in the distribution.
     */
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k]; // Array to track cookies each child has
        return backtrack(cookies, children, 0, k, Integer.MAX_VALUE);
    }

    /**
     * Recursive backtracking function to distribute cookies.
     * 
     * @param cookies       Array of cookie bags.
     * @param children      Array tracking cookies each child has.
     * @param index         Current index in the cookies array.
     * @param k             Total number of children.
     * @param minUnfairness Current minimum unfairness.
     * @return The minimum unfairness achievable from this state.
     */
    private int backtrack(int[] cookies, int[] children, int index, int k, int minUnfairness) {
        if (index == cookies.length) {
            // Base case: all cookies have been distributed
            int maxCookies = 0;
            for (int i = 0; i < k; i++) {
                maxCookies = Math.max(maxCookies, children[i]);
            }
            return maxCookies; // The unfairness is the max cookies received by any child
        }

        // Try assigning the current bag of cookies (cookies[index]) to each child
        for (int i = 0; i < k; i++) {
            children[i] += cookies[index]; // Give the current bag to child i
            minUnfairness = Math.min(minUnfairness, backtrack(cookies, children, index + 1, k, minUnfairness));
            children[i] -= cookies[index]; // Backtrack, remove the cookies from child i

            // Prune: If the current child has 0 cookies, no point in assigning to further
            // children
            if (children[i] == 0) {
                break;
            }
        }

        return minUnfairness;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] cookies1 = { 8, 15, 10, 20, 8 };
        int k1 = 2;
        System.out.println("Test case 1: " + solution.distributeCookies(cookies1, k1)); // Expected output: 31

        // Test case 2
        int[] cookies2 = { 6, 1, 3, 2, 2, 4, 1, 2 };
        int k2 = 3;
        System.out.println("Test case 2: " + solution.distributeCookies(cookies2, k2)); // Expected output: 7

        // Test case 3
        int[] cookies3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k3 = 5;
        System.out.println("Test case 3: " + solution.distributeCookies(cookies3, k3)); // Expected output: 15
    }
}