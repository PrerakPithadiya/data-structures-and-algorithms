package bitmask;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for the "Stickers to Spell Word" problem. This class provides
 * a method to calculate the minimum number of stickers needed to spell out a
 * target word.
 */
class Solution {

    /**
     * Calculates the minimum number of stickers needed to spell out the target
     * word.
     *
     * @param stickers An array of strings representing available stickers.
     * @param target The target word to be spelled out.
     * @return The minimum number of stickers needed, or -1 if it's impossible.
     */
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[][] stickerCount = new int[n][26];  // Frequency of each letter for each sticker
        for (int i = 0; i < n; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCount[i][c - 'a']++;
            }
        }

        // Memoization map: key -> target, value -> minimum stickers needed
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);  // Base case: If no target, no stickers needed

        int result = dp(target, stickerCount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * Dynamic programming helper method to calculate the minimum stickers
     * needed.
     *
     * @param target The current target string.
     * @param stickerCount 2D array representing the letter count of each
     * sticker.
     * @param memo Memoization map to store intermediate results.
     * @return The minimum number of stickers needed for the current target.
     */
    private int dp(String target, int[][] stickerCount, Map<String, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);  // Check if already computed
        }
        int n = stickerCount.length;
        int[] targetCount = new int[26];  // Frequency of each letter in the target
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }

        int result = Integer.MAX_VALUE;
        // Try to use each sticker to reduce the target
        for (int i = 0; i < n; i++) {
            // Optimization: only try stickers that have the first character of the target
            if (stickerCount[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }

            // Form a new target after using the current sticker
            StringBuilder newTarget = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targetCount[j] > 0) {
                    int remaining = targetCount[j] - stickerCount[i][j];
                    for (int k = 0; k < Math.max(0, remaining); k++) {
                        newTarget.append((char) ('a' + j));
                    }
                }
            }

            // Recurse with the new target
            int temp = dp(newTarget.toString(), stickerCount, memo);
            if (temp != Integer.MAX_VALUE) {
                result = Math.min(result, 1 + temp);  // 1 + temp because we used one sticker
            }
        }

        memo.put(target, result);
        return result;
    }

    /**
     * Main method to run test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] stickers1 = {"with", "example", "science"};
        String target1 = "thehat";
        System.out.println("Test case 1: " + solution.minStickers(stickers1, target1)); // Expected output: 3

        // Test case 2
        String[] stickers2 = {"notice", "possible"};
        String target2 = "basicbasic";
        System.out.println("Test case 2: " + solution.minStickers(stickers2, target2)); // Expected output: -1

        // Test case 3
        String[] stickers3 = {"these", "guess", "about", "garden", "him"};
        String target3 = "atomher";
        System.out.println("Test case 3: " + solution.minStickers(stickers3, target3)); // Expected output: 3
    }
}
