
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
     * @param val The value to be stored in the node.
     */
    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * This class provides a solution for finding the Lowest Common Ancestor (LCA)
 * in a binary tree.
 */
class Solution {

    /**
     * Finds the Lowest Common Ancestor of two nodes in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @param p One of the nodes to find the LCA for.
     * @param q The other node to find the LCA for.
     * @return The Lowest Common Ancestor of nodes p and q.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if the current node is null, return null
        if (root == null) {
            return null;
        }

        // If the current node is p or q, return the current node
        if (root == p || root == q) {
            return root;
        }

        // Recur for left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (if any)
        return left != null ? left : right;
    }

    /**
     * Main method for testing the LCA algorithm with various examples.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        TreeNode root1 = createExampleTree1();
        TreeNode p1 = root1.left; // Node with value 5
        TreeNode q1 = root1.right; // Node with value 1
        System.out.println("LCA of 5 and 1: " + solution.lowestCommonAncestor(root1, p1, q1).val); // Expected output: 3

        // Example 2: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        TreeNode p2 = root1.left; // Node with value 5
        TreeNode q2 = root1.left.right.right; // Node with value 4
        System.out.println("LCA of 5 and 4: " + solution.lowestCommonAncestor(root1, p2, q2).val); // Expected output: 5

        // Example 3: root = [1,2], p = 1, q = 2
        TreeNode root3 = createExampleTree3();
        TreeNode p3 = root3; // Node with value 1
        TreeNode q3 = root3.left; // Node with value 2
        System.out.println("LCA of 1 and 2: " + solution.lowestCommonAncestor(root3, p3, q3).val); // Expected output: 1
    }

    /**
     * Creates the example tree for the first two test cases.
     *
     * @return The root node of the example tree.
     */
    private static TreeNode createExampleTree1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        return root;
    }

    /**
     * Creates the example tree for the third test case.
     *
     * @return The root node of the example tree.
     */
    private static TreeNode createExampleTree3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }
}
