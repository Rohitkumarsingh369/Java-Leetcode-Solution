class Solution 
{
    static final int MOD = (int)((1e9) + 7);
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) 
    {
        int[][][] memo = new int[m][n][maxMove+1];
        
        for(int[][] row:memo)
        {
        for(int[] col: row)
            {
        Arrays.fill(col, -1);
            }
        }
        
        return find(m, n, maxMove, startRow, startColumn, memo);
        }
    
    public int find(int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo)
    {
       
        if(startRow==m || startColumn==n || startRow==-1 || startColumn==-1)
            return 1;
        
        if(maxMove == 0)//No further moves left
           return 0;
        
        if(memo[startRow][startColumn][maxMove]!=-1)
            return memo[startRow][startColumn][maxMove];
        
        int up = find(m, n, maxMove-1, startRow-1, startColumn, memo);
        int down = find(m, n, maxMove-1, startRow+1, startColumn, memo);
        int left = find(m, n, maxMove-1, startRow, startColumn+1, memo);
        int right = find(m, n, maxMove-1, startRow, startColumn-1, memo);
        
        int res = 0;
        res = ((up + down)%MOD + (left + right)%MOD)%MOD;
        memo[startRow][startColumn][maxMove] = res;
            return res;
    }
}