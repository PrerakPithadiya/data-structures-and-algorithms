
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Solution class for determining if two binary trees are the same.
 */
class Solution {

    /**
     * Determines if two binary trees are the same. Two binary trees are
     * considered the same if they are structurally identical and the nodes have
     * the same value.
     *
     * @param p The root of the first binary tree
     * @param q The root of the second binary tree
     * @return true if the trees are the same, false otherwise
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null, or if the values don't match, return false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Main method for testing the isSameTree function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Same trees
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);

        System.out.println("Test case 1: " + solution.isSameTree(tree1, tree2)); // Expected: true

        // Test case 2: Different trees
        TreeNode tree3 = new TreeNode(1);
        tree3.left = new TreeNode(2);

        TreeNode tree4 = new TreeNode(1);
        tree4.right = new TreeNode(2);

        System.out.println("Test case 2: " + solution.isSameTree(tree3, tree4)); // Expected: false

        // Test case 3: Empty trees
        System.out.println("Test case 3: " + solution.isSameTree(null, null)); // Expected: true

        // Test case 4: One empty tree, one non-empty tree
        TreeNode tree5 = new TreeNode(1);
        System.out.println("Test case 4: " + solution.isSameTree(tree5, null)); // Expected: false
    }
}

/**
 * Usage Instructions: 1. Ensure that the TreeNode class is defined in your
 * project. 2. Create a Solution object. 3. Call the isSameTree method with two
 * TreeNode objects representing the roots of the trees you want to compare. 4.
 * The method will return true if the trees are the same, and false otherwise.
 *
 * Example: Solution solution = new Solution(); TreeNode tree1 = new TreeNode(1,
 * new TreeNode(2), new TreeNode(3)); TreeNode tree2 = new TreeNode(1, new
 * TreeNode(2), new TreeNode(3)); boolean result = solution.isSameTree(tree1,
 * tree2);
 */
