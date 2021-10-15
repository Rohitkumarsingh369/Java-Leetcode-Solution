class Solution {
    public int maxProfit(int[] prices) {
        int profitOne = 0, profitTwo = 0;
        for(int i=1; i<prices.length; i++){
            int temp = profitOne;
            profitOne = Math.max(profitOne + prices[i] - prices[i-1] , profitTwo);
            profitTwo = Math.max(temp , profitTwo);
        }
        return Math.max(profitOne, profitTwo);
    }
}