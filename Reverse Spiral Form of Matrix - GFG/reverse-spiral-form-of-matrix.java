//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)

    {

        ArrayList<Integer> al=new ArrayList<>();

        int m = R;

        int n = C;

        int strow = 0;

        int stcol = 0;

        int endrow = m - 1;

        int endcol = n - 1;

        while (strow <= endrow && stcol <= endcol) {

            // left to right (1st row -outer top)

            for (int i = stcol; i <= endcol; i++) {

                al.add(a[strow][i]);

            }

            // top to bottom (1st col -outer)

            for (int j = strow + 1; j <= endrow; j++) {

                al.add(a[j][endcol]);

            }

            //  right to left (1st row -outeer bottom

            for (int i = endcol - 1; i >= stcol; i--) {

                if (strow==endrow) break;

                al.add(a[endrow][i]);

            }

            // bottom to top (1st col-outer)

            for (int j = endrow - 1; j >= strow + 1; j--) {

                if (stcol==endcol) break;

                al.add(a[j][stcol]);

            }

            stcol++;

            strow++;

            endcol--;

            endrow--;

 

        }

        Collections.reverse(al);

        int[] arr = new int[al.size()];

 

        for (int i = 0; i < al.size(); i++){

            arr[i] = al.get(i);

 

         }

 

        return arr;

    }
}