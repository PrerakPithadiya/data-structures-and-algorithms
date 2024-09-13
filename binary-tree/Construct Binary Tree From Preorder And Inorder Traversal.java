
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution for constructing a binary tree from its
 * preorder and inorder traversals.
 */
class Solution {

    /**
     * A map to store the indices of values in the inorder traversal for quick
     * lookup.
     */
    private Map<Integer, Integer> inorderMap;

    /**
     * Constructs a binary tree from its preorder and inorder traversals.
     *
     * @param preorder The preorder traversal of the binary tree.
     * @param inorder The inorder traversal of the binary tree.
     * @return The root node of the constructed binary tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a hashmap to store value -> index relations for inorder traversal
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(preorder, 0, 0, inorder.length - 1);
    }

    /**
     * Recursively builds a subtree of the binary tree.
     *
     * @param preorder The preorder traversal of the entire tree.
     * @param preorderIndex The current index in the preorder traversal.
     * @param inorderLeft The left boundary of the current subtree in the
     * inorder traversal.
     * @param inorderRight The right boundary of the current subtree in the
     * inorder traversal.
     * @return The root node of the constructed subtree.
     */
    private TreeNode buildSubtree(int[] preorder, int preorderIndex, int inorderLeft, int inorderRight) {
        // Base case: if there are no elements to construct the subtree
        if (inorderLeft > inorderRight) {
            return null;
        }

        // The current root is the first element in the preorder traversal
        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the current root in the inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively build the left and right subtrees
        root.left = buildSubtree(preorder, preorderIndex + 1, inorderLeft, inorderIndex - 1);
        root.right = buildSubtree(preorder, preorderIndex + 1 + inorderIndex - inorderLeft, inorderIndex + 1, inorderRight);

        return root;
    }

    /**
     * Test cases for the buildTree method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.println("Test case 1 result: " + isValidBST(root1));

        // Test case 2
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode root2 = solution.buildTree(preorder2, inorder2);
        System.out.println("Test case 2 result: " + isValidBST(root2));

        // Test case 3
        int[] preorder3 = {1, 2, 3};
        int[] inorder3 = {2, 1, 3};
        TreeNode root3 = solution.buildTree(preorder3, inorder3);
        System.out.println("Test case 3 result: " + isValidBST(root3));
    }

    /**
     * Helper method to validate if the constructed tree is a valid binary
     * search tree. This is used for testing purposes.
     *
     * @param root The root of the binary tree to validate.
     * @return true if the tree is a valid BST, false otherwise.
     */
    private static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if ((lower != null && node.val <= lower) || (upper != null && node.val >= upper)) {
            return false;
        }

        return isValidBSTHelper(node.left, lower, node.val) && isValidBSTHelper(node.right, node.val, upper);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
