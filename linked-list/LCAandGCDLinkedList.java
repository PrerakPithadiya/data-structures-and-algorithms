
import java.util.Scanner;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LCAandGCDLinkedList {

    static Scanner scanner = new Scanner(System.in);

    // Function to find GCD using Euclidean algorithm
    static int findGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    // Function to find LCM using GCD
    static int findLCM(int a, int b) {
        return Math.abs(a * b) / findGCD(a, b);
    }

    // Function to insert a node after a given node
    static void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }

        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of nodes: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of nodes must be positive");
            return;
        }

        // Create the linked list
        System.out.println("Enter the values for nodes:");
        int firstValue = scanner.nextInt();
        Node head = new Node(firstValue);
        Node current = head;

        // Input remaining nodes
        for (int i = 1; i < n; i++) {
            int value = scanner.nextInt();
            current.next = new Node(value);
            current = current.next;
        }

        System.out.println("\nOriginal Linked List:");
        printList(head);

        // Process pairs and insert LCM and GCD
        current = head;
        while (current != null && current.next != null) {
            int num1 = current.data;
            int num2 = current.next.data;

            // Insert GCD and LCM between pairs
            insertAfter(current, findGCD(num1, num2));
            insertAfter(current.next, findLCM(num1, num2));

            // Move to the next original pair
            current = current.next.next.next;
        }

        System.out.println("\nLinked List after inserting GCD and LCM:");
        printList(head);
    }
}
