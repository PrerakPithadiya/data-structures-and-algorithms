package LeetCode;

import java.util.Arrays;

/**
 * Solution for Maximum Beauty of Items for Each Query problem Time Complexity:
 * O(nlogn + qlogn) where n is number of items and q is number of queries Space
 * Complexity: O(n) for maxBeauty array
 */
class Solution {

    /**
     * Finds the maximum beauty for each price query
     *
     * @param items 2D array where items[i] = [pricei, beautyi]
     * @param queries array of price queries
     * @return array where answer[j] is the maximum beauty of an item with price
     * <= queries[j]
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items based on price, and then by beauty in descending order
        Arrays.sort(items, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]); // Sort by beauty descending
            }
        });

        // Step 2: Preprocess maximum beauty
        int n = items.length;
        int[] maxBeauty = new int[n];
        maxBeauty[0] = items[0][1]; // First item's beauty
        for (int i = 1; i < n; i++) {
            maxBeauty[i] = Math.max(maxBeauty[i - 1], items[i][1]);
        }

        // Step 3: Prepare to answer queries
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            // Binary search to find the rightmost item with price <= query
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    left = mid + 1; // Move to the right part
                } else {
                    right = mid - 1; // Move to the left part
                }
            }
            // After the loop, right is the index of the last item with price <= query
            if (right >= 0) {
                answer[i] = maxBeauty[right]; // Get the max beauty for this price
            } else {
                answer[i] = 0; // No item found
            }
        }

        return answer;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case
        int[][] items1 = {{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[] queries1 = {1, 2, 3, 4, 5, 6};
        int[] result1 = solution.maximumBeauty(items1, queries1);
        System.out.println("Test 1: " + Arrays.toString(result1)); // Expected: [2,4,5,5,6,6]

        // Test case 2: Empty items
        int[][] items2 = {};
        int[] queries2 = {1, 2, 3};
        int[] result2 = solution.maximumBeauty(items2, queries2);
        System.out.println("Test 2: " + Arrays.toString(result2)); // Expected: [0,0,0]

        // Test case 3: Single item
        int[][] items3 = {{1, 5}};
        int[] queries3 = {0, 1, 2};
        int[] result3 = solution.maximumBeauty(items3, queries3);
        System.out.println("Test 3: " + Arrays.toString(result3)); // Expected: [0,5,5]

        // Test case 4: Same price different beauty
        int[][] items4 = {{1, 2}, {1, 4}, {1, 3}};
        int[] queries4 = {1};
        int[] result4 = solution.maximumBeauty(items4, queries4);
        System.out.println("Test 4: " + Arrays.toString(result4)); // Expected: [4]
    }
}
