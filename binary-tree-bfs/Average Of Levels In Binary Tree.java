
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
 * This class contains the solution for calculating the average of levels in a
 * binary tree.
 */
class Solution {

    /**
     * Calculates the average value of nodes at each level of a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of doubles representing the average value at each level.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();  // number of nodes at current level
            long sum = 0;  // to accumulate the sum of the current level

            // Iterate through all nodes of the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                // Add child nodes to the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Compute the average for this level
            double average = (double) sum / size;
            result.add(average);
        }

        return result;
    }

    /**
     * Main method to demonstrate the usage of the averageOfLevels method.
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

        // Calculate the average of levels
        List<Double> averages = solution.averageOfLevels(root);

        // Print the results
        System.out.println("Average of levels in the binary tree:");
        for (int i = 0; i < averages.size(); i++) {
            System.out.println("Level " + i + ": " + averages.get(i));
        }
    }
}
