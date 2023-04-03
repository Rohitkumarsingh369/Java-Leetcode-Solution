//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{    
	    // code here
	    if(x.length() == 1) return x.charAt(0) - '0';
        int temp = x.charAt(0) - '0';
        for(int i = 1; i < x.length(); i++){
            int ele = x.charAt(i) - '0';
            if(ele >= temp) temp = ele - temp;
            else temp = (10+ele) - (temp-1);
        }
        return temp;
        
	}
} 

