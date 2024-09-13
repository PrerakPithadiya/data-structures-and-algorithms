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

    private int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        // Start the recursion with the root node and initial number 0
        dfs(root, 0);
        return totalSum;
    }

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
        if (node.left != null) {
            dfs(node.left, currentNumber);
        }
        if (node.right != null) {
            dfs(node.right, currentNumber);
        }
    }
}
