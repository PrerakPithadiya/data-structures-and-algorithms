
/**
 * Solution class for counting nodes in a complete binary tree.
 */
class Solution {

    /**
     * Counts the number of nodes in a complete binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The total number of nodes in the tree.
     */
    public int countNodes(TreeNode root) {
        // Base case: if the tree is empty
        if (root == null) {
            return 0;
        }

        // Get the heights of the leftmost and rightmost paths
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);

        // If leftHeight equals rightHeight, the tree is a perfect binary tree
        if (leftHeight == rightHeight) {
            // Number of nodes in a perfect binary tree is 2^height - 1
            return (1 << leftHeight) - 1; // This is 2^leftHeight - 1
        } else {
            // Recursively count the nodes in left and right subtrees
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    /**
     * Helper function to calculate the height of the tree.
     *
     * @param node The starting node.
     * @param isLeft Boolean flag to determine whether to traverse left or
     * right.
     * @return The height of the specified path.
     */
    private int getHeight(TreeNode node, boolean isLeft) {
        int height = 0;
        while (node != null) {
            height++;
            // Move to the leftmost or rightmost depending on isLeft
            node = isLeft ? node.left : node.right;
        }
        return height;
    }

    /**
     * Test cases for the countNodes method.
     */
    public void runTestCases() {
        // Test case 1: Empty tree
        TreeNode emptyTree = null;
        assert countNodes(emptyTree) == 0 : "Test case 1 failed";

        // Test case 2: Tree with only root
        TreeNode singleNodeTree = new TreeNode(1);
        assert countNodes(singleNodeTree) == 1 : "Test case 2 failed";

        // Test case 3: Perfect binary tree with 7 nodes
        TreeNode perfectTree = new TreeNode(1);
        perfectTree.left = new TreeNode(2);
        perfectTree.right = new TreeNode(3);
        perfectTree.left.left = new TreeNode(4);
        perfectTree.left.right = new TreeNode(5);
        perfectTree.right.left = new TreeNode(6);
        perfectTree.right.right = new TreeNode(7);
        assert countNodes(perfectTree) == 7 : "Test case 3 failed";

        // Test case 4: Complete binary tree with 6 nodes
        TreeNode completeTree = new TreeNode(1);
        completeTree.left = new TreeNode(2);
        completeTree.right = new TreeNode(3);
        completeTree.left.left = new TreeNode(4);
        completeTree.left.right = new TreeNode(5);
        completeTree.right.left = new TreeNode(6);
        assert countNodes(completeTree) == 6 : "Test case 4 failed";

        System.out.println("All test cases passed successfully.");
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
