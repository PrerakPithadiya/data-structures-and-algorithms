
/**
 * This class represents a node in a binary search tree.
 */
class TreeNode {

    int val;
    TreeNode left, right;

    /**
     * Constructor for TreeNode.
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
 * This class provides a solution to find the minimum absolute difference
 * between any two nodes in a Binary Search Tree (BST).
 */
class Solution {

    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    /**
     * Finds the minimum absolute difference between any two nodes in the BST.
     *
     * @param root The root node of the BST.
     * @return The minimum absolute difference.
     */
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    /**
     * Performs an in-order traversal of the BST to find the minimum difference.
     *
     * @param node The current node being processed.
     */
    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inOrderTraversal(node.left);

        // Calculate the difference with the previous value if exists
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        // Update prev to current node value
        prev = node.val;

        // Traverse right subtree
        inOrderTraversal(node.right);
    }
}

/**
 * Main class to demonstrate the functionality of the Solution class.
 */
class MinimumAbsoluteDifferenceInBST {

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Find the minimum absolute difference
        int result = solution.getMinimumDifference(root);

        // Print the result
        System.out.println("The minimum absolute difference in the BST is: " + result);
    }
}
