
class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        // Create a sentinel node to simplify edge cases
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        // prev is the last node before the duplicates start
        ListNode prev = sentinel;

        while (head != null) {
            // Check if the current node is a duplicate
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with the same value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Link prev to the node after the duplicates
                prev.next = head.next;
            } else {
                // No duplicate, move prev to head
                prev = prev.next;
            }
            // Move head forward
            head = head.next;
        }

        // Return the new list without duplicates
        return sentinel.next;
    }
}
