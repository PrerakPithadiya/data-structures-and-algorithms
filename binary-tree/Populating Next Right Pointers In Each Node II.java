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
};

class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        // Start with the root node, which is the leftmost node of the top level
        Node leftmost = root;

        while (leftmost != null) {
            // Traverse the current level nodes
            Node current = leftmost;
            // Next level's first node
            Node nextLevelStart = null;
            // Previous node on the next level
            Node prev = null;

            // Reset leftmost for the next level
            leftmost = null;

            while (current != null) {
                // Check left child
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        nextLevelStart = current.left;
                    }
                    prev = current.left;
                }

                // Check right child
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
}
