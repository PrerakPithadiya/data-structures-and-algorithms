/**
 * ListNode represents a node in a singly linked list.
 */
class ListNode {
    int value;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int value) { 
        this.value = value; 
    }
    
    ListNode(int value, ListNode next) { 
        this.value = value; 
        this.next = next; 
    }
}

/**
 * LinkedList class represents a singly linked list data structure.
 */
class LinkedList {
    ListNode head;

    // Method to insert a new node at the end of the list
    public void insert(int value) {
        if (head == null) {
            head = new ListNode(value);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    // Method to print the elements of the list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Solution class contains a method to partition a linked list around a given value.
 */
class Solution {
    /**
     * partitionLinkedList partitions the linked list around a given value x.
     * Nodes with values less than x come before nodes with values greater than or equal to x.
     * The relative order of nodes in each partition is preserved.
     *
     * @param head the head of the original linked list
     * @param x the integer value to partition the list around
     * @return the head of the modified linked list
     */
    public ListNode partitionLinkedList(ListNode head, int x) {
        // Initialize dummy nodes for less than x and greater than or equal to x lists
        ListNode lessThanX = new ListNode(0); // Dummy node for nodes less than x
        ListNode greaterThanOrEqualX = new ListNode(0); // Dummy node for nodes greater than or equal to x
        
        // Pointers for manipulating nodes and tracking heads of partitions
        ListNode lessThanXPointer = lessThanX, greaterThanOrEqualXPointer = greaterThanOrEqualX, current = head;
        
        // Traverse original list and partition
        while (current != null) {
            if (current.value < x) {
                // Append current node to the less than x list
                lessThanXPointer.next = current;
                // Move less than x pointer forward
                lessThanXPointer = current;
            } else {
                // Append current node to the greater than or equal to x list
                greaterThanOrEqualXPointer.next = current;
                // Move greater than or equal to x pointer forward
                greaterThanOrEqualXPointer = current;
            }
            // Move current pointer forward
            current = current.next;
        }

        // Combine the lists
        lessThanXPointer.next = greaterThanOrEqualX.next; // Connect less than x list to greater than or equal to x list
        greaterThanOrEqualXPointer.next = null;           // Terminate greater than or equal to x list
        
        // Return head of the modified list
        return lessThanX.next;
    }
}

/**
 * Main class contains the main method to test the LinkedList partitioning functionality.
 */
public class Main {
    public static void main(String[] args) {
        // Create a linked list
        LinkedList linkedList = new LinkedList();
        
        // Insert elements into the list
        linkedList.insert(3);
        linkedList.insert(5);
        linkedList.insert(8);
        linkedList.insert(5);
        linkedList.insert(10);
        linkedList.insert(2);
        linkedList.insert(1);
        
        // Print original list
        System.out.println("Original List:");
        linkedList.printList();
        
        // Define the partition value
        int x = 5;
        
        // Create an instance of Solution class
        Solution solution = new Solution();
        
        // Partition the list around x
        linkedList.head = solution.partitionLinkedList(linkedList.head, x);
        
        // Print modified list after partitioning
        System.out.println("List after partitioning around " + x + ":");
        linkedList.printList();
    }
}
