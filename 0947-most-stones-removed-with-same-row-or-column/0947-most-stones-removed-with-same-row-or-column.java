class Solution {
    public int removeStones(int[][] stones) {
 
        HashSet<Pair <Integer,Integer>> visited = new HashSet<>(); 
        int ans = stones.length;
        for(int i=0;i<stones.length;i++){
            if(!visited.contains(new Pair <Integer,Integer> (stones[i][0],stones[i][1]))){
                dfs(stones,visited,stones[i][0],stones[i][1]);
                ans--;
            }
        }
        return ans;
    }
    
    void dfs(int[][] stones,HashSet<Pair <Integer,Integer>> visited,int i,int j){
        visited.add(new Pair<Integer,Integer>(i,j));
        for(int k=0;k<stones.length;k++){
            if(!visited.contains(new Pair <Integer,Integer> (stones[k][0],stones[k][1]))){
                if(i==stones[k][0] || j==stones[k][1])
                    dfs(stones,visited,stones[k][0],stones[k][1]);
            }
        }
    }
    
}