class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should return the head of the modified list.
    public Node pairwiseSwap(Node head) {
        // If the list is empty or has only one node, no swap needed.
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers
        Node current = head;
        Node newHead = head.next; // New head will be the second node

        while (current != null && current.next != null) {
            Node first = current;
            Node second = current.next;
            Node nextPair = second.next; // The node after the pair

            // Swap nodes
            second.next = first;
            
            // Prepare for next swap
            if (nextPair == null || nextPair.next == null) {
                first.next = nextPair; // If no more pairs to swap, point to the remaining node
            } else {
                first.next = nextPair.next; // Point to the node after the next pair
            }

            // Move to the next pair
            current = nextPair;
        }

        return newHead;
    }

    // Helper method to create a linked list from an array
    public static Node createLinkedList(int[] elements) {
        if (elements.length == 0) return null;
        Node head = new Node(elements[0]);
        Node current = head;
        for (int i = 1; i < elements.length; i++) {
            current.next = new Node(elements[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the pairwiseSwap method
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {1, 2, 3, 4, 5};
        Node head = createLinkedList(elements);

        System.out.println("Original List:");
        printLinkedList(head);

        Node swappedHead = solution.pairwiseSwap(head);

        System.out.println("Swapped List:");
        printLinkedList(swappedHead);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
