
import java.util.*;

/**
 * This class provides a solution for grouping anagrams from an array of
 * strings.
 */
class Solution {

    /**
     * Groups anagrams from the given array of strings.
     *
     * @param strs An array of strings to be grouped into anagrams.
     * @return A list of lists, where each inner list contains a group of
     * anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store grouped anagrams
        // Key: Sorted string (anagram identifier)
        // Value: List of original strings that are anagrams of each other
        Map<String, List<String>> map = new HashMap<>();

        // Traverse each string in the input array
        for (String s : strs) {
            // Sort the characters in the string to get the key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            // Add the original string to the corresponding group in the map
            // If the key doesn't exist, create a new ArrayList and add the string
            // If the key exists, add the string to the existing list
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

    /**
     * Main method to demonstrate the usage of the groupAnagrams function.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Multiple anagrams
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Example 1 result: " + solution.groupAnagrams(strs1));

        // Example 2: Empty string
        String[] strs2 = {""};
        System.out.println("Example 2 result: " + solution.groupAnagrams(strs2));

        // Example 3: Single character
        String[] strs3 = {"a"};
        System.out.println("Example 3 result: " + solution.groupAnagrams(strs3));
    }
}

/**
 * Usage Instructions: 1. Create an instance of the Solution class. 2. Call the
 * groupAnagrams method with an array of strings as the argument. 3. The method
 * will return a List<List<String>> where each inner list contains a group of
 * anagrams.
 *
 * Example: Solution solution = new Solution(); String[] input = {"eat", "tea",
 * "tan", "ate", "nat", "bat"}; List<List<String>> result =
 * solution.groupAnagrams(input);
 *
 * Time Complexity: O(n * k * log(k)), where n is the number of strings and k is
 * the maximum length of a string. Space Complexity: O(n * k) to store the
 * HashMap and the result.
 */
