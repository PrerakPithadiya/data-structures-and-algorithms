
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Binary Tree and implements a postorder traversal
 * algorithm.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor for TreeNode.
     *
     * @param val The value to be stored in this node.
     */
    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * This class contains the solution for postorder traversal of a binary tree.
 */
class Solution {

    /**
     * Performs a postorder traversal of the binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of integers representing the postorder traversal of the
     * tree.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        TreeNode lastVisited = null;

        while (!stack.isEmpty() || root != null) {
            // Reach the left most Node of the current Node
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // Peek the node at the top of the stack
            root = stack.peek();

            // If the right subtree is not yet traversed, move to the right
            if (root.right != null && lastVisited != root.right) {
                root = root.right;
            } else {
                // If no right child exists or right child is already visited
                stack.pop();
                result.add(root.val);
                lastVisited = root;
                root = null;  // Important to avoid revisiting the left nodes
            }
        }

        return result;
    }

    /**
     * Main method to run test cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();

        // Test case 1: Tree with right child and left grandchild
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(3);
        System.out.println(solution.postorderTraversal(root1)); // Expected output: [3, 2, 1]

        // Test case 2: Empty tree
        TreeNode root2 = null;
        System.out.println(solution.postorderTraversal(root2)); // Expected output: []

        // Test case 3: Tree with single node
        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.postorderTraversal(root3)); // Expected output: [1]
    }
}
