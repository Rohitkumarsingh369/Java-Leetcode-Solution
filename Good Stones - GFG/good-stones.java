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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int goodStones(int n, int[] arr) {
        int[] phase = new int[n];
        int cnt = 0;
        
        for(int i=0; i<n; i++) {
            if(phase[i] == 0) code(i, n, arr, phase);
            if(phase[i] == 2) ++cnt;
        }
        return cnt;
    }
    
    private static boolean code(int i, int n, int[] arr, int[] phase) {
        if(i < 0 || i >= n || phase[i] == 2) return true;
        if(phase[i] == 1) return false;
        
        phase[i] = 1;
        boolean cc = code(i+arr[i], n, arr, phase);
        
        if(cc) phase[i] = 2;
        return cc;
    }}