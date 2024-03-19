class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLs=new ArrayList<ArrayList<Integer>>();
        
        int length=isConnected.length;
        
        for(int i=0;i<length;i++){
            adjLs.add(new ArrayList<Integer>());
        }
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        
        int visited[]=new int[length];
        
        int count=0;
        for(int i=0;i<length;i++){
            if(visited[i]==0){
                count++;
                dfs(i,adjLs,visited);
            }
        }
        
        return count;
    }

    private void dfs(int vertex,ArrayList<ArrayList<Integer>> adjLs,int visited[]){
        visited[vertex]=1;
        
        for(Integer it:adjLs.get(vertex)){
            if(visited[it]==0){
                dfs(it,adjLs,visited);
            }
        }
    }
}