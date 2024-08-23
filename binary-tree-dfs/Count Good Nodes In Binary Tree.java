
/**
 * This class represents a node in a binary tree.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Constructs a TreeNode with the given value.
     *
     * @param val The value to be stored in this node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * This class provides a solution for counting the number of "good" nodes in a
 * binary tree. A node is considered "good" if the path from the root to the
 * node has no nodes with a greater value.
 */
class Solution {

    /**
     * Recursively counts the number of good nodes in the binary tree.
     *
     * @param node The current node being examined.
     * @param maxSoFar The maximum value encountered so far in the path from the
     * root to the current node.
     * @return The number of good nodes in the subtree rooted at the current
     * node.
     */
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        // A node is good if its value is greater than or equal to the maximum value seen so far
        int count = node.val >= maxSoFar ? 1 : 0;

        // Update the max value seen so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // Continue to count good nodes in left and right subtrees
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }

    /**
     * Counts the number of good nodes in the entire binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The total number of good nodes in the binary tree.
     */
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }

    /**
     * Main method for testing the solution with example inputs.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [3,1,4,3,null,1,5]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(5);

        System.out.println("Number of good nodes (Example 1): " + solution.goodNodes(root1));  // Expected output: 4

        // Example 2: root = [3,3,null,4,2]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);

        System.out.println("Number of good nodes (Example 2): " + solution.goodNodes(root2));  // Expected output: 3

        // Example 3: root = [1]
        TreeNode root3 = new TreeNode(1);

        System.out.println("Number of good nodes (Example 3): " + solution.goodNodes(root3));  // Expected output: 1
    }
}
