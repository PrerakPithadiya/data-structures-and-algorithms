
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to the Combination Sum problem. It finds all
 * unique combinations of candidates where the chosen numbers sum to a target.
 */
class Solution {

    /**
     * Finds all unique combinations in candidates where the candidate numbers
     * sum to target.
     *
     * @param candidates An array of distinct positive integers representing
     * candidate numbers.
     * @param target The target sum to achieve.
     * @return A list of all unique combinations that sum to target.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     * A recursive backtracking method to find combinations.
     *
     * @param result The list to store all valid combinations.
     * @param tempList The current combination being built.
     * @param candidates The array of candidate numbers.
     * @param remain The remaining sum to achieve.
     * @param start The starting index in candidates to consider.
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // Base case: if remain is 0, the current combination is valid
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Explore each candidate
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remain) {  // Only explore if the current candidate is <= remaining target
                tempList.add(candidates[i]); // Choose the current candidate
                // Recurse, but allow the same candidate (i) to be reused
                backtrack(result, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1); // Backtrack, remove the last added number
            }
        }
    }

    /**
     * Main method to demonstrate the usage of the combinationSum method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Find combinations that sum to 7 from [2, 3, 6, 7]
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));

        // Example 2: Find combinations that sum to 8 from [2, 3, 5]
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));

        // Example 3: Find combinations that sum to 1 from [2] (impossible)
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }
}
