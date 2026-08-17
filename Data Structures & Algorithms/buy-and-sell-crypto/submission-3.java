class Solution {
    public int maxProfit(int[] prices) {
        int minStockPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - minStockPrice;
            maxProfit = Math.max(maxProfit, currProfit);
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }

        return maxProfit;
    }
}
