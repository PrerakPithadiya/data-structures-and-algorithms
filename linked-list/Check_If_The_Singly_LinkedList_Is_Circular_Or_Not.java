package linkedlist.singly;

// Class to check if a singly linked list is circular
class CircularLinkedListChecker {
    
    // Method to determine if the linked list is circular
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

    // Inner class to represent a node in the singly linked list
    static class Node {
        int data;
        Node next;

        // Constructor to initialize the node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Main method to test the functionality
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
