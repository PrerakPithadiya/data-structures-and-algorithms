
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
     * @param val The value of the node.
     */
    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Constructor for TreeNode with a value and left and right children.
     *
     * @param val The value of the node.
     * @param left The left child of the node.
     * @param right The right child of the node.
     */
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * This class provides a solution for the Binary Tree Zigzag Level Order
 * Traversal problem.
 */
class Solution {

    /**
     * This method performs a zigzag level order traversal of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists containing the values of the nodes in zigzag
     * level order.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

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

            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;  // Toggle the direction for the next level
        }

        return result;
    }

    /**
     * The main method to demonstrate the usage of the zigzagLevelOrder method.
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

        // Perform zigzag level order traversal
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

        // Print the result
        System.out.println("Zigzag Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
