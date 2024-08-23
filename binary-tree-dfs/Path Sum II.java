
/**
 * This file contains the implementation of a solution to find paths in a binary tree
 * that sum up to a given target value.
 *
 * The solution uses a depth-first search (DFS) approach with a prefix sum technique
 * to efficiently count the number of paths that sum to the target value.
 */
import java.util.HashMap;

/**
 *

  ******** Represents a node in a binary tree.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Constructs a TreeNode with the given value.
     *
     * @param val The value to be stored in the node.
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 *

  ******** Solution class that implements the path sum algorithm.
 */
class Solution {

    /**
     * Counts the number of paths in the binary tree that sum up to the target
     * value.
     *
     * @param node The current node in the traversal.
     * @param targetSum The target sum we're looking for.
     * @param currentSum The running sum of the current path.
     * @param prefixSums A map to store the count of prefix sums encountered so
     * far.
     * @return The number of paths ending at or above the current node that sum
     * to targetSum.
     */
    private int countPaths(TreeNode node, long targetSum, long currentSum, HashMap<Long, Integer> prefixSums) {
        if (node == null) {
            return 0;
        }

        // Update the current sum
        currentSum += node.val;

        // Number of paths ending at the current node with sum = targetSum
        int paths = prefixSums.getOrDefault(currentSum - targetSum, 0);

        // Update the map with the current sum
        prefixSums.put(currentSum, prefixSums.getOrDefault(currentSum, 0) + 1);

        // Explore left and right subtrees
        paths += countPaths(node.left, targetSum, currentSum, prefixSums);
        paths += countPaths(node.right, targetSum, currentSum, prefixSums);

        // Remove the current sum from the map (backtracking)
        prefixSums.put(currentSum, prefixSums.get(currentSum) - 1);

        return paths;
    }

    /**
     * Main method to be called by users to find the number of paths that sum to
     * targetSum.
     *
     * @param root The root node of the binary tree.
     * @param targetSum The target sum to find paths for.
     * @return The total number of paths in the tree that sum to targetSum.
     */
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSums = new HashMap<>();
        // Initialize with sum 0 having one occurrence
        prefixSums.put(0L, 1);
        return countPaths(root, targetSum, 0L, prefixSums);
    }

    /**
     * Main method for testing the solution with example inputs.
     *
     * This method demonstrates how to use the Solution class with two example
     * binary trees. It constructs the trees, calls the pathSum method, and
     * prints the results.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);

        System.out.println("Number of paths (Example 1): " + solution.pathSum(root1, 8));  // Expected output: 3

        // Example 2: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);

        System.out.println("Number of paths (Example 2): " + solution.pathSum(root2, 22));  // Expected output: 3
    }
}
