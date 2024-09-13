
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
 * Solution class for determining if a binary tree is symmetric.
 */
class Solution {

    /**
     * Determines if the given binary tree is symmetric.
     *
     * @param root The root node of the binary tree.
     * @return true if the tree is symmetric, false otherwise.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * Recursively checks if two subtrees are mirrors of each other.
     *
     * @param t1 The root of the first subtree.
     * @param t2 The root of the second subtree.
     * @return true if the subtrees are mirrors, false otherwise.
     */
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case: If both subtrees are null, they are mirrors
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one subtree is null, they are not mirrors
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check if current nodes are equal and their respective children are mirrors
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    /**
     * Main method for testing the Solution class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Symmetric tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);
        System.out.println("Test case 1 (Symmetric tree): " + solution.isSymmetric(root1));

        // Test case 2: Non-symmetric tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);
        System.out.println("Test case 2 (Non-symmetric tree): " + solution.isSymmetric(root2));

        // Test case 3: Empty tree
        TreeNode root3 = null;
        System.out.println("Test case 3 (Empty tree): " + solution.isSymmetric(root3));

        // Test case 4: Tree with only root
        TreeNode root4 = new TreeNode(1);
        System.out.println("Test case 4 (Tree with only root): " + solution.isSymmetric(root4));
    }
}
