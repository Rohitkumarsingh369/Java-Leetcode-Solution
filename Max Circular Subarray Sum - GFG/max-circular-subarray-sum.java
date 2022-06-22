// { Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}


// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        int currMaxSum = 0, maxSum = a[0], currMinSum = 0, minSum = a[0], totalSum = 0;
       for(int i = 0; i < n; i++){
           currMaxSum = Math.max(a[i], currMaxSum + a[i]);
           maxSum = Math.max(currMaxSum, maxSum);
           currMinSum = Math.min(a[i], currMinSum + a[i]);
           minSum = Math.min(currMinSum, minSum);
           totalSum += a[i];
       }
       return maxSum > 0 ? Math.max(maxSum, totalSum - minSum) : maxSum;
    }
    
}

