
/**
 * Solution class for determining if arrays are special based on given queries.
 * A special array is one where all adjacent pairs of elements have different parities (one odd, one even).
 */
class Solution {

    /**
     * Determines if subarrays defined by queries are special arrays.
     *
     * @param nums The input array of integers to check
     * @param queries Array of query pairs [from, to] defining subarrays to
     * check
     * @return Array of boolean values indicating if each queried subarray is
     * special
     *
     * Time Complexity: O(n + q) where n is length of nums and q is number of
     * queries Space Complexity: O(n) for the prefix sum array
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] answer = new boolean[queries.length];

        // Create a prefix sum array to count special pairs
        int[] specialCount = new int[n];

        // Fill the specialCount array with cumulative count of adjacent pairs with different parities
        for (int i = 1; i < n; i++) {
            if ((nums[i] % 2) != (nums[i - 1] % 2)) {
                specialCount[i] = specialCount[i - 1] + 1; // Increment count of special pairs
            } else {
                specialCount[i] = specialCount[i - 1]; // Carry forward the count
            }
        }

        // Process each query to determine if its subarray is special
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // Single element is always considered special
            if (from == to) {
                answer[i] = true;
            } else {
                // For a range to be special, all adjacent pairs must have different parities
                // Count of special pairs should equal the length of range minus 1
                int countInRange = specialCount[to] - specialCount[from];
                answer[i] = (countInRange == (to - from));
            }
        }

        return answer;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case with alternating parities
        int[] nums1 = {1, 2, 3, 4};
        int[][] queries1 = {{0, 3}, {1, 2}, {2, 3}};
        boolean[] result1 = solution.isArraySpecial(nums1, queries1);
        assert result1[0] == true;  // Full array is special
        assert result1[1] == true;  // Subarray [2, 3] is special
        assert result1[2] == true;  // Subarray [3, 4] is special

        // Test Case 2: Array with same parities adjacent
        int[] nums2 = {1, 3, 2, 4};
        int[][] queries2 = {{0, 1}, {1, 2}, {0, 3}};
        boolean[] result2 = solution.isArraySpecial(nums2, queries2);
        assert result2[0] == false; // [1, 3] not special (both odd)
        assert result2[1] == true;  // [3, 2] is special
        assert result2[2] == false; // Full array not special

        // Test Case 3: Single element queries
        int[] nums3 = {1, 1, 1};
        int[][] queries3 = {{0, 0}, {1, 1}, {2, 2}};
        boolean[] result3 = solution.isArraySpecial(nums3, queries3);
        assert result3[0] == true;  // Single elements are always special
        assert result3[1] == true;
        assert result3[2] == true;

        System.out.println("All test cases passed!");
    }
}
