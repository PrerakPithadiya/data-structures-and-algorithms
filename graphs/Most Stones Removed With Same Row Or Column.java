
/**
 * This class provides a solution to the "Most Stones Removed with Same Row or Column" problem.
 * The problem involves removing stones from a 2D plane where stones in the same row or column are considered connected.
 * The goal is to remove as many stones as possible, leaving only one stone per connected component.
 */
import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Calculates the maximum number of stones that can be removed.
     *
     * @param stones A 2D array where each inner array represents the
     * coordinates of a stone [x, y]
     * @return The maximum number of stones that can be removed
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];

            // If the row already has a stone, union this stone with the previous stone in the row
            if (rowMap.containsKey(x)) {
                uf.union(i, rowMap.get(x));
            }

            // If the column already has a stone, union this stone with the previous stone in the column
            if (colMap.containsKey(y)) {
                uf.union(i, colMap.get(y));
            }

            // Update the maps
            rowMap.put(x, i);
            colMap.put(y, i);
        }

        return n - uf.getNumberOfComponents();
    }

    /**
     * UnionFind (Disjoint Set) data structure implementation. This class is
     * used to efficiently track connected components among the stones.
     */
    class UnionFind {

        private final int[] parent;
        private final int[] rank;
        private int components;

        /**
         * Initializes the UnionFind data structure.
         *
         * @param n The number of elements (stones) in the set
         */
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            components = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        /**
         * Finds the representative (root) of the set that contains x.
         *
         * @param x The element to find the representative for
         * @return The representative of the set containing x
         */
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        /**
         * Unites the sets containing elements x and y.
         *
         * @param x An element from the first set
         * @param y An element from the second set
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                components--;
            }
        }

        /**
         * Returns the current number of disjoint sets (components).
         *
         * @return The number of components
         */
        public int getNumberOfComponents() {
            return components;
        }
    }

    /**
     * Main method to run test cases for the removeStones method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[][] stones1 = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println("Test case 1: " + solution.removeStones(stones1)); // Expected output: 5

        // Test case 2
        int[][] stones2 = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        System.out.println("Test case 2: " + solution.removeStones(stones2)); // Expected output: 3

        // Test case 3
        int[][] stones3 = {{0, 0}};
        System.out.println("Test case 3: " + solution.removeStones(stones3)); // Expected output: 0

        // Test case 4
        int[][] stones4 = {{0, 1}, {1, 0}, {1, 1}};
        System.out.println("Test case 4: " + solution.removeStones(stones4)); // Expected output: 2
    }
}
