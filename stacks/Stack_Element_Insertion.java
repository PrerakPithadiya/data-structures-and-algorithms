import java.util.Stack;

public class StackOperations {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(12);
        stack.push(50);
        stack.push(28);
        stack.push(33);
        stack.push(76);

        System.out.println("Stack before insertion: " + stack);

        try {
            insertAtPosition(stack, 2, 100); // Example usage: Insert 100 at position 2
            System.out.println("Stack after insertion at position 2: " + stack);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Inserts an element at the specified position in the stack.
     *
     * @param stack The stack where the element will be inserted.
     * @param position The position at which the element should be inserted (0-based index).
     * @param value The value to be inserted.
     */
    public static void insertAtPosition(Stack<Integer> stack, int position, int value) {
        int size = stack.size();

        // Validate the position
        if (position > size || position < 0) {
            throw new IndexOutOfBoundsException("Index " + position + " out of bounds for length " + size);
        }

        // If inserting at the top of the stack
        if (position == size) {
            stack.push(value);
            return;
        }

        Stack<Integer> tempStack = new Stack<>();

        // Transfer elements from the original stack to the temporary stack until the desired position is reached
        for (int i = 0; i < size - position; i++) {
            tempStack.push(stack.pop());
        }

        // Push the new value onto the original stack
        stack.push(value);

        // Transfer elements back from the temporary stack to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
