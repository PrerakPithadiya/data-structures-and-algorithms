
/**
 * Solution class for removing duplicates from a sorted array.
 */
class Solution {

    /**
     * Removes duplicates from a sorted array in-place and returns the number of
     * unique elements.
     *
     * This method modifies the input array such that the first k elements
     * contain the unique elements in the order they appeared, where k is the
     * number of unique elements. The remaining elements of the array are not
     * important.
     *
     * Time Complexity: O(n), where n is the length of the input array. Space
     * Complexity: O(1), as it modifies the array in-place.
     *
     * @param nums The sorted integer array from which to remove duplicates.
     * @return The number of unique elements in the array.
     */
    public int removeDuplicates(int[] nums) {
        // Edge case: If the array is empty or contains only one element, return its length
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the index of the first unique element
        int k = 1;  // Starts from 1 because the first element is always unique

        // Loop through the array, starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous unique element
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];  // Place the unique element at index k
                k++;  // Increment the unique elements count
            }
        }

        // Return the number of unique elements
        return k;
    }

    /**
     * Main method to demonstrate the usage of the removeDuplicates method.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] nums1 = {1, 1, 2};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("Example 1:");
        System.out.println("Unique count: " + k1);  // Output: 2
        System.out.print("Unique elements: ");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Output: 1 2
        }
        System.out.println("\n");

        // Example 2
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("Example 2:");
        System.out.println("Unique count: " + k2);  // Output: 5
        System.out.print("Unique elements: ");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");  // Output: 0 1 2 3 4
        }
    }
}
