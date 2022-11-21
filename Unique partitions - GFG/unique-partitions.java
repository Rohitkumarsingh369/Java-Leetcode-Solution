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
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
            for(ArrayList<Integer>i: ans)
                for(int j: i)
                    System.out.print(j + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    private void solve(int original,int num,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> res){
        
        if(original==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(num<=0)
            return;
        
       if(num<=original){
           ans.add(num);
           solve(original-num,num,ans,res);
           ans.remove(ans.size()-1);    //Backtracking for maintaining the previous recursion state of ans.
       } 
       solve(original,num-1,ans,res);
        
    }
    public ArrayList<ArrayList<Integer>> UniquePartitions(int n)
    {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
        solve(n,n,ans,res);
        
        return res;
    }
}