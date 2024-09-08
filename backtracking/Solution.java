
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for generating all possible combinations of k
 * numbers chosen from the range [1, n] using a backtracking approach.
 */
class Solution {

    /**
     * Generates all possible combinations of k numbers chosen from the range
     * [1, n].
     *
     * @param n The upper bound of the range of numbers to choose from
     * (inclusive).
     * @param k The number of elements to be included in each combination.
     * @return A list of all possible combinations, where each combination is
     * represented as a list of integers.
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    /**
     * Recursive helper method that implements the backtracking algorithm to
     * generate combinations.
     *
     * @param result The list to store all valid combinations.
     * @param tempList The current combination being built.
     * @param start The starting number for the current iteration.
     * @param n The upper bound of the range of numbers.
     * @param k The desired size of each combination.
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base case: when the combination is of size k, add it to the result
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i); // Choose the current number
            backtrack(result, tempList, i + 1, n, k); // Explore further with the next number
            tempList.remove(tempList.size() - 1); // Backtrack, remove the last number chosen
        }
    }

    /**
     * Main method to demonstrate the usage of the combine method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2)); // Example 1: Generates combinations of 2 numbers from [1, 4]
        System.out.println(solution.combine(1, 1)); // Example 2: Generates combinations of 1 number from [1, 1]
    }
}

/*
 * Usage Instructions:
 * 1. Create an instance of the Solution class.
 * 2. Call the combine method with two parameters:
 *    - n: The upper bound of the range of numbers to choose from (inclusive).
 *    - k: The number of elements to be included in each combination.
 * 3. The method will return a List<List<Integer>> containing all possible combinations.
 *
 * Example:
 * Solution solution = new Solution();
 * List<List<Integer>> result = solution.combine(5, 3);
 * This will generate all possible combinations of 3 numbers chosen from the range [1, 5].
 *
 * Time Complexity: O(C(n,k) * k), where C(n,k) is the number of combinations.
 * Space Complexity: O(k) for the recursion stack, not counting the space used to store the result.
 */
