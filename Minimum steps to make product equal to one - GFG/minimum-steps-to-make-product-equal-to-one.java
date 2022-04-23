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
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int makeProductOne(int[] arr, int N) {
        // code here
        int positive=0,negative=0, zero=0,step=0;
        for(int i=0;i<N;i++){
            if(arr[i]==0){
                zero++;
            }
            else if(arr[i]<0){
                negative++;
                step=step+(-1-arr[i]);
            }
            else{
                positive++;
                step=step+(arr[i]-1);
            }
        }
        if(negative%2==0){
            step=step+zero;
        }
        else{
            if(zero>0){
                step=step+zero;
            }
            else{
                step=step+2;
            }
        }
        return step;
    }
};