class Solution {
    public int maxProfit(int[] prices) {
        int minStockPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Calculate today's profit: today's price - minSeenBeforeToday
            int currProfit = prices[i] - minStockPrice;
            maxProfit = Math.max(maxProfit, currProfit);

            // Update min so future days know the min price
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }

        return maxProfit;
    }
}
