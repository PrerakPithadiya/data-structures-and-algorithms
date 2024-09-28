
/**
 * MyCircularDeque implements a circular double-ended queue (deque) with a fixed size.
 * This data structure allows efficient insertion and deletion at both ends.
 */
class MyCircularDeque {

    private final int[] deque;
    private int front;
    private int rear;
    private final int size;

    /**
     * Initializes the deque with a maximum size of k.
     *
     * @param k The maximum number of elements that can be stored in the deque.
     */
    public MyCircularDeque(int k) {
        deque = new int[k + 1]; // We use k+1 size to differentiate between full and empty
        front = 0;
        rear = 0;
        size = k + 1;
    }

    /**
     * Inserts an element at the front of the deque.
     *
     * @param value The element to be inserted.
     * @return true if the operation is successful, false if the deque is full.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + size) % size; // Decrement front and wrap around
        deque[front] = value;
        return true;
    }

    /**
     * Inserts an element at the rear of the deque.
     *
     * @param value The element to be inserted.
     * @return true if the operation is successful, false if the deque is full.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        deque[rear] = value;
        rear = (rear + 1) % size; // Increment rear and wrap around
        return true;
    }

    /**
     * Deletes the front element from the deque.
     *
     * @return true if the operation is successful, false if the deque is empty.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size; // Increment front and wrap around
        return true;
    }

    /**
     * Deletes the rear element from the deque.
     *
     * @return true if the operation is successful, false if the deque is empty.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + size) % size; // Decrement rear and wrap around
        return true;
    }

    /**
     * Retrieves the front element of the deque.
     *
     * @return The front element, or -1 if the deque is empty.
     */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    /**
     * Retrieves the rear element of the deque.
     *
     * @return The rear element, or -1 if the deque is empty.
     */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[(rear - 1 + size) % size]; // Adjust rear to the previous element
    }

    /**
     * Checks if the deque is empty.
     *
     * @return true if the deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks if the deque is full.
     *
     * @return true if the deque is full, false otherwise.
     */
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    /**
     * Main method to run test cases for the MyCircularDeque class.
     */
    public static void main(String[] args) {
        // Test case 1: Basic operations
        MyCircularDeque deque1 = new MyCircularDeque(3);
        System.out.println(deque1.insertLast(1));  // returns true
        System.out.println(deque1.insertLast(2));  // returns true
        System.out.println(deque1.insertFront(3)); // returns true
        System.out.println(deque1.insertFront(4)); // returns false, deque is full
        System.out.println(deque1.getRear());      // returns 2
        System.out.println(deque1.isFull());       // returns true
        System.out.println(deque1.deleteLast());   // returns true
        System.out.println(deque1.insertFront(4)); // returns true
        System.out.println(deque1.getFront());     // returns 4

        // Test case 2: Empty deque operations
        MyCircularDeque deque2 = new MyCircularDeque(5);
        System.out.println(deque2.isEmpty());      // returns true
        System.out.println(deque2.deleteFront());  // returns false
        System.out.println(deque2.deleteLast());   // returns false
        System.out.println(deque2.getFront());     // returns -1
        System.out.println(deque2.getRear());      // returns -1

        // Test case 3: Edge case - deque with capacity 1
        MyCircularDeque deque3 = new MyCircularDeque(1);
        System.out.println(deque3.insertFront(1)); // returns true
        System.out.println(deque3.isFull());       // returns true
        System.out.println(deque3.insertLast(2));  // returns false
        System.out.println(deque3.getFront());     // returns 1
        System.out.println(deque3.deleteFront());  // returns true
        System.out.println(deque3.isEmpty());      // returns true
    }
}
