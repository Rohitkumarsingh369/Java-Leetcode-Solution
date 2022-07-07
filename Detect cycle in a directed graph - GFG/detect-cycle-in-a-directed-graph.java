// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[]=new boolean[V];
        boolean stack[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(iscycle(i,visited,stack,adj)){
                return true;
            }
        }
        
        return false;
    }
    public boolean iscycle(int v,boolean[] visited,boolean[] stack,ArrayList<ArrayList<Integer>> adj){
        if(stack[v])
            return true;
            
        if(visited[v])
            return false;
            
        stack[v]=true;
        visited[v]=true;
        
        ArrayList<Integer> list=adj.get(v);
        
        for(Integer temp:list){
            if(iscycle(temp,visited,stack,adj))
                return true;
        }
        
        stack[v]=false;
        return false;
    }
}