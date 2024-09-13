
import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Build a hashmap to store value -> index relations for inorder traversal
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(preorder, 0, 0, inorder.length - 1);
    }

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
}
