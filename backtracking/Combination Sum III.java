
/**
 * This class provides a solution to the Combination Sum III problem.
 * The problem involves finding all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */
import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Finds all valid combinations of k numbers that sum up to n.
     *
     * @param k The number of integers in each combination.
     * @param n The target sum.
     * @return A list of all valid combinations.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    /**
     * A recursive backtracking method to find valid combinations.
     *
     * @param result The list to store all valid combinations.
     * @param combination The current combination being built.
     * @param k The remaining number of integers needed in the combination.
     * @param n The remaining sum to achieve.
     * @param start The starting number for the current iteration.
     */
    private void backtrack(List<List<Integer>> result, List<Integer> combination, int k, int n, int start) {
        if (combination.size() == k && n == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= 9; i++) {
            // Early stopping if adding the current number exceeds the sum
            if (i > n) {
                break;
            }
            combination.add(i);
            backtrack(result, combination, k, n - i, i + 1);
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    /**
     * Main method to run test cases and demonstrate the solution.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int k1 = 3;
        int n1 = 7;
        System.out.println("Test case 1:");
        System.out.println("k = " + k1 + ", n = " + n1);
        System.out.println("Result: " + solution.combinationSum3(k1, n1));

        // Test case 2
        int k2 = 3;
        int n2 = 9;
        System.out.println("\nTest case 2:");
        System.out.println("k = " + k2 + ", n = " + n2);
        System.out.println("Result: " + solution.combinationSum3(k2, n2));

        // Test case 3
        int k3 = 4;
        int n3 = 1;
        System.out.println("\nTest case 3:");
        System.out.println("k = " + k3 + ", n = " + n3);
        System.out.println("Result: " + solution.combinationSum3(k3, n3));
    }
}
