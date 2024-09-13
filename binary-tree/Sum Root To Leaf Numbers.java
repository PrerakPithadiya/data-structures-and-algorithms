
/**
 * Definition for a binary tree node.
 * This class represents a node in a binary tree structure.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Default constructor for TreeNode.
     */
    TreeNode() {
    }

    /**
     * Constructor for TreeNode with a value.
     *
     * @param val The value to be stored in the node.
     */
    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor for TreeNode with a value and left and right child nodes.
     *
     * @param val The value to be stored in the node.
     * @param left The left child node.
     * @param right The right child node.
     */
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Solution class to calculate the sum of numbers formed by root-to-leaf paths
 * in a binary tree.
 */
class Solution {

    private int totalSum = 0;

    /**
     * Calculates the sum of all numbers formed by root-to-leaf paths in the
     * binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The sum of all numbers formed by root-to-leaf paths.
     */
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }

    /**
     * Performs a depth-first search (DFS) traversal of the binary tree to
     * calculate the sum.
     *
     * @param node The current node being processed.
     * @param currentNumber The number formed by the path from root to the
     * current node.
     */
    private void dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return;
        }

        // Update the current number
        currentNumber = currentNumber * 10 + node.val;

        // If it's a leaf node, add the current number to totalSum
        if (node.left == null && node.right == null) {
            totalSum += currentNumber;
            return;
        }

        // Recur for left and right children
        dfs(node.left, currentNumber);
        dfs(node.right, currentNumber);
    }

    /**
     * Main method to run test cases for the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println("Test case 1 result: " + solution.sumNumbers(root1)); // Expected output: 25

        // Reset totalSum for the next test case
        solution.totalSum = 0;

        // Test case 2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);
        System.out.println("Test case 2 result: " + solution.sumNumbers(root2)); // Expected output: 1026
    }
}
