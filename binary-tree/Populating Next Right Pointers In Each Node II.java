// Definition for a Node.

class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

/**
 * This class provides a solution to populate the next right pointers in each
 * node of a binary tree. It works for both perfect and non-perfect binary
 * trees.
 */
class Solution {

    /**
     * Connects nodes at the same level from left to right.
     *
     * @param root The root node of the binary tree.
     * @return The root node of the modified tree.
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node, which is the leftmost node of the top level
        Node leftmost = root;

        // Traverse level by level
        while (leftmost != null) {
            // Traverse the current level nodes
            Node current = leftmost;
            // Next level's first node
            Node nextLevelStart = null;
            // Previous node on the next level
            Node prev = null;

            // Reset leftmost for the next level
            leftmost = null;

            // Connect nodes at the current level and prepare for the next level
            while (current != null) {
                // Process left child
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        nextLevelStart = current.left;
                    }
                    prev = current.left;
                }

                // Process right child
                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        nextLevelStart = current.right;
                    }
                    prev = current.right;
                }

                // Move to the next node in the same level using the next pointer
                current = current.next;
            }

            // Move to the next level
            leftmost = nextLevelStart;
        }

        return root;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Perfect binary tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        solution.connect(root1);
        System.out.println("Test case 1 (Perfect binary tree):");
        printLevelOrder(root1);

        // Test case 2: Non-perfect binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        root2.right.right = new Node(7);

        solution.connect(root2);
        System.out.println("\nTest case 2 (Non-perfect binary tree):");
        printLevelOrder(root2);
    }

    /**
     * Helper method to print the level order traversal of the tree to verify
     * the next pointers.
     */
    private static void printLevelOrder(Node root) {
        if (root == null) {
            return;
        }

        Node current = root;
        while (current != null) {
            Node temp = current;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println("#"); // End of level
            current = current.left;
        }
    }
}

/*
Design and Implementation Notes:
- The solution uses a level-by-level approach to connect nodes.
- It maintains pointers to the leftmost node of each level and the previous node processed.
- The algorithm has a time complexity of O(N), where N is the number of nodes in the tree.
- The space complexity is O(1) as it only uses a constant amount of extra space.
- This solution works for both perfect and non-perfect binary trees.
 */
