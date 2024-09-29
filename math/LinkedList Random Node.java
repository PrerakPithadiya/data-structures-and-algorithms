
import java.util.Random;

/**
 * This class implements a solution for retrieving a random node from a linked
 * list. It uses the reservoir sampling algorithm to ensure each node has an
 * equal probability of being selected, regardless of the list's length.
 */
class Solution {

    private final ListNode head;
    private final Random random;

    /**
     * Constructor initializes the object with the head of the linked list.
     *
     * @param head The head node of the linked list.
     */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    /**
     * Retrieves a random node's value from the linked list. This method uses
     * reservoir sampling to ensure uniform distribution.
     *
     * @return The value of the randomly selected node.
     */
    public int getRandom() {
        ListNode current = head;
        int result = current.val; // Initially select the head value
        int i = 1;

        // Traverse the linked list
        while (current != null) {
            // Pick the current node with probability 1/i
            if (random.nextInt(i) == 0) {
                result = current.val;
            }
            i++;
            current = current.next;
        }

        return result; // Return the selected node's value
    }

    /**
     * Main method to demonstrate the usage of the Solution class and run test
     * cases.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test case 1: Single node
        ListNode singleNode = new ListNode(1);
        Solution solutionSingle = new Solution(singleNode);
        System.out.println("Test case 1 (Single node): " + solutionSingle.getRandom());

        // Test case 2: Multiple nodes
        ListNode multiNode = new ListNode(1);
        multiNode.next = new ListNode(2);
        multiNode.next.next = new ListNode(3);
        Solution solutionMulti = new Solution(multiNode);
        System.out.println("Test case 2 (Multiple nodes): " + solutionMulti.getRandom());

        // Test case 3: Multiple calls to getRandom
        System.out.println("Test case 3 (Multiple calls):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Call " + (i + 1) + ": " + solutionMulti.getRandom());
        }
    }
}

/**
 * Definition for singly-linked list. This class represents a node in a
 * singly-linked list.
 */
class ListNode {

    int val;
    ListNode next;

    /**
     * Constructor to create a new ListNode with a given value.
     *
     * @param val The value to be stored in the node.
     */
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
