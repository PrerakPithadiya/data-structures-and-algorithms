
import java.util.*;

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
 * This class contains the solution for finding the level with the maximum sum
 * in a binary tree.
 */
class Solution {

    /**
     * Finds the level with the maximum sum in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The level number with the maximum sum. Returns 0 if the tree is
     * empty.
     */
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int maxLevel = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            if (currentLevelSum > maxSum) {
                maxSum = currentLevelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    /**
     * The main method to demonstrate the functionality of the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1: A binary tree with 5 nodes
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(-8);

        Solution solution = new Solution();
        System.out.println("Example 1 - The level with the maximum sum: " + solution.maxLevelSum(root1)); // Expected Output: 2

        // Example 2: A binary tree with 5 nodes, right-skewed
        TreeNode root2 = new TreeNode(989);
        root2.right = new TreeNode(10250);
        root2.right.left = new TreeNode(98693);
        root2.right.right = new TreeNode(-89388);
        root2.right.right.right = new TreeNode(-32127);

        System.out.println("Example 2 - The level with the maximum sum: " + solution.maxLevelSum(root2)); // Expected Output: 2
    }
}
