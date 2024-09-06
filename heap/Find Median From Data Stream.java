
import java.util.PriorityQueue;

/**
 * MedianFinder class for finding the median from a data stream. This class uses
 * two heaps to efficiently maintain the median of a growing dataset.
 */
class MedianFinder {

    // Max-heap to store the smaller half of the numbers
    private final PriorityQueue<Integer> lowerHalf;
    // Min-heap to store the larger half of the numbers
    private final PriorityQueue<Integer> upperHalf;

    /**
     * Constructor for MedianFinder. Initializes the two heaps used for storing
     * the data.
     */
    public MedianFinder() {
        // Max-heap: store negative values to simulate max-heap behavior in Java
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);
        // Min-heap: default behavior
        upperHalf = new PriorityQueue<>();
    }

    /**
     * Adds a number to the data structure.
     *
     * @param num The number to be added.
     */
    public void addNum(int num) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.offer(num);
        } else {
            upperHalf.offer(num);
        }

        // Balance the heaps: lowerHalf should not have more than one extra element compared to upperHalf
        if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.offer(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.offer(upperHalf.poll());
        }
    }

    /**
     * Finds the median of all elements added so far.
     *
     * @return The median as a double value.
     */
    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size()) {
            return lowerHalf.peek();
        } else {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        }
    }

    /**
     * Main method for testing the MedianFinder class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        // Test case 1: Adding numbers and finding median
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median after adding 1 and 2: " + medianFinder.findMedian()); // Expected: 1.5

        medianFinder.addNum(3);
        System.out.println("Median after adding 3: " + medianFinder.findMedian()); // Expected: 2.0

        // Test case 2: Adding more numbers
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        System.out.println("Median after adding 4 and 5: " + medianFinder.findMedian()); // Expected: 3.0

        // Test case 3: Adding a smaller number
        medianFinder.addNum(0);
        System.out.println("Median after adding 0: " + medianFinder.findMedian()); // Expected: 2.5

        // Test case 4: Adding duplicate numbers
        medianFinder.addNum(3);
        medianFinder.addNum(3);
        System.out.println("Median after adding two 3s: " + medianFinder.findMedian()); // Expected: 3.0
    }
}
