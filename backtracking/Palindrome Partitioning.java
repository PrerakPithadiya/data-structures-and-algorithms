
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution for the Palindrome Partitioning problem. It
 * finds all possible palindrome partitions of a given string.
 */
class PalindromePartitioning {

    /**
     * Partitions the input string into all possible palindrome combinations.
     *
     * @param s The input string to be partitioned
     * @return A list of all possible palindrome partitions
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    /**
     * Recursive backtracking method to find all palindrome partitions.
     *
     * @param result The list to store all valid partitions
     * @param tempList The current partition being built
     * @param s The input string
     * @param start The starting index for the current substring
     */
    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (isPalindrome(substring)) {
                tempList.add(substring);
                backtrack(result, tempList, s, end);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    /**
     * Checks if a given string is a palindrome.
     *
     * @param s The string to be checked
     * @return true if the string is a palindrome, false otherwise
     */
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Main method to demonstrate the usage of the PalindromePartitioning class.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();

        // Example 1
        String s1 = "aab";
        System.out.println("Palindrome partitions of 'aab': " + partitioning.partition(s1));

        // Example 2
        String s2 = "a";
        System.out.println("Palindrome partitions of 'a': " + partitioning.partition(s2));
    }
}
