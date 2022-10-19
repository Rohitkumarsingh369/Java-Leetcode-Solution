//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int n;
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        n = N;
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(ArrayList<Integer> edges : Edges){
            int u = edges.get(0);
            int v = edges.get(1);
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int cnt = 1;
        // Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[N+1];
        for(int i = 1; i<=N; i++){
            if(dfs(i,map,visited,cnt)){
                return true;
            }
        }
        return false;
    }
    
    
    boolean dfs(int node,Map<Integer,ArrayList<Integer>> map,boolean[] visited,int cnt){
        if(cnt == (visited.length - 1)){
            return true;
        }
        
        visited[node] = true;
        cnt += 1;
        for(Integer neighbour : map.get(node)){
            if(!visited[neighbour] && dfs(neighbour,map,visited,cnt)){
                return true;
            }
        }
        cnt--;
        visited[node] = false;// backtracking
        return false;
    }
}