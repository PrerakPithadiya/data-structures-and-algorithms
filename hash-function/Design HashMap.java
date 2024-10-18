
/**
 * Implementation of a HashMap using a simple array-based approach.
 * This implementation assumes keys are non-negative integers in the range [0, 10^6].
 */
class MyHashMap {

    private final int[] map;

    /**
     * Initialize the HashMap with a fixed size array.
     */
    public MyHashMap() {
        map = new int[1000001]; // size 10^6 + 1 to cover the range 0 to 10^6
        // Initialize all entries to -1 indicating no key-value pair exists
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }

    /**
     * Inserts a (key, value) pair into the HashMap or updates the existing
     * value if the key already exists.
     *
     * @param key The key to insert or update
     * @param value The value to associate with the key
     */
    public void put(int key, int value) {
        map[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key.
     *
     * @param key The key whose associated value is to be returned
     * @return The value associated with the key, or -1 if the key is not found
     */
    public int get(int key) {
        return map[key];  // will return -1 if key is not mapped
    }

    /**
     * Removes the mapping for the specified key if this map contains the
     * mapping.
     *
     * @param key The key whose mapping is to be removed
     */
    public void remove(int key) {
        map[key] = -1;  // set the key's value to -1 to indicate it has been removed
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Test case 1: Put and get
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        assert hashMap.get(1) == 1 : "Test case 1 failed";
        assert hashMap.get(3) == -1 : "Test case 1 failed";

        // Test case 2: Update existing key
        hashMap.put(2, 1);
        assert hashMap.get(2) == 1 : "Test case 2 failed";

        // Test case 3: Remove
        hashMap.remove(2);
        assert hashMap.get(2) == -1 : "Test case 3 failed";

        // Test case 4: Edge cases
        hashMap.put(0, 0);
        hashMap.put(1000000, 1000000);
        assert hashMap.get(0) == 0 : "Test case 4 failed";
        assert hashMap.get(1000000) == 1000000 : "Test case 4 failed";

        System.out.println("All test cases passed!");
    }
}
