//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    } 

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();        
        PrintWriter out = new PrintWriter(System.out);
        int testcases = sc.nextInt();

        while (testcases-- > 0) {
            String S = sc.next();
            Solution ob = new Solution();
            long ans = ob.countSubstring(S);
            out.println(ans);
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {

 long countSubstring(String S) {

 int n = S.length();

 

 // creating and initializing difference array

 int[] arr = new int[n];

 

 if (S.charAt(0) == '1')

 arr[0] = 1;

 else

 arr[0] = -1;

 

 // calculating values of count 1 - count 0 for every index

 for (int i = 1; i < n; i++) {

 if (S.charAt(i) == '1')

 arr[i] = arr[i - 1] + 1;

 else

 arr[i] = arr[i - 1] - 1;

 }

 

 // temp array to be used in mergeSort

 int[] temp = new int[n];

 long ans = mergeSort(0, n - 1, arr, temp);

 

 return ans;

 }

 

 // merge function returns the inversion count while merging two reverse sorted

 // arrays [l,mid-1] and [mid,r]

 long merge(int l, int mid, int r, int[] arr, int[] temp) {

 long count = 0; // to store result

 

 int i = l;

 int j = mid;

 int k = l;

 

 while (i < mid && j <= r) {

 if (arr[i] < arr[j]) {

 count += (mid - i);

 temp[k++] = arr[j++];

 } else

 temp[k++] = arr[i++];

 }

 

 while (i < mid)

 temp[k++] = arr[i++];

 while (j <= r)

 temp[k++] = arr[j++];

 

 for (int x = l; x <= r; x++)

 arr[x] = temp[x];

 

 return count;

 }

 

 long mergeSort(int l, int r, int[] arr, int[] temp){

        if(l>r) return 0;

        

        // only single element and value is positive return 1, else return 0

        if(l==r)

        {

            if(arr[l]>0) return 1;

            return 0;

        }

        

        int mid = l + (r-l)/2;

        

        long left = mergeSort(l,mid,arr,temp);

        long right = mergeSort(mid+1,r,arr,temp);

        

        long total = left + right;

        total+= merge(l,mid+1,r,arr,temp);

        return total;

        

    }

}