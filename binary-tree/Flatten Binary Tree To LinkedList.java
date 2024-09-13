// Definition for a binary tree node.

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * This class provides a solution to flatten a binary tree into a linked list.
 * The flattening is done in-place, meaning the original tree structure is
 * modified.
 */
class Solution {

    /**
     * Flattens a binary tree to a linked list in-place. The flattened tree
     * should use the right pointer to link nodes, and the left pointer of all
     * nodes should be set to null.
     *
     * @param root The root of the binary tree to be flattened.
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null) {
            // If the current node has a left subtree
            if (current.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // Connect the original right subtree to the rightmost node
                rightmost.right = current.right;

                // Move the left subtree to the right and nullify the left subtree
                current.right = current.left;
                current.left = null;
            }
            // Move to the next node
            current = current.right;
        }
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);

        System.out.println("Test Case 1:");
        System.out.println("Before flattening:");
        printTree(root1);
        solution.flatten(root1);
        System.out.println("After flattening:");
        printFlattenedTree(root1);

        // Test case 2: Tree with only left children
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);

        System.out.println("\nTest Case 2:");
        System.out.println("Before flattening:");
        printTree(root2);
        solution.flatten(root2);
        System.out.println("After flattening:");
        printFlattenedTree(root2);

        // Test case 3: Empty tree
        TreeNode root3 = null;

        System.out.println("\nTest Case 3:");
        System.out.println("Before flattening:");
        printTree(root3);
        solution.flatten(root3);
        System.out.println("After flattening:");
        printFlattenedTree(root3);
    }

    /**
     * Helper method to print the tree structure.
     */
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        printTreeHelper(node.right, level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }
        System.out.println(node.val);
        printTreeHelper(node.left, level + 1);
    }

    /**
     * Helper method to print the flattened tree (linked list).
     */
    private static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }
}
