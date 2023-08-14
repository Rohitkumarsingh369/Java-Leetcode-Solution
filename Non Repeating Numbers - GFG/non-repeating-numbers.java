//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int x : nums){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> e : hm.entrySet()){
            if(e.getValue() == 1){
                res.add(e.getKey());
            }
        }
        Collections.sort(res);
        int[] ref = res.stream().mapToInt(i -> i).toArray();
        return ref;
    }
}