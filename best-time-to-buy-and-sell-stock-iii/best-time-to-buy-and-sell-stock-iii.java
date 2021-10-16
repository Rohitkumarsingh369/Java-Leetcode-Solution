class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int T[][] = new int[3][N];
        
        for(int i = 1; i <= 2; i++) {
            int maxDiff = T[i-1][0] - prices[0];
            for(int j = 1; j < N; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        
        return T[2][N-1];
    }
}