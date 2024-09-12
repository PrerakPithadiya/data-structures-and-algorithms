
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Solution class for sorting a singly-linked list using the merge sort algorithm.
 * This implementation uses a divide-and-conquer approach to achieve O(n log n) time complexity.
 */
class Solution {

    /**
     * Sorts a given linked list in ascending order.
     *
     * @param head The head of the linked list to be sorted.
     * @return The head of the sorted linked list.
     */
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;  // Split the list into two halves

        // Step 2: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    /**
     * Finds the middle node of the linked list using the slow and fast pointer
     * technique.
     *
     * @param head The head of the linked list.
     * @return The middle node of the linked list.
     */
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;  // Start fast one step ahead to find middle point

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // Slow is now pointing at the midpoint
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list.
     *
     * @param list1 The head of the first sorted linked list.
     * @param list2 The head of the second sorted linked list.
     * @return The head of the merged sorted linked list.
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();  // Dummy node to help with merging
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;  // Move the tail pointer
        }

        // Append the remaining nodes (if any)
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return dummy.next;  // Return the merged list starting from dummy's next
    }

    /**
     * Test cases for the sortList method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty list
        System.out.println("Test case 1:");
        printList(solution.sortList(null));

        // Test case 2: Single element list
        System.out.println("Test case 2:");
        printList(solution.sortList(new ListNode(1)));

        // Test case 3: Already sorted list
        System.out.println("Test case 3:");
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3)));
        printList(solution.sortList(head3));

        // Test case 4: Reverse sorted list
        System.out.println("Test case 4:");
        ListNode head4 = new ListNode(3, new ListNode(2, new ListNode(1)));
        printList(solution.sortList(head4));

        // Test case 5: Random order list
        System.out.println("Test case 5:");
        ListNode head5 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        printList(solution.sortList(head5));
    }

    /**
     * Helper method to print the linked list.
     *
     * @param head The head of the linked list to be printed.
     */
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
