
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
 * Solution class to find the maximum depth of a binary tree.
 */
class Solution {

    /**
     * Calculates the maximum depth of a binary tree.
     *
     * The maximum depth is the number of nodes along the longest path from the
     * root node down to the farthest leaf node.
     *
     * @param root The root node of the binary tree.
     * @return The maximum depth of the binary tree.
     */
    public int maxDepth(TreeNode root) {
        // Base case: if the root is null, return depth as 0
        if (root == null) {
            return 0;
        }

        // Recursive case: calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is 1 + the maximum of the depths of its subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
