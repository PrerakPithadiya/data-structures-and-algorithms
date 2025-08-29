
class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    // Constructor to initialize an empty linked list
    LinkedList() {
        this.head = null;
    }

    // Method to add a new node with given data at the end of the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete nodes based on the given pattern
    public void deleteNodes(int m, int n) {
        Node i = head, j;

        while (i != null) {
            // Skip m nodes
            for (int k = 1; i != null && k < m; k++) {
                i = i.next;
            }

            if (i == null) {
                return; // No more nodes to delete
            }

            j = i.next;

            // Skip n nodes
            for (int k = 1; j != null && k <= n; k++) {
                j = j.next;
            }

            // Link i to j (skip n nodes)
            i.next = j;
            i = j;
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        // Create a new linked list
        LinkedList list = new LinkedList();

        // Add elements to the linked list: 1, 2, 3, 4, 5
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Display the linked list
        list.display();

        // Delete nodes based on pattern (e.g., m = 2, n = 1)
        list.deleteNodes(2, 1);

        // Display the modified linked list after deletion
        list.display();
    }
}
