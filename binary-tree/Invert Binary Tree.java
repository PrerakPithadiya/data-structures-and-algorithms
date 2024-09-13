
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
 * Solution class for inverting a binary tree.
 */
class Solution {

    /**
     * Inverts a binary tree.
     *
     * This method takes the root of a binary tree and inverts it. Inverting a
     * binary tree means swapping the left and right children of every node in
     * the tree.
     *
     * @param root The root node of the binary tree to be inverted.
     * @return The root node of the inverted binary tree.
     */
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right children
        root.left = right;
        root.right = left;

        // Return the current root node after inversion
        return root;
    }

    /**
     * Main method for testing the invertTree function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty tree
        TreeNode emptyTree = null;
        System.out.println("Test case 1 (Empty tree):");
        System.out.println("Input: null");
        System.out.println("Output: " + solution.invertTree(emptyTree));

        // Test case 2: Tree with only root node
        TreeNode singleNodeTree = new TreeNode(1);
        System.out.println("\nTest case 2 (Single node tree):");
        System.out.println("Input: [1]");
        System.out.println("Output: " + treeToString(solution.invertTree(singleNodeTree)));

        // Test case 3: Complete binary tree
        TreeNode completeTree = new TreeNode(4);
        completeTree.left = new TreeNode(2);
        completeTree.right = new TreeNode(7);
        completeTree.left.left = new TreeNode(1);
        completeTree.left.right = new TreeNode(3);
        completeTree.right.left = new TreeNode(6);
        completeTree.right.right = new TreeNode(9);
        System.out.println("\nTest case 3 (Complete binary tree):");
        System.out.println("Input: [4,2,7,1,3,6,9]");
        System.out.println("Output: " + treeToString(solution.invertTree(completeTree)));
    }

    /**
     * Helper method to convert a binary tree to a string representation.
     *
     * @param root The root node of the binary tree.
     * @return A string representation of the binary tree.
     */
    private static String treeToString(TreeNode root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                } else {
                    sb.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return "[" + sb.substring(0, sb.length() - 1) + "]";
    }
}
