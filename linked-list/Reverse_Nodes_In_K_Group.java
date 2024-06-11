/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; this.next = next; }
 * }
 */

public class Solution {

    // Function to reverse nodes in k-group
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Current pointer for traversal
        ListNode current = head;
        // Previous pointer to connect reversed segments
        ListNode prevSegmentEnd = dummy;

        while (current != null) {
            // Start of the segment to be reversed
            ListNode segmentStart = current;
            int nodeCount = 0;

            // Traverse k nodes to check if there are enough nodes to reverse
            for (int i = 0; i < k && current != null; i++) {
                current = current.next;
                nodeCount++;
            }

            // If we have k nodes, reverse them
            if (nodeCount == k) {
                // Next segment start
                ListNode nextSegmentStart = current;
                // Reverse the segment
                ListNode reversedSegmentStart = reverseList(segmentStart, nextSegmentStart);
                // Connect the previous segment end to the reversed segment start
                prevSegmentEnd.next = reversedSegmentStart;
                // Update previous segment end to the original segment start
                prevSegmentEnd = segmentStart;
            } else {
                // Not enough nodes to reverse, link the remaining nodes
                prevSegmentEnd.next = segmentStart;
            }
        }

        return dummy.next;
    }

    // Function to reverse nodes between head and tail (exclusive)
    public static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode current = head;

        while (current != tail) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test the code with example inputs
        Solution solution = new Solution();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse in groups of k = 2
        int k = 2;
        ListNode newHead = solution.reverseKGroup(head, k);

        // Print the reversed list
        printList(newHead);  // Expected output: 2 1 4 3 5
    }
}
