// Definition for a binary tree node.

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

class Solution {

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
}
