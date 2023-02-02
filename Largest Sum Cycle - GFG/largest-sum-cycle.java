//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     long  ans=-1;
    public void dfs(int edge[],long store[],long vis[],long reSet[],int u,long sum){
      if(u!=-1){
          if(vis[u]==0){
              store[u]=sum;
              vis[u]=1;
              reSet[u]=1;
              sum+=u;
             dfs(edge,store,vis,reSet,edge[u],sum);
          }
          else if(reSet[u]==1){
              ans=Math.max(ans,sum-store[u]);
          }
            reSet[u]=0;
      }
    
  }
    public long largesSumCycle(int N, int Edge[]){
         long[]  store=new long[N];
         long[]  vis=new long[N];
         long [] reSet=new long[N];
         for(int i=0;i<N;i++){
         if(vis[i]==0){
            dfs(Edge,store,vis,reSet,i,0);
         }
    }
    return ans;
    }
}