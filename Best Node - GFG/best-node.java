//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.bestNode(N, A, P);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


 class Solution {

    public static long dfs(int node, ArrayList<Integer>[] graph, int[] A, int flag) {

        long ans = (int)-1e18;

        for (int i : graph[node]) {

            ans = Math.max(ans, dfs(i, graph, A, flag ^ 1));

        }

        long value = A[node - 1];

        if (flag == 1)

            value = -value;

        if (ans == (int)-1e18)

            return value;

        return value + ans;

    }

 

    public static long bestNode(int N, int[] A, int[] P) {

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {

            graph[i] = new ArrayList<>();

        }

 

        for (int i = 1; i < N; i++) {

            graph[P[i]].add(i + 1);

        }

 

        long ans = (int)-1e18;

        for (int i = 1; i <= N; i++) {

            ans = Math.max(ans, dfs(i, graph, A, 0));

        }

        return ans;

    }

}    
