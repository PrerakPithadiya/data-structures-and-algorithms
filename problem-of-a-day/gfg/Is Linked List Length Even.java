package GFG;

/**
 * Solution class to check if a linked list has even length
 */
class Solution {

    /**
     * Determines if the length of a linked list is even
     *
     * @param head The head node of the linked list
     * @return true if length is even, false if odd
     */
    public boolean isLengthEven(Node head) {
        // Initialize a boolean flag for even or odd length
        boolean isEven = true;

        // Traverse the linked list
        Node current = head;
        while (current != null) {
            // Toggle the isEven flag for each node
            isEven = !isEven;
            current = current.next;
        }

        return isEven; // If true, length is even; if false, length is odd
    }

    /**
     * Test cases to verify the isLengthEven method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Empty list
        Node emptyList = null;
        System.out.println("Test Case 1 - Empty list: " + solution.isLengthEven(emptyList)); // Expected: true

        // Test Case 2: Single node
        Node singleNode = new Node(1);
        System.out.println("Test Case 2 - Single node: " + solution.isLengthEven(singleNode)); // Expected: false

        // Test Case 3: Even length list (2 nodes)
        Node evenList = new Node(1);
        evenList.next = new Node(2);
        System.out.println("Test Case 3 - Even length list: " + solution.isLengthEven(evenList)); // Expected: true

        // Test Case 4: Odd length list (3 nodes)
        Node oddList = new Node(1);
        oddList.next = new Node(2);
        oddList.next.next = new Node(3);
        System.out.println("Test Case 4 - Odd length list: " + solution.isLengthEven(oddList)); // Expected: false
    }
}

/**
 * Node class representing a node in the linked list
 */
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
