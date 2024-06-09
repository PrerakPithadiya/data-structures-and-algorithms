// ****************************************************
// Following is the LinkedListNode class for the Singly Linked List
// ****************************************************

class LinkedListNode {
    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {
    
    // Method to reverse a linked list
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null, current = head, next;

        while (current != null) {
            next = current.next;  // Store next node
            current.next = prev;  // Reverse current node's pointer
            prev = current;       // Move pointers one position ahead
            current = next;
        }

        return prev;  // New head of the reversed list
    }

    // Method to add the first half of the list to the reversed second half
    public static LinkedListNode addFirstAndReversedSecondHalf(LinkedListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Find the middle of the list
        LinkedListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        LinkedListNode secondHalf = slow.next;
        slow.next = null;

        // Step 2: Reverse the first half
        LinkedListNode firstHalf = reverse(head);

        // Step 3: Add corresponding elements of both halves
        LinkedListNode firstPtr = firstHalf, secondPtr = secondHalf, resultPtr = firstHalf;
        int sum, carry = 0, value;

        // Add corresponding elements from both halves
        while (firstPtr != null && secondPtr != null) {
            sum = firstPtr.data + secondPtr.data + carry;
            carry = sum / 10;
            value = sum % 10;
            resultPtr.data = value;
            resultPtr = resultPtr.next;
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        // Add remaining elements from the first half if any
        if (firstPtr != null) {
            sum = firstPtr.data + carry;
            carry = sum / 10;
            value = sum % 10;
            resultPtr.data = value;
        }

        // If there's any carry left, add a new node
        if (carry != 0) {
            resultPtr.next = new LinkedListNode(carry);
        }

        // Step 4: Reverse the result list to restore original order
        firstHalf = reverse(firstHalf);

        // Remove leading zeros if any
        while (firstHalf != null && firstHalf.next != null && firstHalf.data == 0) {
            firstHalf = firstHalf.next;
        }

        return firstHalf;
    }

    // Helper method to print the linked list
    public static void printList(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        System.out.println("Original List:");
        printList(head);

        LinkedListNode result = addFirstAndReversedSecondHalf(head);

        System.out.println("Modified List:");
        printList(result);
    }
}
