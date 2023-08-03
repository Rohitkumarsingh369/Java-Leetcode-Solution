//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<Map<Integer,Integer>> l=new ArrayList<>();
		int vis[]=new int[N];
		for(int i=0;i<N;i++){
		    l.add(new HashMap<>());
		    vis[i]=-1;
		}
		
		Map<Integer,Integer> m;
		for(int i[]:edges){
		    m=l.get(i[0]);
		    m.put(i[1],i[2]);
		}
		dfs(0,l,vis,0);
		return vis;
	}
	void dfs(int i,List<Map<Integer,Integer>> g,int vis[],int target){
	    if(vis[i]!=-1){
	        if(target>vis[i]){
	            return;
	        }
	        else{
	            vis[i]=Integer.min(target,vis[i]);
	        }
	    }
	    else{
	        vis[i]=target;
	    }
	    for(Map.Entry<Integer,Integer> mp:g.get(i).entrySet()){
	            dfs(mp.getKey(),g,vis,target+mp.getValue());
	    }
	}
}