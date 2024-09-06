
import java.util.HashSet;

/**
 * This class provides a solution for removing elements from a linked list based
 * on values present in an array.
 */
class Solution {

    /**
     * Definition for singly-linked list node.
     */
    public static class ListNode {

        int val;
        ListNode next;

        /**
         * Constructor for ListNode.
         *
         * @param x The value to be stored in the node.
         */
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Removes elements from the linked list if their values are present in the
     * given array.
     *
     * @param head The head of the linked list.
     * @param nums An array of integers. Nodes with values present in this array
     * will be removed.
     * @return The head of the modified linked list.
     */
    public ListNode removeElements(ListNode head, int[] nums) {
        // Create a set to store the values from nums for O(1) lookup.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        // Create a dummy node to handle edge cases like removing the head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Use two pointers: prev (previous node) and curr (current node).
        ListNode prev = dummy, curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                // If the current node's value exists in nums, skip it.
                prev.next = curr.next;
            } else {
                // Otherwise, move prev pointer to current node.
                prev = curr;
            }
            // Move current pointer to the next node.
            curr = curr.next;
        }

        // Return the new head, which is dummy.next.
        return dummy.next;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Remove multiple elements
        ListNode head1 = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        int[] nums1 = {2, 4, 6};
        ListNode result1 = solution.removeElements(head1, nums1);
        System.out.println("Test case 1 result: " + linkedListToString(result1));
        // Expected output: 1->3->5

        // Test case 2: Remove all elements
        ListNode head2 = createLinkedList(new int[]{1, 1, 1});
        int[] nums2 = {1};
        ListNode result2 = solution.removeElements(head2, nums2);
        System.out.println("Test case 2 result: " + linkedListToString(result2));
        // Expected output: null

        // Test case 3: Remove no elements
        ListNode head3 = createLinkedList(new int[]{1, 2, 3});
        int[] nums3 = {4, 5, 6};
        ListNode result3 = solution.removeElements(head3, nums3);
        System.out.println("Test case 3 result: " + linkedListToString(result3));
        // Expected output: 1->2->3

        // Test case 4: Empty list
        ListNode head4 = null;
        int[] nums4 = {1, 2, 3};
        ListNode result4 = solution.removeElements(head4, nums4);
        System.out.println("Test case 4 result: " + linkedListToString(result4));
        // Expected output: null
    }

    /**
     * Helper method to create a linked list from an array of integers.
     *
     * @param arr The array of integers to create the linked list from.
     * @return The head of the created linked list.
     */
    private static ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Helper method to convert a linked list to a string representation.
     *
     * @param head The head of the linked list.
     * @return A string representation of the linked list.
     */
    private static String linkedListToString(ListNode head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append("->");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
