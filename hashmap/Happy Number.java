
/**
 * Solution class for determining if a number is a Happy Number.
 *
 * A Happy Number is defined as a number which eventually reaches 1 when replaced by the sum of the square of each digit.
 * If it's not a Happy Number, it will enter a cycle.
 */
class Solution {

    /**
     * Calculates the sum of squares of digits for a given number.
     *
     * @param n The input number
     * @return The sum of squares of digits
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int digit = n % 10;
            totalSum += digit * digit;
            n /= 10;
        }
        return totalSum;
    }

    /**
     * Determines if a number is a Happy Number.
     *
     * This method uses Floyd's Cycle Detection algorithm (also known as
     * Tortoise and Hare algorithm) to detect if the number will eventually
     * reach 1 or enter a cycle.
     *
     * @param n The number to check
     * @return true if the number is a Happy Number, false otherwise
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);      // Move slow pointer one step
            fast = getNext(getNext(fast));  // Move fast pointer two steps
        }

        return fast == 1;
    }

    /**
     * Main method to demonstrate the usage of the isHappy method.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println("Is 19 a Happy Number? " + solution.isHappy(19)); // Expected: true
        System.out.println("Is 2 a Happy Number? " + solution.isHappy(2));   // Expected: false
    }
}
