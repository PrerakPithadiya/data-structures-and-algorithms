
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for finding the longest harmonious subsequence in an array.
 */
class Solution {

    /**
     * Finds the length of the longest harmonious subsequence in the given
     * array. A harmonious array is an array where the difference between its
     * maximum value and its minimum value is exactly 1.
     *
     * @param nums the input array of integers
     * @return the length of the longest harmonious subsequence
     */
    public int findLHS(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Step 2: Iterate through the frequency map and find the longest harmonious subsequence
        for (int num : freqMap.keySet()) {
            if (freqMap.containsKey(num + 1)) {
                int currentLength = freqMap.get(num) + freqMap.get(num + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        // Step 3: Return the longest length found
        return maxLength;
    }

    /**
     * Main method for testing the Solution class.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println("Test case 1: " + solution.findLHS(nums1)); // Expected output: 5

        // Test case 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Test case 2: " + solution.findLHS(nums2)); // Expected output: 2

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println("Test case 3: " + solution.findLHS(nums3)); // Expected output: 0

        // Test case 4
        int[] nums4 = {1, 2, 2, 1};
        System.out.println("Test case 4: " + solution.findLHS(nums4)); // Expected output: 4

        // Test case 5
        int[] nums5 = {1, 2, 3, 4, 5, 6};
        System.out.println("Test case 5: " + solution.findLHS(nums5)); // Expected output: 2
    }
}
