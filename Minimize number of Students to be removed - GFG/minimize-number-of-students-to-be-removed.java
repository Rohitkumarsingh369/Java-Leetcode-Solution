//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            out.println(ob.removeStudents(H,N));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int removeStudents(int[] arr, int N) {
       int n = arr.length;
       LinkedList<Integer> ans =  new LinkedList<>();
       ans.add(arr[0]);
       
        for(int i = 0; i < n ; i++){    
            
            if(arr[i] > ans.peekLast()){
                ans.add(arr[i]);
            }
            else{               
            	int ind = Collections.binarySearch(ans, arr[i]);
                if(ind == -1){
                    ans.set(ind+1, arr[i]);
                }else if(ind >= 0){
                   continue;
                }else{
                    ind = -(ind)-1;
                    ans.set(ind, arr[i]);
                }
            }
          }
        return N-ans.size();
    }
}