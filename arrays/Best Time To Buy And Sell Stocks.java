class Solution {
    public static int maxProfit(int[] arr) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int sellPrice : arr) {
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }
        return maxProfit;
    }
}
