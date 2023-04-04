//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
		int acount=0;
	    int bcount=0;
	    char prev='#';
	    
	    for(int i=0;i<str.length();i++)
	    {
	        char ch=str.charAt(i);
	        if(prev==ch) continue;
	        
	        if(ch=='a') acount++;
	        else bcount++;
	        
	        prev=ch;
	    }
		
		    return Math.min(acount,bcount)+1;
	}
}