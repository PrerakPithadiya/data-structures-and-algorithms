
/**
 * Node class represents a node in a binary tree
 */
class Node {

    int data;
    Node left, right;

    /**
     * Constructor to create a new node
     *
     * @param value The data value to be stored in the node
     */
    Node(int value) {
        data = value;
        left = right = null;
    }
}

/**
 * Solution class contains methods to calculate sum of all root to leaf paths in
 * a binary tree
 */
class Solution {

    /**
     * Calculates the sum of all numbers formed by root to leaf paths
     *
     * @param root The root node of the binary tree
     * @return The sum of all path numbers
     */
    public static int treePathsSum(Node root) {
        return dfs(root, 0);
    }

    /**
     * Helper method that performs depth-first search to calculate path sums
     *
     * @param node Current node being processed
     * @param currentNumber Running number formed in the current path
     * @return Sum of numbers formed by paths through this node
     */
    private static int dfs(Node node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        // Update the current number for the path
        currentNumber = currentNumber * 10 + node.data;

        // If it's a leaf node, return the current path's number
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // Recurse on left and right children, summing up all paths
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        return leftSum + rightSum;
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        // Test Case 1: Simple tree with one path
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        // Expected sum: 12 + 13 = 25
        System.out.println("Test Case 1 Result: " + treePathsSum(root1));

        // Test Case 2: Tree with multiple levels
        Node root2 = new Node(6);
        root2.left = new Node(3);
        root2.right = new Node(5);
        root2.left.left = new Node(2);
        root2.left.right = new Node(5);
        root2.right.right = new Node(4);
        // Expected sum: 632 + 635 + 654 = 1921
        System.out.println("Test Case 2 Result: " + treePathsSum(root2));

        // Test Case 3: Single node tree
        Node root3 = new Node(5);
        // Expected sum: 5
        System.out.println("Test Case 3 Result: " + treePathsSum(root3));

        // Test Case 4: Empty tree
        // Expected sum: 0
        System.out.println("Test Case 4 Result: " + treePathsSum(null));
    }
}
