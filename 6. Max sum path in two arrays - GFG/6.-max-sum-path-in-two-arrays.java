// { Driver Code Starts
import java.util.*;

class ArrPathSum1
{
	// Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T>0)
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			int ar1[] = new int[m];
			int ar2[] = new int[n];
			for(int i=0; i<m; i++)
				ar1[i] = sc.nextInt();
			for(int i=0; i<n; i++)
				ar2[i] = sc.nextInt();
		
		Solution g = new Solution();
		System.out.println(g.maxPathSum(ar1,ar2));
		T--;
		}
	}
}// } Driver Code Ends


class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int ar1[], int ar2[])
    {
        // Your code here
        int length1=ar1.length;
        int length2=ar2.length;
        
        int sum1=0,sum2=0,result=0;
        
        int i=0,j=0;
        
        while(i<length1 && j<length2){
            if(ar1[i]<ar2[j])
                sum1+=ar1[i++];
            
            else if(ar1[i]>ar2[j])
                sum2+=ar2[j++];
            
            else{
                result+=Math.max(sum1,sum2)+ar1[i];
                i++;
                j++;
                sum1=0;
                sum2=0;
            }
        }
        
        while(i<length1)
            sum1+=ar1[i++];
            
        while(j<length2)
            sum2+=ar2[j++];
            
        result+=Math.max(sum1,sum2);
        
        return result;
    }
}