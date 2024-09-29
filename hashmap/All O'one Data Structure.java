
import java.util.*;

/**
 * AllOne class implements a data structure that supports constant time
 * operations for incrementing/decrementing a key's value and retrieving the key
 * with maximum/minimum value.
 */
class AllOne {

    /**
     * Node class representing a group of keys with the same count.
     */
    class Node {

        int count;           // Count value
        Set<String> keys;    // Set of keys with this count
        Node prev, next;     // Pointers for doubly linked list

        /**
         * Constructs a new Node with the given count.
         *
         * @param count The count value for this node.
         */
        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private final Map<String, Integer> key_count;  // Maps each key to its count
    private final Map<Integer, Node> count_node;   // Maps each count to its corresponding node
    private final Node head;  // Sentinel head of the doubly linked list
    private final Node tail;  // Sentinel tail of the doubly linked list

    /**
     * Initializes the AllOne data structure.
     */
    public AllOne() {
        key_count = new HashMap<>();
        count_node = new HashMap<>();
        head = new Node(0);  // Sentinel head
        tail = new Node(0);  // Sentinel tail
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Increments the count of the given key by 1.
     *
     * @param key The key to increment.
     */
    public void inc(String key) {
        int count = key_count.getOrDefault(key, 0);
        key_count.put(key, count + 1);

        if (count > 0) {
            removeKeyFromNode(count, key);
        }
        addKeyToNode(count + 1, key);
    }

    /**
     * Decrements the count of the given key by 1. If the count becomes 0, the
     * key is removed.
     *
     * @param key The key to decrement.
     */
    public void dec(String key) {
        int count = key_count.get(key);

        if (count == 1) {
            key_count.remove(key);
        } else {
            key_count.put(key, count - 1);
        }

        removeKeyFromNode(count, key);

        if (count > 1) {
            addKeyToNode(count - 1, key);
        }
    }

    /**
     * Returns one of the keys with the maximum count. Returns an empty string
     * if the structure is empty.
     *
     * @return A key with the maximum count, or an empty string if the structure
     * is empty.
     */
    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }
        return tail.prev.keys.iterator().next();
    }

    /**
     * Returns one of the keys with the minimum count. Returns an empty string
     * if the structure is empty.
     *
     * @return A key with the minimum count, or an empty string if the structure
     * is empty.
     */
    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }
        return head.next.keys.iterator().next();
    }

    /**
     * Removes a key from its corresponding count node.
     *
     * @param count The count of the key.
     * @param key The key to remove.
     */
    private void removeKeyFromNode(int count, String key) {
        Node node = count_node.get(count);
        node.keys.remove(key);
        if (node.keys.isEmpty()) {
            removeNodeFromList(node);
            count_node.remove(count);
        }
    }

    /**
     * Adds a key to its corresponding count node.
     *
     * @param count The count of the key.
     * @param key The key to add.
     */
    private void addKeyToNode(int count, String key) {
        Node node = count_node.get(count);
        if (node == null) {
            node = new Node(count);
            count_node.put(count, node);
            insertNodeIntoList(count, node);
        }
        node.keys.add(key);
    }

    /**
     * Removes a node from the doubly linked list.
     *
     * @param node The node to remove.
     */
    private void removeNodeFromList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Inserts a new node into the doubly linked list in the correct position.
     *
     * @param count The count of the new node.
     * @param newNode The new node to insert.
     */
    private void insertNodeIntoList(int count, Node newNode) {
        Node curr = head;
        while (curr.next != tail && curr.next.count < count) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next.prev = newNode;
        curr.next = newNode;
    }

    /**
     * Main method to run test cases for the AllOne class.
     */
    public static void main(String[] args) {
        AllOne obj = new AllOne();

        // Test case 1: Basic operations
        obj.inc("hello");
        obj.inc("hello");
        System.out.println("Max key: " + obj.getMaxKey());  // Expected: hello
        System.out.println("Min key: " + obj.getMinKey());  // Expected: hello

        // Test case 2: Multiple keys
        obj.inc("world");
        obj.inc("world");
        obj.inc("world");
        System.out.println("Max key: " + obj.getMaxKey());  // Expected: world
        System.out.println("Min key: " + obj.getMinKey());  // Expected: hello

        // Test case 3: Decrementing
        obj.dec("world");
        System.out.println("Max key: " + obj.getMaxKey());  // Expected: world
        obj.dec("world");
        System.out.println("Max key: " + obj.getMaxKey());  // Expected: hello

        // Test case 4: Empty structure
        AllOne emptyObj = new AllOne();
        System.out.println("Empty max key: " + emptyObj.getMaxKey());  // Expected: ""
        System.out.println("Empty min key: " + emptyObj.getMinKey());  // Expected: ""

        // Test case 5: Complex scenario
        obj.inc("a");
        obj.inc("b");
        obj.inc("b");
        obj.inc("c");
        obj.inc("c");
        obj.inc("c");
        obj.dec("b");
        obj.dec("b");
        System.out.println("Max key: " + obj.getMaxKey());  // Expected: c
        System.out.println("Min key: " + obj.getMinKey());  // Expected: a
    }
}
