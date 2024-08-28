
/**
 * Online Stock Span Problem
 *
 * This class implements a solution to the Online Stock Span problem.
 * The stock span problem is the number of consecutive days prior to the current day,
 * where the price of the stock was less than or equal to the price at the current day.
 */
import java.util.Stack;

class StockSpanner {

    /**
     * Stack to store pairs of (price, span). Each element is an array where: -
     * index 0 represents the stock price - index 1 represents the span of that
     * price
     */
    private final Stack<int[]> stack;

    /**
     * Initializes the StockSpanner object.
     */
    public StockSpanner() {
        stack = new Stack<>();
    }

    /**
     * Calculates the span of the stock's price for the current day.
     *
     * @param price The price of the stock for the current day.
     * @return The span of the stock's price for the current day.
     */
    public int next(int price) {
        int span = 1;
        // Calculate the span by popping from the stack as long as the current price is greater or equal
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        // Push the current price and its calculated span onto the stack
        stack.push(new int[]{price, span});
        return span;
    }

    /**
     * Main method to demonstrate the functionality of the StockSpanner class.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        // Test cases
        System.out.println(stockSpanner.next(100)); // Output: 1
        System.out.println(stockSpanner.next(80));  // Output: 1
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(70));  // Output: 2
        System.out.println(stockSpanner.next(60));  // Output: 1
        System.out.println(stockSpanner.next(75));  // Output: 4
        System.out.println(stockSpanner.next(85));  // Output: 6
    }
}
