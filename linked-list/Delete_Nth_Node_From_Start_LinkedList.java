package linkedlist.singly;

/**
 * Class to delete the nth node from a singly linked list.
 */
public class LinkedListModifier {

    /**
     * Method to delete the nth node from a singly linked list.
     *
     * @param head The head node of the singly linked list.
     * @param n The position (1-based index) of the node to be deleted.
     * @return Node - The head of the modified linked list.
     */
    public Node deleteNthNode(Node head, int n) {
        if (head == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: head cannot be null and n must be greater than 0.");
        }

        if (n == 1) {
            // If the node to be deleted is the head, return the next node as the new head.
            return head.next;
        }

        Node current = head;

        // Traverse to the node just before the nth node
        for (int i = 1; i < n - 1; i++) {
            if (current.next == null) {
                throw new IllegalArgumentException("Invalid input: n is larger than the list size.");
            }
            current = current.next;
        }

        // Bypass the nth node
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            throw new IllegalArgumentException("Invalid input: n is larger than the list size.");
        }

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
     * 1. Save the file as LinkedListModifier.java
     * 2. Open a terminal and navigate to the directory containing the file.
     * 3. Compile the code using the command: javac LinkedListModifier.java
     * 4. Run the code using the command: java linkedlist.singly.LinkedListModifier
     *
     * Example:
     * - Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
     * - Deleting the 3rd node (value 3): 1 -> 2 -> 4 -> 5
     * - Expected output: List after deletion: 1 -> 2 -> 4 -> 5
     */
    public static void main(String[] args) {
        LinkedListModifier listModifier = new LinkedListModifier();

        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        printList(head);

        // Deleting the 3rd node from the linked list
        head = listModifier.deleteNthNode(head, 3);

        System.out.println("List after deleting the 3rd node:");
        printList(head);
    }

    /**
     * Helper method to print the linked list.
     *
     * @param head The head node of the singly linked list.
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
 * - Deleting the head node (n = 1) is handled by returning the next node as the new head.
 * - The code checks for invalid inputs such as n being larger than the list size or being less than or equal to 0.
 * 
 * Dependencies:
 * - This code does not have any external library dependencies and runs with standard Java SE.
 */
