
/**
 * A simple implementation of a HashSet using a boolean array.
 * This implementation is suitable for a small range of non-negative integers (0 to 10^6).
 */
class MyHashSet {

    private final boolean[] set;

    /**
     * Initialize the HashSet with a fixed size array.
     */
    public MyHashSet() {
        set = new boolean[1000001]; // size 10^6 + 1 to cover the range 0 to 10^6
    }

    /**
     * Inserts the value key into the HashSet.
     *
     * @param key the value to be added
     */
    public void add(int key) {
        set[key] = true;
    }

    /**
     * Removes the value key from the HashSet, if present.
     *
     * @param key the value to be removed
     */
    public void remove(int key) {
        set[key] = false;
    }

    /**
     * Checks if the value key exists in the HashSet.
     *
     * @param key the value to be checked
     * @return true if the value exists, false otherwise
     */
    public boolean contains(int key) {
        return set[key];
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        // Test case 1: Adding elements
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println("Contains 1: " + myHashSet.contains(1)); // Expected: true
        System.out.println("Contains 3: " + myHashSet.contains(3)); // Expected: false

        // Test case 2: Removing an element
        myHashSet.remove(2);
        System.out.println("Contains 2 after removal: " + myHashSet.contains(2)); // Expected: false

        // Test case 3: Adding an element at the upper bound
        myHashSet.add(1000000);
        System.out.println("Contains 1000000: " + myHashSet.contains(1000000)); // Expected: true

        // Test case 4: Removing a non-existent element
        myHashSet.remove(3);
        System.out.println("Contains 3 after removal attempt: " + myHashSet.contains(3)); // Expected: false

        // Test case 5: Adding an already existing element
        myHashSet.add(1);
        System.out.println("Contains 1 after re-adding: " + myHashSet.contains(1)); // Expected: true
    }
}
