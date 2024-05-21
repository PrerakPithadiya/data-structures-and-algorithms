package linkedlist;

public class RemoveNthNodeFromEnd {

    /**
     * Removes the nth node from the end of the linked list.
     *
     * This method first calculates the size of the linked list, then finds the node just before
     * the nth node from the end and adjusts the pointers to remove the nth node.
     *
     * @param head the head of the linked list
     * @param n the position from the end of the list of the node to remove
     * @return the head of the modified linked list
     * @throws IllegalArgumentException if n is greater than the size of the list
     */
    public Node removeNthFromEnd(Node head, int n) {
        int listSize = size(head);

        // Handle invalid n values
        if (n > listSize || n <= 0) {
            throw new IllegalArgumentException("Invalid value of n: " + n);
        }

        // If n equals the size, remove the head node
        if (n == listSize) {
            return head.next;
        }

        int targetIndex = listSize - n - 1;
        Node currentNode = head;
        for (int currentIndex = 0; currentIndex < targetIndex; currentIndex++) {
            currentNode = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }

        return head;
    }

    /**
     * Calculates the size of the linked list.
     *
     * @param head the head of the linked list
     * @return the size of the linked list
     */
    public int size(Node head) {
        int size = 0;
        Node currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    // Node class representing each element in the linked list
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
