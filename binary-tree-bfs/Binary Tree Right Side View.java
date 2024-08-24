
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
 * This class contains the solution for finding the right side view of a binary
 * tree.
 */
class Solution {

    /**
     * Finds the right side view of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of integers representing the right side view of the tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightMost = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Update rightMost to the current node
                rightMost = currentNode;

                // Add child nodes to the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add the last node of the current level to the result
            if (rightMost != null) {
                rightView.add(rightMost.val);
            }
        }

        return rightView;
    }

    /**
     * The main method to demonstrate the functionality of the right side view
     * algorithm.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1: A binary tree with multiple levels and nodes
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);

        Solution solution = new Solution();
        System.out.println("Right-side view of the tree: " + solution.rightSideView(root1)); // Output: [1, 3, 4]

        // Example 2: A binary tree with only right children
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("Right-side view of the tree: " + solution.rightSideView(root2)); // Output: [1, 3]

        // Example 3: An empty tree (null root)
        TreeNode root3 = null;

        System.out.println("Right-side view of the tree: " + solution.rightSideView(root3)); // Output: []

        // Example 4: A binary tree with both left and right children
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(4);
        root4.right = new TreeNode(3);
        root4.right.right = new TreeNode(5);

        System.out.println("Right-side view of the tree: " + solution.rightSideView(root4)); // Output: [1, 3, 5]
    }
}
