//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            
            String inputLine1[] = br.readLine().trim().split(" "); 
            int i=0;
            int N = Integer.parseInt(inputLine1[i++]);
            int leaves = Integer.parseInt(inputLine1[i++]);
            
            int frogs[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                frogs[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.unvisitedLeaves(N, leaves, frogs));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
   public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int size  = leaves+1;
        Boolean[] visited  = new Boolean[size];
        Arrays.fill(visited,false);
        Arrays.sort(frogs);
        for(int i=0;i < N ; i++){
            if(frogs[i] == 1){
                return 0;
            }
            if(frogs[i]> leaves ||frogs[i]== 0|| visited[frogs[i]] == true){
                continue;
            }
            
            if(frogs[i] <= leaves&& visited[frogs[i]] ==false){
            int j =frogs[i];
            while(j <= leaves){
                if(visited[j] != true){
                visited[j] = true;
                size--;
                }
                j=j+frogs[i];
            }
            }
            if(size == 1){
                break;
            }
        }
       
        return --size;
    }
}
