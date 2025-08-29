
import java.util.Scanner;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitLinkedListByPairwiseComparison {

    static Node first = null;  // Original list
    static Node list1 = null;  // First new list (for larger elements)
    static Node list2 = null;  // Second new list (for smaller elements)

    // Function to add node to original list
    static void addNode(int data) {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            return;
        }
        Node temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to add node to list1 (larger elements)
    static void addToList1(int data) {
        Node newNode = new Node(data);
        if (list1 == null) {
            list1 = newNode;
            return;
        }
        Node temp = list1;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to add node to list2 (smaller elements)
    static void addToList2(int data) {
        Node newNode = new Node(data);
        if (list2 == null) {
            list2 = newNode;
            return;
        }
        Node temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Function to split list based on pairwise comparison
    static void splitList() {
        Node current = first;

        while (current != null && current.next != null) {
            // Compare adjacent nodes
            if (current.data >= current.next.data) {
                addToList1(current.data);
                addToList2(current.next.data);
            } else {
                addToList1(current.next.data);
                addToList2(current.data);
            }
            current = current.next.next;  // Move to next pair
        }
    }

    // Function to print a list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of nodes: ");
            int n = scanner.nextInt();

            System.out.println("Enter " + n + " node values:");
            for (int i = 0; i < n; i++) {
                int value = scanner.nextInt();
                addNode(value);
            }

            System.out.println("\nOriginal LinkedList:");
            printList(first);

            splitList();

            System.out.println("\nList 1 (Larger elements):");
            printList(list1);

            System.out.println("List 2 (Smaller elements):");
            printList(list2);
        }
    }
}
