// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().checkTriplet(arr, n);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    boolean checkTriplet(int[] arr, int n) {
        // code here
        for(int i=0;i<n;i++){
            arr[i]=arr[i]*arr[i];
        }
        
        Arrays.sort(arr);
        
        for(int i=n-1;i>=2;i--){
            int left=0;
            int right=i-1;
            
            while(left<right){
                int sum=arr[left]+arr[right];
                
                if(sum==arr[i]){
                    return true;
                }
                else if(sum<arr[i]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        
        return false;
    }
}