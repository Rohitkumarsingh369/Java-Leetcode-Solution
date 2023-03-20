//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
     static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
     // List to store the positions of X's
    List<Point> xList = new ArrayList<>();
    // List to store the positions of Y's
    List<Point> yList = new ArrayList<>();

    // Iterate through the 2D grid and populate the xList and yList
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            char c = grid.get(i).get(j);
            if (c == 'X') {
                xList.add(new Point(i, j)); // Add the position of the X to xList
            } else if (c == 'Y') {
                yList.add(new Point(i, j)); // Add the position of the Y to yList
            }
        }
    }

    int minDist = Integer.MAX_VALUE; // minimum Manhattan distance found so far
    // Iterate through each point in xList and yList
    for (Point x : xList) {
        for (Point y : yList) {
            // Calculate Manhattan distance between x and y
            int dist = Math.abs(x.row - y.row) + Math.abs(x.col - y.col);
            // Update the minimum distance if necessary
            if (dist < minDist) {
                minDist = dist;
            }
        }
    }

    return minDist; // Return the minimum distance
}

// Custom class to represent a point in the 2D grid
static class Point {
    int row;
    int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
};