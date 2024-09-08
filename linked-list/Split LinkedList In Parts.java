
/**
 * Definition for singly-linked list.
 * This class represents a node in a singly-linked list.
 */
class ListNode {

    int val;
    ListNode next;

    /**
     * Constructor for ListNode.
     *
     * @param x The value to be stored in this node.
     */
    ListNode(int x) {
        val = x;
    }
}

/**
 * Solution class containing the method to split a linked list into parts.
 */
class Solution {

    /**
     * Splits a linked list into k parts.
     *
     * This method takes a linked list and splits it into k parts. The parts are
     * as equally sized as possible, with the first few parts being larger if
     * the list can't be divided evenly.
     *
     * Algorithm: 1. Calculate the length of the linked list. 2. Determine the
     * size of each part and how many parts need an extra element. 3. Create k
     * parts by traversing the list and breaking it at appropriate points.
     *
     * Time Complexity: O(n), where n is the number of nodes in the linked list.
     * Space Complexity: O(k) for the result array, not counting the input.
     *
     * @param head The head of the linked list to be split.
     * @param k The number of parts to split the list into.
     * @return An array of ListNode, where each element is the head of a part.
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Find the total length of the list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Calculate the size of each part
        int partSize = length / k;  // Minimum size of each part
        int remainder = length % k; // Number of parts that should be 1 element larger

        ListNode[] result = new ListNode[k];
        current = head;

        // Step 3: Split the list into k parts
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode prev = null;
            int currentPartSize = partSize + (i < remainder ? 1 : 0); // Add 1 extra node to the first 'remainder' parts

            for (int j = 0; j < currentPartSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }

            if (prev != null) {
                prev.next = null; // Break the connection to form the current part
            }

            result[i] = partHead; // Store the head of the current part
        }

        return result;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty list
        ListNode[] result1 = solution.splitListToParts(null, 3);
        printResult(result1);

        // Test case 2: List with 1 node, k = 3
        ListNode head2 = new ListNode(1);
        ListNode[] result2 = solution.splitListToParts(head2, 3);
        printResult(result2);

        // Test case 3: List with 5 nodes, k = 3
        ListNode head3 = createList(new int[]{1, 2, 3, 4, 5});
        ListNode[] result3 = solution.splitListToParts(head3, 3);
        printResult(result3);

        // Test case 4: List with 7 nodes, k = 3
        ListNode head4 = createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode[] result4 = solution.splitListToParts(head4, 3);
        printResult(result4);
    }

    // Helper method to create a linked list from an array
    private static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the result
    private static void printResult(ListNode[] result) {
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            printList(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Helper method to print a single linked list
    private static void printList(ListNode head) {
        System.out.print("[");
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(", ");
            }
            head = head.next;
        }
        System.out.print("]");
    }
}
