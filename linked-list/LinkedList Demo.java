package linkedlist;

// Node class representing each element in the linked list
class Node {
    int data;    // Data stored in the node
    Node next;   // Reference to the next node

    // Constructor to initialize the node with data
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListDemo {
    public static void main(String[] args) {
        // Creating a linked list with five nodes
        Node head = createLinkedList();

        // Printing the linked list
        System.out.println("Linked List: " + getListAsString(head));
    }

    /**
     * Creates a linked list with five nodes and returns the head node.
     *
     * @return The head node of the created linked list.
     */
    public static Node createLinkedList() {
        // Creating nodes
        Node node1 = new Node(12);
        Node node2 = new Node(34);
        Node node3 = new Node(56);
        Node node4 = new Node(78);
        Node node5 = new Node(90);

        // Linking nodes to form the linked list
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Returning the head of the linked list
        return node1;
    }

    /**
     * Returns a string representation of the linked list starting from the given head node.
     *
     * @param head The head node of the linked list.
     * @return A string representation of the linked list.
     */
    public static String getListAsString(Node head) {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;

        // Traversing the linked list and appending data to the string builder
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
