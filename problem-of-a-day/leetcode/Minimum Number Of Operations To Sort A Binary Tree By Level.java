
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution for finding minimum number of operations to sort a binary tree by
 * level Time Complexity: O(N * log N) where N is the number of nodes in the
 * tree Space Complexity: O(W) where W is the maximum width of the tree
 */
class Solution {

    /**
     * Calculates the minimum number of swap operations needed to sort each
     * level of a binary tree
     *
     * @param root The root node of the binary tree
     * @return Total number of minimum swap operations needed
     */
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalSwaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] values = new int[size];
            int index = 0;

            // Collect nodes at current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                values[index++] = current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            // Calculate minimum swaps needed for current level
            totalSwaps += getMinimumSwaps(values);
        }

        return totalSwaps;
    }

    /**
     * Helper method to calculate minimum number of swaps needed to sort an
     * array Uses cycle detection algorithm
     *
     * @param arr Input array to be sorted
     * @return Minimum number of swaps needed
     */
    private int getMinimumSwaps(int[] arr) {
        int n = arr.length;

        // Create array of pairs to store value and original position
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        // Sort pairs based on values
        Arrays.sort(pairs, (a, b) -> a.val - b.val);

        // Track visited elements and count swaps
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If element is visited or already in correct position
            if (visited[i] || pairs[i].pos == i) {
                continue;
            }

            // Find cycle size
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = pairs[j].pos;
                cycleSize++;
            }

            // Add minimum swaps needed for this cycle
            swaps += (cycleSize - 1);
        }

        return swaps;
    }

    /**
     * Helper class to store value and position pairs
     */
    private static class Pair {

        int val;
        int pos;

        /**
         * Constructor for Pair class
         *
         * @param val Value of the node
         * @param pos Original position in the array
         */
        Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Null tree
        assert solution.minimumOperations(null) == 0 : "Test case 1 failed";

        // Test case 2: Single node tree
        TreeNode root1 = new TreeNode(1);
        assert solution.minimumOperations(root1) == 0 : "Test case 2 failed";

        // Test case 3: Perfect binary tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(8);
        root2.right.right = new TreeNode(5);
        assert solution.minimumOperations(root2) == 3 : "Test case 3 failed";

        // Test case 4: Unbalanced tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.left.left = new TreeNode(2);
        assert solution.minimumOperations(root3) == 1 : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
