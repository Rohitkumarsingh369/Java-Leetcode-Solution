//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			int [][] colors = new int[N][3];
			for(int i = 0; i < N; i++) {
				String [] str = br.readLine().trim().split(" ");
				colors[i][0] = Integer.parseInt(str[0]);
				colors[i][1] = Integer.parseInt(str[1]);
				colors[i][2] = Integer.parseInt(str[2]);
			}
			Solution obj = new Solution();
			out.println(obj.minCost(colors, N));
		}
		out.close();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] colors, int N){
        //Write your code here
        int pink = 0, black = 0, yellow = 0;
	    
	    for(int i=0; i<N; i++) 
	    {
	        int curr_pink = Math.min(black, yellow) + colors[i][0];
	        int curr_black = Math.min(pink, yellow) + colors[i][1];
	        int curr_yellow = Math.min(pink, black) + colors[i][2];
	        
	        pink = curr_pink; black = curr_black; yellow = curr_yellow;
	    }
	    
	    return Math.min(pink, Math.min(black, yellow));
    }
}