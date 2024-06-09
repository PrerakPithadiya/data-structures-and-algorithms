class Solution {
    // Function to delete every k-th node from the linked list.
    public Node deleteKthNode(Node head, int k) {
        // If k is 1, delete all nodes and return null.
        if (k == 1) {
            return null;
        }

        // Initialize pointers and position counter.
        Node previousNode = head;
        Node currentNode = head.next;
        Node newHead = head;
        int position = 2;

        // Check if the head itself needs to be removed.
        if (position % k == 0) {
            newHead = previousNode.next;
            previousNode = newHead;
        }

        // Iterate through the list to remove every k-th node.
        while (currentNode != null) {
            if (position % k == 0) {
                previousNode.next = currentNode.next; // Remove k-th node
            } else {
                previousNode = previousNode.next; // Move previous pointer if not deleting
            }
            currentNode = currentNode.next; // Move current pointer
            position++;
        }

        return newHead; // Return the updated head of the list
    }

    // Node class representing a node in the linked list.
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Helper method to create a linked list from an array.
    public Node createLinkedList(int[] elements) {
        if (elements.length == 0) return null;
        Node head = new Node(elements[0]);
        Node current = head;
        for (int i = 1; i < elements.length; i++) {
            current.next = new Node(elements[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list.
    public void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the deleteKthNode method.
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = solution.createLinkedList(elements);

        System.out.println("Original List:");
        solution.printLinkedList(head);

        int k = 3;
        Node updatedHead = solution.deleteKthNode(head, k);

        System.out.println("List after deleting every " + k + "-th node:");
        solution.printLinkedList(updatedHead);
    }
}
