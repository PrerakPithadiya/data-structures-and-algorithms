
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides a solution for constructing a binary tree from its
 * inorder and postorder traversals.
 */
class Solution {

    /**
     * Map to store the indices of values in the inorder traversal for quick
     * lookup.
     */
    private Map<Integer, Integer> inorderMap;

    /**
     * Constructs a binary tree from its inorder and postorder traversals.
     *
     * @param inorder The inorder traversal of the binary tree.
     * @param postorder The postorder traversal of the binary tree.
     * @return The root node of the constructed binary tree.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build a hashmap to store value -> index relations for inorder traversal
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * Recursively builds a subtree of the binary tree.
     *
     * @param postorder The postorder traversal of the binary tree.
     * @param postorderIndex The current index in the postorder traversal.
     * @param inorderLeft The left boundary of the current subtree in the
     * inorder traversal.
     * @param inorderRight The right boundary of the current subtree in the
     * inorder traversal.
     * @return The root node of the constructed subtree.
     */
    private TreeNode buildSubtree(int[] postorder, int postorderIndex, int inorderLeft, int inorderRight) {
        // Base case: if there are no elements to construct the subtree
        if (inorderLeft > inorderRight) {
            return null;
        }

        // The current root is the last element in the postorder traversal
        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the current root in the inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively build the right and left subtrees
        root.right = buildSubtree(postorder, postorderIndex - 1, inorderIndex + 1, inorderRight);
        root.left = buildSubtree(postorder, postorderIndex - 1 - (inorderRight - inorderIndex), inorderLeft, inorderIndex - 1);

        return root;
    }

    /**
     * Test cases for the buildTree method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        System.out.println("Test case 1 result: " + isValidBST(root1));

        // Test case 2
        int[] inorder2 = {-1};
        int[] postorder2 = {-1};
        TreeNode root2 = solution.buildTree(inorder2, postorder2);
        System.out.println("Test case 2 result: " + isValidBST(root2));

        // Test case 3
        int[] inorder3 = {1, 2, 3, 4, 5};
        int[] postorder3 = {5, 4, 3, 2, 1};
        TreeNode root3 = solution.buildTree(inorder3, postorder3);
        System.out.println("Test case 3 result: " + isValidBST(root3));
    }

    /**
     * Helper method to validate if the constructed tree is a valid binary
     * search tree. This is used for testing purposes.
     *
     * @param root The root node of the binary tree.
     * @return True if the tree is a valid BST, false otherwise.
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
