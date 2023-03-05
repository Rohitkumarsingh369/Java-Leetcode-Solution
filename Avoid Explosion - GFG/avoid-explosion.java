//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int mix[][] = new int[n][2];
            int danger[][] = new int[m][2];

            for (int i = 0; i < n; i++) {
                s = br.readLine().trim().split(" ");
                mix[i][0] = Integer.parseInt(s[0]);
                mix[i][1] = Integer.parseInt(s[1]);
            }
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                danger[i][0] = Integer.parseInt(s[0]);
                danger[i][1] = Integer.parseInt(s[1]);
            }
            Solution soln = new Solution();

            ArrayList<String> ans = soln.avoidExlosion(mix, n, danger, m);

            for (String x : ans) ot.print(x + " ");
            ot.println();
        }

        ot.close();
    }

}
// Position this line where user code will be pasted.

// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<String> avoidExlosion(int mix[][], int n, int danger[][], int m) {

        // Code Here

        ArrayList<String> ans=new ArrayList<>();

        int par[]=new int[n];

        for(int i=0;i<n;i++)

           par[i]=i;

        

        for(int a[]:mix){

            int x=findPar(a[0]-1,par);

            int y=findPar(a[1]-1,par);

            boolean flag=true;

            for(int i=0;i<danger.length;i++){

                int l=findPar(danger[i][0]-1,par);

                int r=findPar(danger[i][1]-1,par);

                if((x==l && y==r) || (x==r && y==l)){

                    flag=false;

                    break;

                }

            }

            if(flag==false){

                ans.add("No");

            }

            else{

                union(x,y,par);

                ans.add("Yes");

            }

        }

        return ans;

        

    }

    public int findPar(int x,int par[]){

        if(par[x]==x)

          return x;

        return findPar(par[x],par);

    }

    public void union(int a,int b,int arr[]){

        int x=findPar(a,arr);

        int y=findPar(b,arr);

        if(x==y)

          return;

        arr[y]=x;

    }

}