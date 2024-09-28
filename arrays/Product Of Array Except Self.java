
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // First pass: calculate the prefix product for each element.
        answer[0] = 1;  // No element before the first element, so prefix product is 1.
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Second pass: calculate the suffix product and multiply it with the prefix product.
        int suffix = 1;  // Suffix product starts from 1 (no element after the last element).
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];  // Update the suffix to include the current element.
        }

        return answer;
    }
}
