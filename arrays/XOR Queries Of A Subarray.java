
/**
 * Solution class for XOR Queries of a Subarray problem.
 */
class Solution {

    /**
     * Computes XOR queries on a given array.
     *
     * @param arr The input array of integers.
     * @param queries The array of query ranges, where each query is represented
     * by [left, right].
     * @return An array containing the XOR results for each query.
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXOR = new int[n];
        prefixXOR[0] = arr[0];

        // Compute the prefix XOR array
        for (int i = 1; i < n; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];

        // For each query, calculate the XOR of the subarray
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                result[i] = prefixXOR[right];
            } else {
                result[i] = prefixXOR[right] ^ prefixXOR[left - 1];
            }
        }

        return result;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1 = {1, 3, 4, 8};
        int[][] queries1 = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        int[] result1 = solution.xorQueries(arr1, queries1);
        System.out.println("Test case 1 result: " + java.util.Arrays.toString(result1));
        // Expected output: [2, 7, 14, 8]

        // Test case 2
        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        int[] result2 = solution.xorQueries(arr2, queries2);
        System.out.println("Test case 2 result: " + java.util.Arrays.toString(result2));
        // Expected output: [8, 0, 4, 4]
    }
}

/*
 * Usage Instructions:
 * 1. Create an instance of the Solution class.
 * 2. Call the xorQueries method with the input array and queries.
 * 3. The method will return an array containing the XOR results for each query.
 *
 * Example:
 * Solution solution = new Solution();
 * int[] arr = {1, 3, 4, 8};
 * int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
 * int[] result = solution.xorQueries(arr, queries);
 *
 * Design and Implementation:
 * - The solution uses a prefix XOR array to optimize query processing.
 * - Time Complexity: O(n + q), where n is the length of the input array and q is the number of queries.
 * - Space Complexity: O(n) for the prefix XOR array.
 *
 * Algorithm:
 * 1. Compute the prefix XOR array.
 * 2. For each query [left, right]:
 *    - If left is 0, return prefixXOR[right].
 *    - Otherwise, return prefixXOR[right] ^ prefixXOR[left - 1].
 * 3. Return the array of query results.
 */
