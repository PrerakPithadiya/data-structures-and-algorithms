
import java.util.Stack;

/**
 * MinStack class implements a stack that supports push, pop, top, and
 * retrieving the minimum element in constant time.
 */
class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    /**
     * Initialize the MinStack data structure.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Push element val onto the stack.
     *
     * @param val The value to be pushed onto the stack.
     */
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Remove the element on the top of the stack.
     */
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    /**
     * Get the top element of the stack.
     *
     * @return The top element of the stack.
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Retrieve the minimum element in the stack.
     *
     * @return The minimum element in the stack.
     */
    public int getMin() {
        return minStack.peek();
    }

    /**
     * Main method to run test cases for the MinStack class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Test Case 1: Basic operations
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: -3
        minStack.pop();
        System.out.println("Top element: " + minStack.top()); // Expected output: 0
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: -2

        // Test Case 2: Push same value multiple times
        minStack = new MinStack();
        minStack.push(1);
        minStack.push(1);
        minStack.push(1);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 1
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 1

        // Test Case 3: Push decreasing values
        minStack = new MinStack();
        minStack.push(5);
        minStack.push(4);
        minStack.push(3);
        minStack.push(2);
        minStack.push(1);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 1
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 2
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 3

        // Test Case 4: Push increasing values
        minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(5);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 1
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected output: 1
        minStack.pop();
        System.out.println("Top element: " + minStack.top()); // Expected output: 3
    }
}
