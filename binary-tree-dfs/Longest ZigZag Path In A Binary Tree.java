
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
     * @param val The value to be stored in the node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * This class provides a solution to find the longest ZigZag path in a binary
 * tree.
 */
class Solution {

    private int maxLength = 0;

    /**
     * Performs a depth-first search (DFS) on the binary tree to find the
     * longest ZigZag path.
     *
     * @param node The current node being processed.
     * @param isLeft A boolean indicating whether the current node was reached
     * by a left child traversal.
     * @param length The current length of the ZigZag path.
     */
    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }

        // Update the maximum length
        maxLength = Math.max(maxLength, length);

        if (isLeft) {
            // Continue the path by going left -> right
            dfs(node.left, false, length + 1);  // Go to the left child and change direction to right
            dfs(node.right, true, 1);           // Start a new path from the right child
        } else {
            // Continue the path by going right -> left
            dfs(node.right, true, length + 1);  // Go to the right child and change direction to left
            dfs(node.left, false, 1);           // Start a new path from the left child
        }
    }

    /**
     * Finds the length of the longest ZigZag path in the given binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The length of the longest ZigZag path.
     */
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // Start by considering the left direction
        dfs(root, false, 0); // Start by considering the right direction
        return maxLength;
    }

    /**
     * Main method for testing the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(1);
        root1.right.left = new TreeNode(1);
        root1.right.right = new TreeNode(1);
        root1.right.left.right = new TreeNode(1);
        root1.right.right.right = new TreeNode(1);
        root1.right.right.right.left = new TreeNode(1);
        System.out.println("Longest ZigZag path: " + solution.longestZigZag(root1)); // Expected output: 3

        // Example 2: root = [1,1,1,null,1,null,null,1,1,null,1]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.left.right = new TreeNode(1);
        System.out.println("Longest ZigZag path: " + solution.longestZigZag(root2)); // Expected output: 4

        // Example 3: root = [1]
        TreeNode root3 = new TreeNode(1);
        System.out.println("Longest ZigZag path: " + solution.longestZigZag(root3)); // Expected output: 0
    }
}
