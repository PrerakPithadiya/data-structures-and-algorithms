// Definition for a Node.
class Node {
    int data;
    Node next;
    Node random;

    public Node(int val) {
        this.data = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    
    // Method to create a deep copy of a linked list with next and random pointers
    public Node copyRandomList(Node originalHead) {
        if (originalHead == null) {
            return null;
        }

        // Step 1: Create deep copy nodes and interleave them with the original list
        Node current = originalHead;
        while (current != null) {
            Node newNode = new Node(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        current = originalHead;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original list and the copied list
        Node copiedHead = originalHead.next;
        Node originalCurrent = originalHead;
        Node copiedCurrent = copiedHead;
        
        while (originalCurrent != null) {
            originalCurrent.next = originalCurrent.next.next;
            if (copiedCurrent.next != null) {
                copiedCurrent.next = copiedCurrent.next.next;
            }
            originalCurrent = originalCurrent.next;
            copiedCurrent = copiedCurrent.next;
        }

        return copiedHead;
    }

    // Helper method to print the linked list for debugging
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node data: " + current.data);
            if (current.random != null) {
                System.out.print(", Random points to: " + current.random.data);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create an example linked list with random pointers for testing
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = node1;
        node3.random = node5;
        node4.random = node2;
        node5.random = node4;

        Solution solution = new Solution();
        
        System.out.println("Original List:");
        solution.printList(node1);

        Node copiedList = solution.copyRandomList(node1);

        System.out.println("Copied List:");
        solution.printList(copiedList);
    }
}
