import java.util.Stack;
import java.util.Random;
import java.util.Scanner;

public class StackInsertExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
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
    
    /**
     * Inserts a value at the bottom of the stack.
     *
     * @param stack The stack where the value will be inserted.
     * @param value The value to be inserted at the bottom.
     */
    public static void insertAtBottom(Stack<Integer> stack, int value) {
        Stack<Integer> tempStack = new Stack<>();

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
