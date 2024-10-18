
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
 * Solution class for checking if a binary tree is a subtree of another binary
 * tree.
 */
class Solution {

    /**
     * Checks if the given subRoot is a subtree of the root.
     *
     * @param root The root of the main tree.
     * @param subRoot The root of the potential subtree.
     * @return true if subRoot is a subtree of root, false otherwise.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: if root is null, subRoot can't be a subtree of it
        if (root == null) {
            return false;
        }

        // Check if the trees rooted at current root and subRoot are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise, recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Helper function to check if two trees are identical.
     *
     * @param p The root of the first tree.
     * @param q The root of the second tree.
     * @return true if the trees are identical, false otherwise.
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If one is null but the other is not, they are not identical
        if (p == null || q == null) {
            return false;
        }
        // If the values of the current nodes are different, they are not identical
        if (p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Test cases for the isSubtree method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: subRoot is a subtree of root
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);

        System.out.println("Test case 1: " + solution.isSubtree(root1, subRoot1)); // Expected: true

        // Test case 2: subRoot is not a subtree of root
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(2);
        root2.left.right.left = new TreeNode(0);

        TreeNode subRoot2 = new TreeNode(4);
        subRoot2.left = new TreeNode(1);
        subRoot2.right = new TreeNode(2);

        System.out.println("Test case 2: " + solution.isSubtree(root2, subRoot2)); // Expected: false

        // Test case 3: root is null
        System.out.println("Test case 3: " + solution.isSubtree(null, subRoot1)); // Expected: false

        // Test case 4: subRoot is null
        System.out.println("Test case 4: " + solution.isSubtree(root1, null)); // Expected: false

        // Test case 5: both root and subRoot are null
        System.out.println("Test case 5: " + solution.isSubtree(null, null)); // Expected: false
    }
}
