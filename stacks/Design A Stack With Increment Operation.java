
/**
 * CustomStack class implements a stack with an increment operation.
 * This stack has a fixed maximum size and supports push, pop, and increment operations.
 */
class CustomStack {

    private final int[] stack;  // Array to store stack elements
    private final int[] inc;    // Array to store increments
    private int top;            // Index of the top element in the stack

    /**
     * Initializes the CustomStack with a given maximum size.
     *
     * @param maxSize The maximum number of elements the stack can hold
     */
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
    }

    /**
     * Pushes an element onto the stack if it's not full.
     *
     * @param x The element to be pushed onto the stack
     */
    public void push(int x) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = x;
        }
    }

    /**
     * Pops the top element from the stack.
     *
     * @return The top element of the stack, or -1 if the stack is empty
     */
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int res = stack[top] + inc[top];
        if (top > 0) {
            inc[top - 1] += inc[top];  // Propagate increment to the next element down
        }
        inc[top] = 0;  // Clear the increment for this position
        top--;
        return res;
    }

    /**
     * Increments the bottom k elements of the stack by val. If there are less
     * than k elements in the stack, it increments all of them.
     *
     * @param k The number of bottom elements to increment
     * @param val The value to increment by
     */
    public void increment(int k, int val) {
        int limit = Math.min(k - 1, top);  // Only apply to the first `k` elements
        if (limit >= 0) {
            inc[limit] += val;  // Store the increment to be applied later
        }
    }

    /**
     * Main method to test the CustomStack implementation.
     */
    public static void main(String[] args) {
        // Test case 1: Basic operations
        CustomStack stack1 = new CustomStack(3);
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.pop());  // Expected: 2
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.increment(5, 100);
        System.out.println(stack1.pop());  // Expected: 103
        System.out.println(stack1.pop());  // Expected: 102
        System.out.println(stack1.pop());  // Expected: 101
        System.out.println(stack1.pop());  // Expected: -1 (stack is empty)

        // Test case 2: Edge cases
        CustomStack stack2 = new CustomStack(1);
        stack2.push(1);
        stack2.increment(1, 100);
        System.out.println(stack2.pop());  // Expected: 101
        stack2.push(2);
        stack2.push(3);  // This push should be ignored as the stack is full
        System.out.println(stack2.pop());  // Expected: 2
        System.out.println(stack2.pop());  // Expected: -1 (stack is empty)

        // Test case 3: Increment with empty stack
        CustomStack stack3 = new CustomStack(3);
        stack3.increment(3, 100);
        System.out.println(stack3.pop());  // Expected: -1 (stack is empty)
        stack3.push(1);
        System.out.println(stack3.pop());  // Expected: 101
    }
}
