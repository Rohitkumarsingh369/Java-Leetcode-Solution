class Solution {
    static int count;
    public int minReorder(int n, int[][] con) {
        count=0;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<con.length;i++)
        {
            int u=con[i][0];
            int v=con[i][1];
            graph.get(u).add(v);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited=new boolean[n];
        dfs(graph,0,visited,adj);
            
        
        
        return count;
    }
    static boolean containsEdge(int src , int dec ,  ArrayList<ArrayList<Integer>> graph){
        
        for(Integer nn : graph.get(src)){
            if(nn == dec) 
                return false;
        }
        return true;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> graph,int i,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
    {
        if(visited[i]==true)
        {
            return;
        }
        
        
        visited[i]=true;
        
        for(int u: adj.get(i))
        {
            if(visited[u]==false)
            {
                if(!containsEdge(i,u,graph))
                 count++;
                
                
                dfs(graph,u,visited,adj);    
                
               
            }
        }
    }
}