
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for generating all possible permutations of a
 * given array of integers.
 */
class Solution {

    /**
     * Generates all possible permutations of the given array of integers.
     *
     * @param nums The input array of integers.
     * @return A list of all possible permutations, where each permutation is
     * represented as a list of integers.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    /**
     * Recursive backtracking method to generate permutations.
     *
     * @param result The list to store all generated permutations.
     * @param tempList The current permutation being built.
     * @param nums The original input array of integers.
     * @param used A boolean array to keep track of which elements have been
     * used in the current permutation.
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // Base case: if the current permutation is complete
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Explore each possibility
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // Skip used elements
            }
            // Choose the current element
            tempList.add(nums[i]);
            used[i] = true;
            // Explore further with the next elements
            backtrack(result, tempList, nums, used);
            // Backtrack by removing the last chosen element and marking it unused
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }

    /**
     * Main method to demonstrate the usage of the permute method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1, 2, 3})); // Example 1
        System.out.println(solution.permute(new int[]{0, 1}));    // Example 2
        System.out.println(solution.permute(new int[]{1}));       // Example 3
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * permute method with an array of integers as the argument. 3. The method will
 * return a List<List<Integer>> containing all possible permutations.
 *
 * Example: Solution solution = new Solution(); List<List<Integer>> permutations
 * = solution.permute(new int[]{1, 2, 3});
 *
 * Design: - The solution uses a backtracking algorithm to generate all
 * permutations. - It maintains a temporary list to build each permutation and a
 * boolean array to track used elements. - The algorithm explores all
 * possibilities by recursively choosing and un-choosing elements.
 *
 * Implementation Details: - The permute method initializes the backtracking
 * process. - The backtrack method is the core of the algorithm, recursively
 * building permutations. - Base case: When the temporary list size equals the
 * input array length, a complete permutation is added to the result. -
 * Recursive case: For each unused element, add it to the temporary list, mark
 * it as used, and recurse. - After recursion, backtrack by removing the last
 * added element and marking it as unused.
 *
 * Time Complexity: O(n!), where n is the number of elements in the input array.
 * Space Complexity: O(n) for the recursion stack and O(n!) for storing all
 * permutations.
 */
