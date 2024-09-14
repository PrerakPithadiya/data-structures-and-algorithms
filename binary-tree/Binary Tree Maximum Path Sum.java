
/**
 * Solution class for finding the maximum path sum in a binary tree.
 */
class Solution {

    /**
     * Global variable to store the maximum path sum. Initialized to the
     * smallest possible integer value.
     */
    private int maxSum = Integer.MIN_VALUE;

    /**
     * Finds the maximum path sum in a binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The maximum path sum in the binary tree.
     */
    public int maxPathSum(TreeNode root) {
        calculateMaxSum(root);
        return maxSum;
    }

    /**
     * Helper function to calculate the maximum path sum for a given node.
     *
     * @param node The current node being processed.
     * @return The maximum path sum that can be extended to the parent node.
     */
    private int calculateMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        int leftMax = Math.max(0, calculateMaxSum(node.left));  // If negative, ignore (consider 0)
        int rightMax = Math.max(0, calculateMaxSum(node.right)); // If negative, ignore (consider 0)

        // Calculate the maximum path sum including the current node as the root
        int currentMaxPath = node.val + leftMax + rightMax;

        // Update the global maximum path sum if the current path is larger
        maxSum = Math.max(maxSum, currentMaxPath);

        // Return the maximum path sum that can be extended to the parent node
        return node.val + Math.max(leftMax, rightMax);
    }

    /**
     * Test cases for the maxPathSum function.
     */
    public void runTestCases() {
        // Test case 1: Single node tree
        TreeNode root1 = new TreeNode(1);
        assert maxPathSum(root1) == 1 : "Test case 1 failed";

        // Test case 2: Binary tree with positive values
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(10);
        root2.left.left = new TreeNode(20);
        root2.left.right = new TreeNode(1);
        root2.right.right = new TreeNode(-25);
        root2.right.right.left = new TreeNode(3);
        root2.right.right.right = new TreeNode(4);
        assert maxPathSum(root2) == 42 : "Test case 2 failed";

        // Test case 3: Binary tree with negative values
        TreeNode root3 = new TreeNode(-10);
        root3.left = new TreeNode(9);
        root3.right = new TreeNode(20);
        root3.right.left = new TreeNode(15);
        root3.right.right = new TreeNode(7);
        assert maxPathSum(root3) == 42 : "Test case 3 failed";

        // Test case 4: Empty tree
        assert maxPathSum(null) == Integer.MIN_VALUE : "Test case 4 failed";

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

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Usage instructions: 1. Create an instance of the Solution class. 2. Call the
 * maxPathSum method with the root of your binary tree as the argument. 3. The
 * method will return the maximum path sum in the binary tree.
 *
 * Example usage: Solution solution = new Solution(); TreeNode root = new
 * TreeNode(1); root.left = new TreeNode(2); root.right = new TreeNode(3); int
 * result = solution.maxPathSum(root); System.out.println("Maximum path sum: " +
 * result);
 *
 * To run the test cases: solution.runTestCases();
 */
