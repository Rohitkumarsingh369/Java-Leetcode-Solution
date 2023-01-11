//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        Arrays.sort(arr);

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;

        int max = 0;

        for(int i=0;i<arr.length;i++){

            max = Math.max(arr[i],max);

            if(set.contains(arr[i])){

                sum+=max+1-arr[i];

                max++;

                set.add(max);

            }

            else{

                set.add(arr[i]);

            }

        }

        return sum;
    }
}