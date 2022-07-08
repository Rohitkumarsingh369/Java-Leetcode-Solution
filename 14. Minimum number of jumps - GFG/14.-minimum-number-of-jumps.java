// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    //reading input using BufferedReader
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	    
	    //reading total testcases
        int t = Integer.parseInt(br.readLine()); 

        int numOfTestCases = t;

        for(int p = 0;p<numOfTestCases;p++){
            //reading size of array 
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            
            //adding elements to the Array
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            
            //creating an object of class DynamicProgramming
            Solution obj = new Solution();
            
            //calling method minimumJumps() of class
            //DynamicProgramming
            System.out.println(obj.minimumJumps(arr, size));
        }
	 }
	
}
// } Driver Code Ends





class Solution
{
    //Function to find minimum number of jumps to reach the end of the array.
    public static int minimumJumps(int arr[], int n)
    {
        // your code here
        int curend=0;
        int maxlocation=0;
        int jump=0;
        
        if(arr[0]==0)
            return -1;
        for(int i=0;i<n-1;i++){
            maxlocation=Math.max(maxlocation,i+arr[i]);
            
            if(curend==i){
                jump++;
                curend=maxlocation;
            }
        }
        
        return curend>=n-1?jump:-1;
    }
}
