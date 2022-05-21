class Solution {
    public int coinChange(int[] coins, int amount) {
        int table[]=new int[amount+1];
        table[0]=0;
        
        for(int i=1;i<table.length;i++)
        {
            table[i]=Integer.MAX_VALUE;
        }
        
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i){
                int subres=table[i-coins[j]];
                if(subres!=Integer.MAX_VALUE &&subres+1<table[i])
                    table[i]=subres+1;
                }
            }
        }
            if(table[amount]==Integer.MAX_VALUE)
                return -1;
            
            return table[amount];
        
    }
}