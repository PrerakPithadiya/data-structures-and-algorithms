
import java.util.*;

/**
 * This class represents a node in a binary search tree.
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
 * This class provides a solution for deleting a node from a Binary Search Tree
 * (BST).
 */
class Solution {

    /**
     * Deletes a node with the given key from the BST.
     *
     * @param root The root of the BST.
     * @param key The key of the node to be deleted.
     * @return The root of the modified BST.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Traverse the tree to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with the key found

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children
            // Find the in-order successor (smallest in the right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    /**
     * Finds the node with the minimum value in the given subtree.
     *
     * @param root The root of the subtree.
     * @return The node with the minimum value.
     */
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * The main method to demonstrate the functionality of the BST deletion.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1: Deleting a node with two children
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);

        Solution solution = new Solution();
        TreeNode result1 = solution.deleteNode(root1, 3);
        System.out.print("Example 1 Output: ");
        printTree(result1); // Expected Output: [5,4,6,2,null,null,7]

        // Example 2: Deleting a non-existent node
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode result2 = solution.deleteNode(root2, 0);
        System.out.print("Example 2 Output: ");
        printTree(result2); // Expected Output: [5,3,6,2,4,null,7]

        // Example 3: Deleting from an empty tree
        TreeNode root3 = null;
        TreeNode result3 = solution.deleteNode(root3, 0);
        System.out.print("Example 3 Output: ");
        printTree(result3); // Expected Output: []
    }

    /**
     * Helper method to print the tree in level-order traversal.
     *
     * @param root The root of the tree to be printed.
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }
}
