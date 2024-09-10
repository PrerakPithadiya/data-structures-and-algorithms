
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: if head is null or left == right, no need to reverse
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to simplify the edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move `prev` to the node just before position `left`
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // `start` will point to the node at position `left`
        ListNode start = prev.next;
        // `then` will point to the node after `start`
        ListNode then = start.next;

        // Reverse the sublist between `left` and `right`
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        // Return the new head of the list
        return dummy.next;
    }

    // Helper function to print the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Creating a sample linked list: [1, 2, 3, 4, 5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse nodes between position 2 and 4
        head = solution.reverseBetween(head, 2, 4);

        // Print the modified linked list: [1, 4, 3, 2, 5]
        solution.printList(head);
    }
}
