package linkedlist.singly;

/**
 * Overview:
 * The CircularLinkedListChecker class provides functionality to determine whether a singly linked list is circular.
 * A linked list is considered circular if there is a node in the list whose `next` pointer points back to one of the previous nodes in the list, forming a loop.
 */

class CircularLinkedListChecker {
    
    /**
     * Method to determine if the linked list is circular.
     *
     * @param head The head node of the singly linked list.
     * @return boolean - true if the linked list is circular, false otherwise.
     */
    public boolean isCircular(Node head) {
        if (head == null) {
            // An empty list is not circular
            return false;
        }

        // Initialize the current node to the head of the list
        Node currentNode = head;

        // Traverse the linked list
        while (currentNode != null) {
            // If the next node points back to the head, it's circular
            if (currentNode.next == head) {
                return true;
            }

            // Move to the next node
            currentNode = currentNode.next;
        }

        // If we reach the end of the list, it's not circular
        return false;
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
     * 1. Save the file as CircularLinkedListChecker.java
     * 2. Open a terminal and navigate to the directory containing the file.
     * 3. Compile the code using the command: javac CircularLinkedListChecker.java
     * 4. Run the code using the command: java linkedlist.singly.CircularLinkedListChecker
     *
     * Example of input and expected output:
     * - Creating a non-circular linked list: 1 -> 2 -> 3
     *   Expected output: "Is the linked list circular? false"
     *
     * - Creating a circular linked list: 1 -> 2 -> 3 -> 1 (points back to the head)
     *   Expected output: "Is the linked list circular? true"
     */
    public static void main(String[] args) {
        CircularLinkedListChecker checker = new CircularLinkedListChecker();

        // Creating a non-circular linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Check if the linked list is circular
        System.out.println("Is the linked list circular? " + checker.isCircular(head)); // Expected output: false

        // Creating a circular linked list
        Node headCircular = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        headCircular.next = second;
        second.next = third;
        third.next = headCircular; // Making it circular

        // Check if the linked list is circular
        System.out.println("Is the linked list circular? " + checker.isCircular(headCircular)); // Expected output: true
    }
}

/**
 * Edge Cases:
 * - The code handles the edge case of an empty list by returning false.
 * - The code properly identifies a circular linked list regardless of its length.
 * 
 * Dependencies:
 * - This code does not have any external library dependencies and runs with standard Java SE.
 */
