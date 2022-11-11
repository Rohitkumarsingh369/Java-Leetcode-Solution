//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
     static String isSumOfTwo(int N){

        if(N==2 || N==3)

        return "No";

        if(N>2 && N%2==-0)

        return "Yes";

        int k=N;

        N=N-2;

        

        while(prime(N)!=1)

        {

            N-=2;

        }

        int d=k-N;

        if(prime(d)==1)

        return "Yes";

        else

        return "No";

        

    }

    static int prime(int N)

    {

         if (N <= 1)

            return 0;

        if (N == 2 || N == 3)

            return 1;

        if (N % 2 == 0 || N % 3 == 0)

            return 0;

        for (int i = 5; i*i<=N ; i = i + 6)

            if (N % i == 0 || N % (i + 2) == 0)

                return 0;

        return 1;

    }
}