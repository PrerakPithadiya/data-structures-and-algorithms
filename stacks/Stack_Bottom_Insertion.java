
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class StackInsertExample {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(12);
            stack.push(50);
            stack.push(28);
            stack.push(33);
            stack.push(76);

            System.out.println("Stack before insertion: " + stack);

            System.out.print("Enter the value to insert at the bottom of the stack: ");
            int valueToInsert = scanner.nextInt();

            insertAtBottom(stack, valueToInsert);

            System.out.println("Stack after insertion: " + stack);
        }
    }

    /**
     * Inserts a value at the bottom of the stack.
     *
     * @param stack The stack where the value will be inserted.
     * @param value The value to be inserted at the bottom.
     */
    public static void insertAtBottom(Deque<Integer> stack, int value) {
        Deque<Integer> tempStack = new ArrayDeque<>();

        // Transfer all elements from the original stack to the temporary stack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Push the new value to the original stack (which is now empty)
        stack.push(value);

        // Transfer all elements back from the temporary stack to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
