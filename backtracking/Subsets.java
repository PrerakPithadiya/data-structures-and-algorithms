
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for generating all possible subsets of a given
 * set of integers. It uses a backtracking algorithm to efficiently generate all
 * subsets.
 */
class Subsets {

    /**
     * Generates all possible subsets of the given array of integers.
     *
     * @param nums The input array of integers
     * @return A list of all possible subsets, where each subset is represented
     * as a list of integers
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    /**
     * A recursive backtracking method to generate all subsets.
     *
     * @param result The list to store all generated subsets
     * @param tempList The current subset being constructed
     * @param nums The input array of integers
     * @param start The starting index for considering elements in this
     * recursive call
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(tempList));

        // Explore further subsets
        for (int i = start; i < nums.length; i++) {
            // Add the number to the current subset
            tempList.add(nums[i]);
            // Recur to add more numbers to the subset
            backtrack(result, tempList, nums, i + 1);
            // Backtrack by removing the number and trying the next
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * Main method to demonstrate the usage of the Subsets class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Subsets subsets = new Subsets();

        // Example 1: Generate subsets for {1, 2, 3}
        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets of [1,2,3]: " + subsets.subsets(nums1));

        // Example 2: Generate subsets for {0}
        int[] nums2 = {0};
        System.out.println("Subsets of [0]: " + subsets.subsets(nums2));
    }
}

/*
 * Usage Instructions:
 * 1. Create an instance of the Subsets class.
 * 2. Call the subsets() method with an array of integers as the argument.
 * 3. The method will return a List<List<Integer>> containing all possible subsets.
 *
 * Example:
 *     Subsets subsetGenerator = new Subsets();
 *     int[] numbers = {1, 2, 3};
 *     List<List<Integer>> allSubsets = subsetGenerator.subsets(numbers);
 *
 * Time Complexity: O(2^n), where n is the number of elements in the input array.
 * Space Complexity: O(n) for the recursion stack, not counting the space used to store the output.
 */
