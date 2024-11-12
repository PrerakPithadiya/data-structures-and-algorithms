package GFG;

/**
 * Node class represents a node in a linked list
 */
class Node {

    int data;
    Node next;

    /**
     * Constructor to create a new node
     *
     * @param data The data to be stored in the node
     */
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * Solution class containing method to find intersection point of two linked
 * lists
 */
class Solution {

    /**
     * Function to find intersection point in Y shaped Linked Lists. Time
     * Complexity: O(m + n) where m and n are lengths of the lists Space
     * Complexity: O(1)
     *
     * @param head1 Head of first linked list
     * @param head2 Head of second linked list
     * @return Data value at intersection point, or -1 if no intersection exists
     */
    int intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return -1; // If either list is empty, return -1
        }

        // Step 1: Calculate the lengths of both linked lists
        int length1 = 0, length2 = 0;
        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null) {
            length1++;
            current1 = current1.next;
        }

        while (current2 != null) {
            length2++;
            current2 = current2.next;
        }

        // Step 2: Align the starting points
        current1 = head1;
        current2 = head2;

        // If list1 is longer, advance its pointer
        if (length1 > length2) {
            for (int i = 0; i < length1 - length2; i++) {
                current1 = current1.next;
            }
        } else { // If list2 is longer, advance its pointer
            for (int i = 0; i < length2 - length1; i++) {
                current2 = current2.next;
            }
        }

        // Step 3: Traverse both lists together
        while (current1 != null && current2 != null) {
            if (current1 == current2) {
                return current1.data; // Intersection point found
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1; // No intersection found
    }

    /**
     * Test cases to verify the functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Lists intersect
        Node common = new Node(15);
        common.next = new Node(30);

        Node head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = common;

        Node head2 = new Node(10);
        head2.next = common;

        System.out.println("Test Case 1 - Expected: 15, Actual: " + solution.intersectPoint(head1, head2));

        // Test Case 2: Lists don't intersect
        Node list1 = new Node(1);
        list1.next = new Node(2);
        Node list2 = new Node(3);
        list2.next = new Node(4);

        System.out.println("Test Case 2 - Expected: -1, Actual: " + solution.intersectPoint(list1, list2));

        // Test Case 3: One empty list
        System.out.println("Test Case 3 - Expected: -1, Actual: " + solution.intersectPoint(null, list2));

        // Test Case 4: Both empty lists
        System.out.println("Test Case 4 - Expected: -1, Actual: " + solution.intersectPoint(null, null));
    }
}
