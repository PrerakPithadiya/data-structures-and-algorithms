
/**
 * This class represents a node in a binary search tree.
 */
class TreeNode {

    int val;
    TreeNode left, right;

    /**
     * Constructor for TreeNode.
     *
     * @param val The value to be stored in this node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * This class provides a solution for finding the kth smallest element in a
 * Binary Search Tree (BST).
 */
class Solution {

    private int count = 0;
    private int result = -1;

    /**
     * Finds the kth smallest element in the BST.
     *
     * @param root The root node of the BST.
     * @param k The k value for which we need to find the kth smallest element.
     * @return The value of the kth smallest element.
     */
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    /**
     * Performs an in-order traversal of the BST to find the kth smallest
     * element.
     *
     * @param node The current node in the traversal.
     * @param k The k value for which we need to find the kth smallest element.
     */
    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree
        inOrderTraversal(node.left, k);

        // Increment count and check if this is the kth smallest
        count++;
        if (count == k) {
            result = node.val;
            return; // We found the kth smallest, so we stop further traversal
        }

        // Traverse the right subtree
        inOrderTraversal(node.right, k);
    }
}

/**
 * Main class to demonstrate the usage of the Solution class.
 */
public class KthSmallestElementInBST {

    /**
     * Main method to run the program.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create a sample BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Solution solution = new Solution();
        int k = 3;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
