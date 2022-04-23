// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] weights, int N, int D) {
    int left = 0;
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        int right = sum;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(weights, mid, D)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public static boolean isPossible(int[] weights, int mid, int D) {
        int limit = 1;
        int curr = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > mid) {
                return false;
            }
            if (weights[i] + curr > mid) {
                curr = weights[i];
                limit++;
                if (limit > D) {
                    return false;
                }
            } else {
                curr += weights[i]; 
            }
            
        }
        return true;
    }
};