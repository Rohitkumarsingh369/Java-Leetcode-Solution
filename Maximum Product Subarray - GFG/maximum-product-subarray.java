//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long num1=1,num2=1;
        long min=arr[0],max=arr[0];
        long product=arr[0];
        
        for(int i=1;i<n;i++){
            num1=min*arr[i];
            num2=max*arr[i];
            
            min=Math.min(arr[i],Math.min(num1,num2));
            max=Math.max(arr[i],Math.max(num1,num2));
            
            product=Math.max(product,Math.max(min,max));
        }
        return product;
    }
}