class Solution {
    Map<Integer,int[]> map = new HashMap<>();
    int ans = -1;
    public void dfs(int curr,int dist,int[] edges){
        if(edges[curr] == -1){                // no outgoing edge from current node -> return
            return;
        }
        if(map.containsKey(curr) && map.get(curr)[1] == 1){  // node already visited and part of current dfs call as status = 1
            ans = Math.max(ans,dist - map.get(curr)[0]);
            return;
        }
        if(map.containsKey(edges[curr]) && map.get(edges[curr])[1] == 0){  // node already visited but in previous dfs calls, doesn't form cycle -> return
            return;
        }
        map.put(curr,new int[] {dist,1}); // update node status as 1 means part of current dfs call
        dfs(edges[curr],dist + 1,edges); 
        map.put(curr,new int[] {dist,0});  // update node status as 0 means current dfs call completed for this node
     }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(i)){
                dfs(i,0,edges);
            }
        }
        return ans <= 1 ? -1 : ans;
    }
}