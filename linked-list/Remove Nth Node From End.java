package linkedlist;

class RemoveNthNodeFromEnd {

    /**
     * Removes the nth node from the end of the linked list.
     * <p>
     * This method calculates the size of the linked list and determines the node to be removed
     * by finding its position from the beginning. If the nth node from the end is the head,
     * the head is updated. Otherwise, the appropriate node is skipped.
     *
     * @param head the head of the linked list
     * @param n    the position from the end of the node to be removed (1-based index)
     * @return the head of the modified linked list
     */
    public Node removeNthFromEnd(Node head, int n) {
        int size = getSize(head);

        // If the node to remove is the head
        if (n == size) {
            head = head.next;
            return head;
        }

        // Find the position to start removing from the beginning (0-based index)
        int targetIndex = size - n - 1;
        Node currentNode = head;

        // Traverse to the node just before the target node
        for (int currentIndex = 0; currentIndex < targetIndex; currentIndex++) {
            currentNode = currentNode.next;
        }

        // Skip the target node
        currentNode.next = currentNode.next.next;

        return head;
    }

    /**
     * Calculates the size of the linked list.
     * <p>
     * This method traverses the linked list and counts the number of nodes.
     *
     * @param head the head of the linked list
     * @return the size of the linked list
     */
    public int getSize(Node head) {
        int size = 0;
        Node currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    // Node class representing each element in the linked list
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
