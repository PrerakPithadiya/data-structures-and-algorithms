package LeetCode;

/**
 * Solution for finding the shortest subarray with bitwise OR at least K
 */
class Solution {

    /**
     * Finds the length of the shortest subarray whose bitwise OR is at least k
     *
     * @param nums the input array of integers
     * @param k the target value for bitwise OR
     * @return the minimum length of subarray with OR >= k, or -1 if no such
     * subarray exists
     */
    public int minimumSubarrayLength(int[] sequence, int target) {
        int seqLength = sequence.length;
        int[] setBits = new int[32];
        int runningOR = 0;
        int windowStart = 0;
        int shortestLen = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < seqLength; windowEnd++) {
            runningOR |= sequence[windowEnd];

            for (int position = 0; position < 32; position++) {
                if ((sequence[windowEnd] & (1 << position)) != 0) {
                    setBits[position]++;
                }
            }

            while (windowStart <= windowEnd && runningOR >= target) {
                shortestLen = Math.min(shortestLen, windowEnd - windowStart + 1);

                int tempOR = 0;
                for (int position = 0; position < 32; position++) {
                    if ((sequence[windowStart] & (1 << position)) != 0) {
                        setBits[position]--;
                    }

                    if (setBits[position] > 0) {
                        tempOR |= (1 << position);
                    }
                }

                runningOR = tempOR;
                windowStart++;
            }
        }

        return shortestLen == Integer.MAX_VALUE ? -1 : shortestLen;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic case
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        assert solution.minimumSubarrayLength(nums1, k1) == 2; // [2,3] has OR = 3|2 = 7 >= 5

        // Test case 2: No solution exists
        int[] nums2 = {1, 1, 1};
        int k2 = 5;
        assert solution.minimumSubarrayLength(nums2, k2) == -1;

        // Test case 3: Single element solution
        int[] nums3 = {8, 2, 3};
        int k3 = 8;
        assert solution.minimumSubarrayLength(nums3, k3) == 1;

        // Test case 4: Entire array needed
        int[] nums4 = {1, 2, 4};
        int k4 = 7;
        assert solution.minimumSubarrayLength(nums4, k4) == 3;

        System.out.println("All test cases passed!");
    }
}
