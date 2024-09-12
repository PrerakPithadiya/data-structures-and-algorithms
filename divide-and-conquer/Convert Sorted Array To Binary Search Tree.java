
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Solution class for converting a sorted array to a balanced Binary Search Tree (BST).
 *
 * This class provides methods to construct a height-balanced BST from a sorted array.
 * A height-balanced binary tree is defined as a binary tree in which the depth of the
 * two subtrees of every node never differs by more than one.
 */
class Solution {

    /**
     * Converts a sorted array to a balanced Binary Search Tree.
     *
     * @param nums The sorted array of integers to be converted.
     * @return The root node of the constructed BST.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // Call the helper function to build the BST
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * Recursive helper method to construct the BST.
     *
     * @param nums The sorted array of integers.
     * @param left The left boundary of the current subarray.
     * @param right The right boundary of the current subarray.
     * @return The root node of the constructed subtree.
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        // Base case: if left > right, there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Choose the middle element as the root to keep the tree balanced
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively build the left subtree using the left half of the array
        root.left = buildBST(nums, left, mid - 1);

        // Recursively build the right subtree using the right half of the array
        root.right = buildBST(nums, mid + 1, right);

        // Return the root of the constructed subtree
        return root;
    }

    /**
     * Test cases for the sortedArrayToBST method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty array
        int[] nums1 = {};
        TreeNode result1 = solution.sortedArrayToBST(nums1);
        System.out.println("Test case 1 result: " + (result1 == null ? "PASS" : "FAIL"));

        // Test case 2: Array with one element
        int[] nums2 = {1};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        System.out.println("Test case 2 result: " + (result2.val == 1 && result2.left == null && result2.right == null ? "PASS" : "FAIL"));

        // Test case 3: Array with multiple elements
        int[] nums3 = {-10, -3, 0, 5, 9};
        TreeNode result3 = solution.sortedArrayToBST(nums3);
        System.out.println("Test case 3 result: " + (isValidBST(result3) ? "PASS" : "FAIL"));

        // Test case 4: Array with even number of elements
        int[] nums4 = {1, 3, 5, 7};
        TreeNode result4 = solution.sortedArrayToBST(nums4);
        System.out.println("Test case 4 result: " + (isValidBST(result4) ? "PASS" : "FAIL"));
    }

    /**
     * Helper method to validate if a tree is a valid BST.
     *
     * @param root The root node of the tree to be validated.
     * @return true if the tree is a valid BST, false otherwise.
     */
    private static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    /**
     * Recursive helper method to validate BST properties.
     *
     * @param node The current node being checked.
     * @param min The minimum value the current node can have.
     * @param max The maximum value the current node can have.
     * @return true if the subtree rooted at node is a valid BST, false
     * otherwise.
     */
    private static boolean isValidBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }
}
