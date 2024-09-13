
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
 * Solution class containing the method to check if there exists a root-to-leaf
 * path with a given sum.
 */
class Solution {

    /**
     * Determines if there is a root-to-leaf path in the binary tree that sums
     * up to the given target sum.
     *
     * @param root The root node of the binary tree.
     * @param targetSum The target sum to be checked.
     * @return true if there exists a path from root-to-leaf with the given sum,
     * false otherwise.
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the root is null, no path exists
        if (root == null) {
            return false;
        }

        // If we reach a leaf node, check if the remaining sum equals the leaf node's value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursively check the left and right subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    /**
     * Main method to run test cases for the hasPathSum method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple tree with a valid path
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        System.out.println("Test case 1: " + solution.hasPathSum(root1, 22)); // Expected: true

        // Test case 2: Empty tree
        TreeNode root2 = null;
        System.out.println("Test case 2: " + solution.hasPathSum(root2, 0)); // Expected: false

        // Test case 3: Tree with no valid path
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        System.out.println("Test case 3: " + solution.hasPathSum(root3, 5)); // Expected: false

        // Test case 4: Tree with a single node equal to target sum
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test case 4: " + solution.hasPathSum(root4, 1)); // Expected: true

        // Test case 5: Tree with negative values
        TreeNode root5 = new TreeNode(-2);
        root5.left = new TreeNode(-3);
        System.out.println("Test case 5: " + solution.hasPathSum(root5, -5)); // Expected: true
    }
}
