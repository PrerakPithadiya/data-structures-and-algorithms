
/**
 * Definition for a binary tree node.
 * This class represents a node in a binary tree data structure.
 * Each node contains a value and references to its left and right child nodes.
 */
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
 * Solution class for reversing values at odd levels in a binary tree. LeetCode
 * Problem: Reverse Odd Levels of Binary Tree
 */
class Solution {

    /**
     * Reverses the values of nodes at odd levels in a binary tree. Level 0 is
     * the root level (even), level 1 is the first odd level, and so on.
     *
     * @param root The root node of the binary tree
     * @return The root node of the modified binary tree
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        reverseOddLevelsHelper(root.left, root.right, 1);
        return root;
    }

    /**
     * Helper method to recursively reverse values at odd levels. Uses a level
     * parameter to track even/odd levels and swaps values when needed.
     *
     * @param left Left node of the current pair
     * @param right Right node of the current pair
     * @param level Current level in the tree (0-based)
     */
    private void reverseOddLevelsHelper(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        reverseOddLevelsHelper(left.left, right.right, level + 1);
        reverseOddLevelsHelper(left.right, right.left, level + 1);
    }

    /**
     * Test cases to verify the functionality of reverseOddLevels method
     */
    public void runTests() {
        // Test Case 1: Single node tree
        TreeNode test1 = new TreeNode(1);
        assert reverseOddLevels(test1).val == 1 : "Test Case 1 Failed";

        // Test Case 2: Perfect binary tree with 3 levels
        TreeNode test2 = new TreeNode(2);
        test2.left = new TreeNode(3);
        test2.right = new TreeNode(5);
        test2.left.left = new TreeNode(8);
        test2.left.right = new TreeNode(13);
        test2.right.left = new TreeNode(21);
        test2.right.right = new TreeNode(34);
        TreeNode result2 = reverseOddLevels(test2);
        assert result2.left.val == 5 : "Test Case 2 Failed - Level 1 swap";
        assert result2.right.val == 3 : "Test Case 2 Failed - Level 1 swap";

        // Test Case 3: Null input
        assert reverseOddLevels(null) == null : "Test Case 3 Failed";

        // Test Case 4: Two level tree
        TreeNode test4 = new TreeNode(1);
        test4.left = new TreeNode(2);
        test4.right = new TreeNode(3);
        TreeNode result4 = reverseOddLevels(test4);
        assert result4.left.val == 3 : "Test Case 4 Failed";
        assert result4.right.val == 2 : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
