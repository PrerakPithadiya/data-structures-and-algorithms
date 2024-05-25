package linkedlist;

public class PalindromicLinkedList {
    /**
     * Checks if a linked list is a palindrome.
     * 
     * @param head The head node of the linked list.
     * @return true if the linked list is a palindrome, false otherwise.
     */
    public boolean isPalindrome(ListNode head) {
        // Base case: An empty list or a single node list is always a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("Middle node found at value: " + (slowPointer != null ? slowPointer.data : "null"));

        // Step 2: Reverse the second half of the linked list
        ListNode previous = null;
        ListNode current = slowPointer;
        ListNode nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        // After reversing, previous will be the head of the reversed second half
        ListNode reversedHead = previous;
        System.out.print("Reversed second half: ");
        printList(reversedHead);

        // Step 3: Compare the first half with the reversed second half
        ListNode firstHalfPointer = head;
        ListNode secondHalfPointer = reversedHead;
        while (secondHalfPointer != null) {
            if (firstHalfPointer.data != secondHalfPointer.data) {
                return false;
            }
            firstHalfPointer = firstHalfPointer.next;
            secondHalfPointer = secondHalfPointer.next;
        }

        return true;
    }

    /**
     * Utility method to print the linked list from a given node.
     * 
     * @param node The starting node of the linked list to be printed.
     */
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    // ListNode class definition
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PalindromicLinkedList pll = new PalindromicLinkedList();
        System.out.println("Is the linked list a palindrome? " + pll.isPalindrome(node1));
    }
}
