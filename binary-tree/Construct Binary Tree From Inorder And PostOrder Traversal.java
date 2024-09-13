
import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Build a hashmap to store value -> index relations for inorder traversal
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(postorder, postorder.length - 1, 0, inorder.length - 1);
    }

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
}
