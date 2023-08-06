//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> ans = new ArrayList<>();
        findPerm(ans,0,S);
        Collections.sort(ans);
        return ans;
    }
	 
	 static void findPerm(ArrayList<String> ans ,int indx, String S)
	 {
	     if(indx == S.length())
	     {
	             ans.add(S);
	             return;
	     }
	     
	     for(int i=indx;i<S.length();i++)
	     {
	       StringBuilder string = new StringBuilder(S);
	       char ch1 = string.charAt(indx);
	       char ch2 = string.charAt(i);
               string.setCharAt(i, ch1);
               string.setCharAt(indx,ch2);
               S = string.toString();
               findPerm(ans,indx+1,S);
               string.setCharAt(i, ch2);
               string.setCharAt(indx,ch1);
               S = string.toString();
	     }
	 }
}