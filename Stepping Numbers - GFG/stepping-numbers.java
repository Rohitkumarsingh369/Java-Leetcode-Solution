//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    int bfs(int n, int m, int num)

    {

        int count = 0;

     Queue<Integer> q=new LinkedList<>();

     q.add(num);

     while (!q.isEmpty())

     {

     int stepNum = q.poll();

     if (stepNum <= m && stepNum >= n)

     count++;

     if (num == 0 || stepNum > m)

     continue;

     int lastDigit = stepNum % 10;

     int stepNumA = stepNum * 10 + (lastDigit- 1);

     int stepNumB = stepNum * 10 + (lastDigit + 1);

     

     if (lastDigit != 9)

     q.add(stepNumB);

     if (lastDigit != 0)

     q.add(stepNumA);

    

     }

     return count;

    }

 

    int steppingNumbers(int n, int m)

    {

        int ans = 0;

     for (int i = 0 ; i <= 9 ; i++){

         ans += bfs(n, m, i);

     }

     return ans;

    }
}
