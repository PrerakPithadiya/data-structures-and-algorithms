
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
     * @param val The value to be stored in this node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * This class contains the solution for searching a value in a Binary Search
 * Tree (BST).
 */
class Solution {

    /**
     * Searches for a node with the given value in the BST.
     *
     * @param root The root node of the BST.
     * @param val The value to search for.
     * @return The node containing the value if found, null otherwise.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: If root is null or the root's value is the target value
        if (root == null || root.val == val) {
            return root;
        }

        // If the target value is less than the current node's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the target value is greater than the current node's value, search in the right subtree
        return searchBST(root.right, val);
    }

    /**
     * The main method to demonstrate the functionality of the BST search.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1: Searching for a value that exists in the BST
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);

        Solution solution = new Solution();
        TreeNode result1 = solution.searchBST(root1, 2);
        System.out.print("Example 1 - Searching for 2: ");
        printTree(result1); // Expected Output: [2,1,3]

        // Example 2: Searching for a value that doesn't exist in the BST
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);

        TreeNode result2 = solution.searchBST(root2, 5);
        System.out.print("Example 2 - Searching for 5: ");
        printTree(result2); // Expected Output: []
    }

    /**
     * Helper method to print the tree in level-order traversal.
     *
     * @param root The root node of the tree to be printed.
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
            result.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        System.out.println(result);
    }
}
