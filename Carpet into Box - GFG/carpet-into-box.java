//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int a, int b, int x, int y) { 
        //code here
        // If box fits in the other box
        if(Math.max(a,b)<=Math.max(x,y)&&Math.min(a,b)<=Math.min(x,y))return 0;
        
        // Finding maximum side of both boxes
        int m1 = (a>b)?a:b;
        int m2 = (x>y)?x:y;
        
        // minimum side of box1
        int mi1 = (a<b)?a:b;

        // if maximum side of box1 > box2 then divide longer side of box1 by 2
        if(m1>m2) return 1 + carpetBox(m1/2, (a>b)?b:a, x, y);
        // if smaller side of box1 > box2 then divide smaller side of box1 by 2
        else  return 1 + carpetBox(mi1/2, (a<b)?b:a, x, y);
    }
   
}