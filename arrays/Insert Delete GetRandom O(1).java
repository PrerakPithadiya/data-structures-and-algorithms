
import java.util.*;

/**
 * RandomizedSet class implements a data structure that supports insert, remove,
 * and getRandom operations in O(1) time. This class uses a combination of
 * ArrayList and HashMap to achieve constant time complexity for all operations.
 */
class RandomizedSet {

    /**
     * HashMap to store the value and its index in the list. Key: The integer
     * value Value: The index of the value in the ArrayList
     */
    private final Map<Integer, Integer> valToIndex;

    /**
     * ArrayList to store the values. This allows for constant time access to
     * elements by index.
     */
    private final List<Integer> values;

    /**
     * Random object for generating random indices.
     */
    private final Random rand;

    /**
     * Constructor initializes the HashMap, ArrayList, and Random object.
     */
    public RandomizedSet() {
        valToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value into the set if it's not already present.
     *
     * @param val The value to be inserted
     * @return true if the value was inserted, false if it was already in the
     * set
     */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;  // Value already exists in the set
        }
        values.add(val);
        valToIndex.put(val, values.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set if it exists.
     *
     * @param val The value to be removed
     * @return true if the value was removed, false if it wasn't in the set
     */
    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;  // Value doesn't exist in the set
        }
        int idxToRemove = valToIndex.get(val);
        int lastVal = values.get(values.size() - 1);

        // Swap the element to remove with the last element
        values.set(idxToRemove, lastVal);
        valToIndex.put(lastVal, idxToRemove);

        // Remove the last element from the list and delete it from the map
        values.remove(values.size() - 1);
        valToIndex.remove(val);

        return true;
    }

    /**
     * Returns a random element from the set.
     *
     * @return A random element from the set
     * @throws IllegalStateException if the set is empty
     */
    public int getRandom() {
        if (values.isEmpty()) {
            throw new IllegalStateException("The set is empty");
        }
        int randomIndex = rand.nextInt(values.size());
        return values.get(randomIndex);
    }

    /**
     * Main method demonstrating the usage of RandomizedSet.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        System.out.println(randomizedSet.insert(1));  // Inserts 1 to the set. Returns true.
        System.out.println(randomizedSet.remove(2));  // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2));  // Inserts 2. Returns true.
        System.out.println(randomizedSet.getRandom()); // Returns either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1));  // Removes 1. Returns true.
        System.out.println(randomizedSet.insert(2));  // 2 is already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number, always return 2.
    }
}
