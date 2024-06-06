package linkedlist.doubly;

/**
 * Class to reverse a doubly linked list.
 */
public class DoublyLinkedListReverser {

    /**
     * Method to reverse a doubly linked list.
     *
     * @param head The head node of the doubly linked list.
     * @return Node - The new head of the reversed doubly linked list.
     */
    public Node reverseList(Node head) {
        if (head == null) {
            return null; // If the list is empty, return null
        }

        Node previous = null, current = head, next;

        // Traverse through the doubly linked list
        while (current != null) {
            next = current.next;   // Store the next node
            current.next = previous;  // Reverse the next pointer
            current.prev = next;      // Reverse the prev pointer
            previous = current;       // Move previous to the current node
            current = next;           // Move to the next node
        }

        // Return the new head of the reversed list
        return previous;
    }

    /**
     * Inner class to represent a node in the doubly linked list.
     */
    static class Node {
        int data;
        Node next;
        Node prev;

        /**
         * Constructor to initialize the node.
         *
         * @param data The value to be stored in the node.
         */
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Main method to test the functionality.
     *
     * Usage:
     * To compile and run the code:
     * 1. Save the file as DoublyLinkedListReverser.java
     * 2. Open a terminal and navigate to the directory containing the file.
     * 3. Compile the code using the command: javac DoublyLinkedListReverser.java
     * 4. Run the code using the command: java linkedlist.doubly.DoublyLinkedListReverser
     *
     * Example:
     * - Creating a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
     * - Reversing the list: 5 <-> 4 <-> 3 <-> 2 <-> 1
     * - Expected output: List after reversing: 5 4 3 2 1
     */
    public static void main(String[] args) {
        DoublyLinkedListReverser listReverser = new DoublyLinkedListReverser();

        // Creating a doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;

        System.out.println("Original list:");
        printList(head);

        // Reversing the doubly linked list
        head = listReverser.reverseList(head);

        System.out.println("List after reversing:");
        printList(head);
    }

    /**
     * Helper method to print the doubly linked list.
     *
     * @param head The head node of the doubly linked list.
     */
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Edge Cases:
 * - Reversing an empty list (head is null) should return null.
 * - Reversing a list with only one node should return the same node.
 *
 * Dependencies:
 * - This code does not have any external library dependencies and runs with standard Java SE.
 */
