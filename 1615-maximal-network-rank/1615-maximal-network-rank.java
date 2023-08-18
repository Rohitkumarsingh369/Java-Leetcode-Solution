class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
          int degree[]=new int[n];
        boolean connected[][]=new boolean[n][n];

        for(int a[]:roads){
            degree[a[0]]++;
            degree[a[1]]++;
            connected[a[0]][a[1]] =true;
            connected[a[1]][a[0]]=true;
        }
        int temp=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                temp=Math.max(temp,degree[i]+degree[j]-(connected[i][j]?1:0));
            }
        }

        return temp;
        
    }
}