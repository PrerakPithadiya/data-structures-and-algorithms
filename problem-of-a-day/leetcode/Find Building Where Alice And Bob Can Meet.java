
import java.util.*;

/**
 * Solution for finding meeting points between Alice and Bob in buildings
 *
 * Problem Description: Given an array of building heights and queries about two
 * positions, find the leftmost building where both people can meet, considering
 * they can only move right and the meeting point must be higher than their
 * starting buildings.
 *
 * Time Complexity: O(n + q * log n) where n is number of buildings and q is
 * number of queries Space Complexity: O(n) for storing the monotonic stack and
 * processed queries
 */
class Solution {

    private static class Pair<K, V> {

        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    /**
     * Finds the leftmost valid meeting point for each query
     *
     * @param heights Array of building heights
     * @param queries Array of query pairs [a,b] representing starting positions
     * @return Array containing the leftmost valid meeting point for each query
     * (-1 if impossible)
     */
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<Pair<Integer, Integer>> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        // Process queries and handle simple cases
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                newQueries.get(b).add(new Pair<>(heights[a], i));
            }
        }

        // Process remaining queries using monotonic stack
        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (Pair<Integer, Integer> pair : newQueries.get(i)) {
                int position = search(pair.getKey(), monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[pair.getValue()] = monoStack
                            .get(position)
                            .getValue();
                }
            }

            while (!monoStack.isEmpty() && monoStack.get(monoStack.size() - 1).getKey() <= heights[i]) {
                monoStack.remove(monoStack.size() - 1);
            }

            monoStack.add(new Pair<>(heights[i], i));
        }

        return result;
    }

    /**
     * Binary search to find the leftmost building higher than the given height
     *
     * @param height Target height to compare against
     * @param monoStack Monotonic stack containing building heights and indices
     * @return Index of the leftmost suitable building, -1 if none found
     */
    private int search(int height, List<Pair<Integer, Integer>> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid).getKey() > height) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] heights1 = {6, 4, 8, 5, 2, 7};
        int[][] queries1 = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        int[] expected1 = {2, 5, 5, 5, 2};
        assert Arrays.equals(solution.leftmostBuildingQueries(heights1, queries1), expected1);

        // Test Case 2: All buildings same height
        int[] heights2 = {5, 5, 5, 5};
        int[][] queries2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        int[] expected2 = {1, 2, 3, 2};
        assert Arrays.equals(solution.leftmostBuildingQueries(heights2, queries2), expected2);

        // Test Case 3: Impossible meetings
        int[] heights3 = {1, 2, 1, 2, 1, 2};
        int[][] queries3 = {{0, 2}, {1, 4}, {3, 5}};
        int[] expected3 = {-1, -1, 5};
        assert Arrays.equals(solution.leftmostBuildingQueries(heights3, queries3), expected3);

        System.out.println("All test cases passed!");
    }
}
