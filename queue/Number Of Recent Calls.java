
/**
 * This class implements a counter for recent requests within a time frame.
 */
import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    /**
     * Queue to store the timestamps of recent requests.
     */
    private final Queue<Integer> queue;

    /**
     * Initializes a new RecentCounter with an empty queue.
     */
    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    /**
     * Records a new request at time t and returns the number of requests in the
     * last 3000 milliseconds.
     *
     * @param t The timestamp of the new request in milliseconds.
     * @return The number of requests that have happened in the last 3000
     * milliseconds (including the new request).
     */
    public int ping(int t) {
        // Add the new request time to the queue
        queue.offer(t);

        // Remove all the times from the queue that are older than (t - 3000)
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        // The size of the queue represents the number of requests in the last 3000 milliseconds
        return queue.size();
    }
}
