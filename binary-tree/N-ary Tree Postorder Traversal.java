
/**
 * This file contains the implementation of an N-ary Tree and its postorder traversal.
 *
 * @author [Your Name]
 * @version 1.0
 * @since [Date]
 */
import java.util.*;

/**
 * Node class for the n-ary tree. Each node contains a value and a list of child
 * nodes.
 */
class Node {

    public int val;
    public List<Node> children;

    /**
     * Default constructor. Initializes an empty list of children.
     */
    public Node() {
        this.children = new ArrayList<>();
    }

    /**
     * Constructor with value. Initializes the node with a given value and an
     * empty list of children.
     *
     * @param val The value of the node.
     */
    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    /**
     * Constructor with value and children. Initializes the node with a given
     * value and a list of children.
     *
     * @param val The value of the node.
     * @param children The list of child nodes.
     */
    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

/**
 * Solution class containing methods for N-ary Tree operations.
 */
class Solution {

    /**
     * Performs a postorder traversal of the n-ary tree.
     *
     * @param root The root node of the n-ary tree.
     * @return A list of integers representing the postorder traversal.
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(0, current.val);
            for (Node child : current.children) {
                stack.push(child);
            }
        }

        return result;
    }

    /**
     * Main method for testing the postorder traversal.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Example 1: Input: root = [1,null,3,2,4,null,5,6]
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> children3 = Arrays.asList(node5, node6);
        Node node3 = new Node(3, children3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> children1 = Arrays.asList(node3, node2, node4);
        Node root1 = new Node(1, children1);

        Solution solution = new Solution();
        List<Integer> result1 = solution.postorder(root1);
        System.out.println("Example 1 Output: " + result1); // Output: [5, 6, 3, 2, 4, 1]

        // Example 2: Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        Node node14 = new Node(14);
        Node node13 = new Node(13);
        Node node12 = new Node(12);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node9 = new Node(9);
        Node node8 = new Node(8, Arrays.asList(node12, node13));
        Node node7 = new Node(7, Arrays.asList(node11));
        Node node6_2 = new Node(6, Arrays.asList(node14));
        Node node5_2 = new Node(5, Arrays.asList(node9, node10));
        Node node4_2 = new Node(4, Arrays.asList(node8));
        Node node3_2 = new Node(3, Arrays.asList(node6_2, node7));
        Node node2_2 = new Node(2);
        List<Node> childrenRoot2 = Arrays.asList(node2_2, node3_2, node4_2, node5_2);
        Node root2 = new Node(1, childrenRoot2);

        List<Integer> result2 = solution.postorder(root2);
        System.out.println("Example 2 Output: " + result2); // Output: [14, 6, 11, 7, 3, 12, 13, 8, 4, 9, 10, 5, 2, 1]
    }
}
