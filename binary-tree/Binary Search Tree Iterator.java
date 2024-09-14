
import java.util.Stack;

/**
 * BSTIterator class implements an iterator for a Binary Search Tree (BST). It
 * provides methods to traverse the BST in-order iteratively.
 */
class BSTIterator {

    // Stack to simulate the in-order traversal iteratively
    private final Stack<TreeNode> stack;

    /**
     * Constructor initializes the stack and pushes all the leftmost nodes.
     *
     * @param root The root node of the BST
     */
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root);  // Push all left nodes starting from the root
    }

    /**
     * Helper function to push all the leftmost nodes of a subtree to the stack.
     *
     * @param node The starting node
     */
    private void pushLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    /**
     * Returns the next smallest number in the BST.
     *
     * @return The value of the next smallest node
     * @throws java.util.EmptyStackException if there are no more nodes
     */
    public int next() {
        TreeNode nextNode = stack.pop();  // Get the top (smallest) node
        if (nextNode.right != null) {
            // If the node has a right child, push all its left descendants
            pushLeftNodes(nextNode.right);
        }
        return nextNode.val;
    }

    /**
     * Checks if there are still nodes left to be visited.
     *
     * @return true if there are more nodes, false otherwise
     */
    public boolean hasNext() {
        return !stack.isEmpty();  // If stack is not empty, there's a next node
    }
}

/**
 * Test cases for the BSTIterator class.
 */
class BSTIteratorTest {

    public static void main(String[] args) {
        // Test case 1: Basic BST
        TreeNode root1 = new TreeNode(7);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(15);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(20);

        System.out.println("Test Case 1:");
        testBSTIterator(root1);

        // Test case 2: Left-skewed BST
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(1);

        System.out.println("\nTest Case 2:");
        testBSTIterator(root2);

        // Test case 3: Right-skewed BST
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);

        System.out.println("\nTest Case 3:");
        testBSTIterator(root3);

        // Test case 4: Empty BST
        TreeNode root4 = null;

        System.out.println("\nTest Case 4:");
        testBSTIterator(root4);
    }

    /**
     * Helper method to test the BSTIterator.
     *
     * @param root The root of the BST to test
     */
    private static void testBSTIterator(TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
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
