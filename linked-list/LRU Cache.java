
import java.util.HashMap;

/**
 * LRUCache implements a Least Recently Used (LRU) cache with a specified
 * capacity. It uses a combination of a HashMap and a doubly linked list to
 * achieve O(1) time complexity for both get and put operations.
 */
class LRUCache {

    /**
     * Node class for the doubly linked list. Each node contains a key-value
     * pair and pointers to the previous and next nodes.
     */
    class Node {

        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final HashMap<Integer, Node> cache;
    private final int capacity;
    private final Node head, tail; // Pointers to the front and back of the doubly linked list

    /**
     * Constructs an LRU cache with the specified capacity.
     *
     * @param capacity The maximum number of key-value pairs the cache can hold
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Initialize the doubly linked list with dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves the value associated with the given key if it exists in the
     * cache. This operation also marks the accessed item as most recently used.
     *
     * @param key The key to look up
     * @return The value associated with the key, or -1 if the key doesn't exist
     * in the cache
     */
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Move the accessed node to the front (most recently used)
        Node node = cache.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    /**
     * Inserts a key-value pair into the cache. If the key already exists, its
     * value is updated. If the cache is at capacity, the least recently used
     * item is evicted before insertion.
     *
     * @param key The key to insert or update
     * @param value The value to be associated with the key
     */
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // Remove the old node
            remove(cache.get(key));
        } else if (cache.size() == capacity) {
            // Evict the least recently used item (from the back of the list)
            remove(tail.prev);
        }

        // Insert the new node at the front (most recently used)
        insertAtFront(new Node(key, value));
    }

    /**
     * Helper method to remove a node from the doubly linked list and the cache.
     *
     * @param node The node to be removed
     */
    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Helper method to insert a node at the front of the doubly linked list and
     * add it to the cache.
     *
     * @param node The node to be inserted
     */
    private void insertAtFront(Node node) {
        cache.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * Main method to demonstrate the usage of LRUCache.
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);  // cache is {1=1}
        lruCache.put(2, 2);  // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3);  // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4);  // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
