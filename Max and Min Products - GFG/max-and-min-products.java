// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;




class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            long product[] = obj.getMaxandMinProduct(a, n);  
            System.out.println(product[1]+" "+product[0]);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java



class Solution 
{
    long[] getMaxandMinProduct(int arr[], int n)  
    {
        // Your code goes here
        // Initialize all products with arr[0]
    long curMaxProduct = arr[0];
    long curMinProduct = arr[0];
    long prevMaxProduct = arr[0];
    long prevMinProduct = arr[0];
    long  maxProduct = arr[0];
    long minProduct = arr[0];
 
    // Process all elements after arr[0]
    for (int i = 1; i < n; ++i)
    {
        /* Current maximum product is maximum of following
            1) prevMax * curelement (when curelement is +ve)
            2) prevMin * curelement (when curelement is -ve)
            3) Element itself
            4) Previous max product */
        curMaxProduct = Math.max(prevMaxProduct * arr[i],
                        Math.max(prevMinProduct * arr[i],
                                                  arr[i]));
        curMaxProduct = Math.max(curMaxProduct,
                                 prevMaxProduct);
 
        /* Current min product computation is
        Similar to that of current max product */
        curMinProduct = Math.min(prevMaxProduct * arr[i],
                        Math.min(prevMinProduct * arr[i],
                                                  arr[i]));
        curMinProduct = Math.min(curMinProduct, prevMinProduct);
        maxProduct = Math.max(maxProduct, curMaxProduct);
        minProduct = Math.min(minProduct, curMinProduct);
 
        // copy current values to previous values
        prevMaxProduct = curMaxProduct;
        prevMinProduct = curMinProduct;
    }
    
    long result[]=new long[2];
    result[0]=minProduct;
    result[1]=maxProduct;
    return result;
    }
    
}