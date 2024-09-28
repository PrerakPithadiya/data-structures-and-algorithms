
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements an in-order traversal of a binary tree. In-order
 * traversal visits the left subtree, then the root, and finally the right
 * subtree.
 */
class InOrderTraversal {

    /**
     * Performs an in-order traversal of the binary tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of integer values representing the in-order traversal of
     * the tree.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    /**
     * A recursive helper method to perform the in-order traversal.
     *
     * @param node The current node being processed.
     * @param result The list to store the traversal result.
     */
    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    /**
     * Main method to demonstrate the usage of the InOrderTraversal class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // Perform in-order traversal
        InOrderTraversal traversal = new InOrderTraversal();
        List<Integer> result = traversal.inorderTraversal(root);

        // Print the result
        System.out.println("In-order traversal: " + result); // Output: [1, 3, 2]
    }
}

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
     * @param x The value to be stored in the node.
     */
    TreeNode(int x) {
        val = x;
    }
}
