package linkedlist.singly;

/**
 * DeleteNthNodeFromLinkedList:
 * This class provides functionality to delete the nth node from a singly linked list.
 * It includes a method to perform the deletion and handles edge cases appropriately.
 */

class DeleteNthNodeFromLinkedList {

    /**
     * Method to delete the nth node from a singly linked list.
     *
     * @param head The head node of the singly linked list.
     * @param n The position (1-based index) of the node to be deleted.
     * @return Node - The head of the modified linked list.
     */
    public Node deleteNode(Node head, int n) {
        if (n == 1) {
            // If the node to be deleted is the head, return the next node as the new head.
            return head.next;
        }

        Node current = head;

        // Traverse to the node just before the nth node
        for (int i = 1; i <= n - 2; i++) {
            current = current.next;
        }

        // Bypass the nth node
        current.next = current.next.next;

        return head;
    }

    /**
     * Inner class to represent a node in the singly linked list.
     */
    static class Node {
        int data;
        Node next;

        /**
         * Constructor to initialize the node.
         *
         * @param data The value to be stored in the node.
         */
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Main method to test the functionality.
     *
     * Usage:
     * To compile and run the code:
     * 1. Save the file as DeleteNthNodeFromLinkedList.java
     * 2. Open a terminal and navigate to the directory containing the file.
     * 3. Compile the code using the command: javac DeleteNthNodeFromLinkedList.java
     * 4. Run the code using the command: java linkedlist.singly.DeleteNthNodeFromLinkedList
     *
     * Example:
     * - Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
     * - Deleting the 3rd node (value 3): 1 -> 2 -> 4 -> 5
     * - Expected output: List after deletion: 1 -> 2 -> 4 -> 5
     */
    public static void main(String[] args) {
        DeleteNthNodeFromLinkedList listModifier = new DeleteNthNodeFromLinkedList();

        // Creating a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Deleting the 3rd node from the linked list
        head = listModifier.deleteNode(head, 3);

        // Print the modified linked list
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        // Expected output: 1 2 4 5
    }
}

/**
 * Edge Cases:
 * - Deleting the head node (n = 1) is handled by returning the next node as the new head.
 * - The code assumes the list has at least n nodes; otherwise, it may throw a NullPointerException.
 *
 * Dependencies:
 * - This code does not have any external library dependencies and runs with standard Java SE.
 */
