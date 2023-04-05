//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
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
    
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int t = sc.nextInt(); // Inputting the testcases
        PrintWriter out = new PrintWriter(System.out);
        while (t-- > 0) {

            int i = 0;
            int N = sc.nextInt();

            int arr[] = new int[(int)(N)];

            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            out.println(ob.countSpecialNumbers(N, arr));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        int MAX=Integer.MIN_VALUE;
        
        for(int in:arr) MAX=Math.max(MAX,in);
        
        boolean[] factors=new boolean[MAX+1];
        
        for(int i=0;i<N;i++)
        {
            if(map.containsKey(arr[i])){ 
                map.put(arr[i],map.get(arr[i])+1);
                continue;
                
            }
            for(int j=2*arr[i];j<=MAX;j+=arr[i])
            {
                factors[j]=true;
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        
        int ans=0;
        
        for(int i:arr)
        {
            if(factors[i] || map.get(i)>1) ans++;
        }
        
                return ans;
         
    }  
}