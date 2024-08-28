
/**
 * SmallestInfiniteSet class represents an infinite set of positive integers starting from 1.
 * It provides operations to pop the smallest element and add elements back to the set.
 */
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

    /**
     * The smallest integer currently available in the infinite set.
     */
    private int currentSmallest;

    /**
     * A min-heap to store integers that have been added back to the set.
     */
    private final PriorityQueue<Integer> minHeap;

    /**
     * A set to keep track of integers that have been added back to avoid
     * duplicates.
     */
    private final Set<Integer> addedBackSet;

    /**
     * Initializes the SmallestInfiniteSet with the smallest integer as 1.
     */
    public SmallestInfiniteSet() {
        currentSmallest = 1;
        minHeap = new PriorityQueue<>();
        addedBackSet = new HashSet<>();
    }

    /**
     * Removes and returns the smallest integer from the set.
     *
     * @return The smallest integer in the set.
     */
    public int popSmallest() {
        // If the heap is not empty, return the smallest element from the heap
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            addedBackSet.remove(smallest);
            return smallest;
        }
        // Otherwise, return currentSmallest and increment it
        return currentSmallest++;
    }

    /**
     * Adds a number back to the set if it's not already present.
     *
     * @param num The number to be added back to the set.
     */
    public void addBack(int num) {
        // Add num back to the heap only if it is smaller than currentSmallest
        // and not already present in the heap
        if (num < currentSmallest && !addedBackSet.contains(num)) {
            minHeap.add(num);
            addedBackSet.add(num);
        }
    }

    /**
     * Main method to demonstrate the functionality of SmallestInfiniteSet.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();

        smallestInfiniteSet.addBack(2); // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3

        smallestInfiniteSet.addBack(1); // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5
    }
}
