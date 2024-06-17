package stacks;

import java.util.Random;
import java.util.Stack;

public class StackCopyUtility {
    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        fillStackWithRandomValues(originalStack);
        
        System.out.println("Original Stack: " + originalStack);
        
        Stack<Integer> copiedStack = copyStack(originalStack);
        
        System.out.println("Copied Stack: " + copiedStack);
    }

    /**
     * Copies the contents of the source stack to a new stack, maintaining the original order.
     *
     * @param sourceStack The stack to be copied.
     * @return A new stack with the same elements as the source stack.
     */
    public static Stack<Integer> copyStack(Stack<Integer> sourceStack) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();
        
        // Move elements from sourceStack to tempStack
        while (!sourceStack.isEmpty()) {
            tempStack.push(sourceStack.pop());
        }
        
        // Move elements from tempStack to both resultStack and back to sourceStack
        while (!tempStack.isEmpty()) {
            int value = tempStack.pop();
            resultStack.push(value);
            sourceStack.push(value); // Restoring the original stack
        }
        
        return resultStack;
    }

    /**
     * Fills the provided stack with random integer values.
     *
     * @param stack The stack to be filled with random values.
     */
    public static void fillStackWithRandomValues(Stack<Integer> stack) {
        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            stack.push(random.nextInt(100)); // Push a random integer between 0 and 99
        }
    }
}
