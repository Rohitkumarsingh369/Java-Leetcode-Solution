//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

//JAVA SOLUTION

 

class Pair{  //pair to store distance,i and j of the matrix
    int first,second,third;
    Pair(int dis,int a,int b){
        first=dis;
        second=a;
        third=b;
    }
}

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        //BFS traversal of A using Queue
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,0)); //we start from first position where dis=0,i=0 and j=0
        int ti[]={0,-1,1,0}; // both ti[] and tj[] will be used to check left,right,up and down from current position
        int tj[]={1,0,0,-1}; // for example for ti[0]=0 and tj[0]=1 we will check on the right side and for ti[1]=-1 and tj[1]=0 we will check ont he above
        while(!q.isEmpty()){
            Pair temp=q.poll();
            int dis=temp.first,i=temp.second,j=temp.third;
            if(i==X && j==Y) return dis; //if we find x and y we return the dis
            for(int k=0;k<4;k++){
                int newi=i+ti[k],newj=j+tj[k]; 
                if(newi>=0 && newj>=0 && newi<N && newj<M && A[newi][newj]==1){ //here we are checking so that the positions don't go out of bounds and the next position we are checking is 1
                    A[newi][newj]=0; //making the position zero so we do not traverse throug it again
                    q.add(new Pair(dis+1,newi,newj)); // incrementing the distance and adding the new newj and newi positions
                }
            }
        }
        return -1;
    }
};