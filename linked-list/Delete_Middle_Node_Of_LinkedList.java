class Solution {
    // Function to delete the middle node of a linked list.
    public Node deleteMiddleNode(Node head) {
        // If the list is empty or has only one node, no middle node to delete.
        if (head == null || head.next == null) {
            return null;
        }
        
        // Initialize slow and fast pointers to find the middle node.
        Node slowPointer = head, fastPointer = head;
        
        // Move slow pointer by one step and fast pointer by two steps until fast pointer reaches the end.
        while (fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        // Delete the middle node by skipping it.
        slowPointer.next = slowPointer.next.next;
        
        // Return the updated head of the linked list.
        return head;
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

    // Main method to test the deleteMiddleNode method.
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {1, 2, 3, 4, 5};
        Node head = solution.createLinkedList(elements);

        System.out.println("Original List:");
        solution.printLinkedList(head);

        Node updatedHead = solution.deleteMiddleNode(head);

        System.out.println("List after deleting middle node:");
        solution.printLinkedList(updatedHead);
    }
}
