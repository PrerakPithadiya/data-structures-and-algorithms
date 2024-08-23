
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor for TreeNode.
     *
     * @param val The value of the node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * Solution class for determining if two binary trees are leaf-similar.
 */
class Solution {

    /**
     * Helper method to find the leaf sequence of a tree.
     *
     * @param node The current node being processed.
     * @param leafValues List to store the leaf values.
     */
    private void findLeaves(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }

        // Check if it is a leaf node
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        }

        // Recursively find leaves in the left and right subtrees
        findLeaves(node.left, leafValues);
        findLeaves(node.right, leafValues);
    }

    /**
     * Main method to check if two trees are leaf-similar. Two binary trees are
     * considered leaf-similar if their leaf value sequence is the same.
     *
     * @param root1 The root of the first tree.
     * @param root2 The root of the second tree.
     * @return true if the trees are leaf-similar, false otherwise.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // Find leaf sequences for both trees
        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);

        // Compare the two leaf sequences
        return leaves1.equals(leaves2);
    }

    /**
     * Main method to test the solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating the first tree: [3,5,1,6,2,9,8,null,null,7,4]
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        // Creating the second tree: [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        // Test if the two trees are leaf-similar
        boolean result = solution.leafSimilar(root1, root2);
        System.out.println("Are the two trees leaf-similar? " + result);  // Expected output: true
    }
}
