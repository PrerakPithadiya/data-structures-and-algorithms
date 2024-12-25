
import java.util.*;

/**
 * Definition for a binary tree node.
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
 * Solution class for finding the largest values in each row of a binary tree
 * Time Complexity: O(n) where n is the number of nodes in the tree Space
 * Complexity: O(w) where w is the maximum width of the tree
 */
class Solution {

    /**
     * Finds the largest value in each level/row of a binary tree using BFS
     *
     * @param root The root node of the binary tree
     * @return List containing the largest value from each level of the tree
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(maxVal);
        }
        return result;
    }

    /**
     * Test cases to verify the functionality of largestValues method
     */
    public void testLargestValues() {
        // Test Case 1: Normal binary tree
        //       1
        //      / \
        //     3   2
        //    / \   \
        //   5   3   9
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        assert largestValues(root1).equals(Arrays.asList(1, 3, 9)) : "Test Case 1 Failed";

        // Test Case 2: Single node tree
        TreeNode root2 = new TreeNode(1);
        assert largestValues(root2).equals(Arrays.asList(1)) : "Test Case 2 Failed";

        // Test Case 3: Empty tree
        TreeNode root3 = null;
        assert largestValues(root3).equals(new ArrayList<>()) : "Test Case 3 Failed";

        // Test Case 4: Left-skewed tree
        //      1
        //     /
        //    2
        //   /
        //  3
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        assert largestValues(root4).equals(Arrays.asList(1, 2, 3)) : "Test Case 4 Failed";

        // Test Case 5: Tree with negative values
        //       -1
        //      /  \
        //    -2   -3
        TreeNode root5 = new TreeNode(-1);
        root5.left = new TreeNode(-2);
        root5.right = new TreeNode(-3);
        assert largestValues(root5).equals(Arrays.asList(-1, -2)) : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
