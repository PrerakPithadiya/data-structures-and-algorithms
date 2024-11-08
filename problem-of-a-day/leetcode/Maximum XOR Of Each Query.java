package LeetCode;

class Solution {

    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int xorAll = 0;
        int maxPossibleValue = (1 << maximumBit) - 1;

        // Calculate the XOR of all elements
        for (int num : nums) {
            xorAll ^= num;
        }

        // Iterate backwards to process queries
        for (int i = 0; i < n; i++) {
            result[i] = xorAll ^ maxPossibleValue;
            xorAll ^= nums[n - 1 - i];
        }

        return result;
    }
}
