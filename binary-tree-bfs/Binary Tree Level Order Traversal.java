
import java.util.*;

/**
 * This class represents a node in a binary tree.
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
 * This class contains the solution for the Binary Tree Level Order Traversal
 * problem.
 */
class Solution {

    /**
     * Performs a level order traversal of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists containing the values of nodes at each level.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the levelOrder method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Perform level order traversal
        List<List<Integer>> result = solution.levelOrder(root);

        // Print the result
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
