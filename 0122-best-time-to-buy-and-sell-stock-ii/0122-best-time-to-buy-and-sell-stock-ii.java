class Solution {
    public int maxProfit(int[] prices) {
         int maxProfit = 0;

        // Traverse through the price list
        for (int i = 1; i < prices.length; i++) {
            // If the current price is higher than the previous day's price, add the difference to maxProfit
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}