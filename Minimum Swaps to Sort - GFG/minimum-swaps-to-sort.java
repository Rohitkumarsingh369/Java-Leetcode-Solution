// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int arr[])
    {
        int n=arr.length;
		
		int temp[]=new int[n];
		for(int i=0;i<n;i++)
			temp[i]=arr[i];
		
		Arrays.sort(temp);
		HashMap<Integer,Integer> mp=new HashMap<>();
		
		for(int i=0;i<n;i++)
			mp.put(arr[i], i);
		
		int swapcount=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=temp[i]) {
				swapcount+=1;
				int init=arr[i];
				swap(arr,i,mp.get(temp[i]));
				
				mp.put(init,mp.get(temp[i]));
				mp.put(temp[i], i);
			}
		}
		return swapcount;
    }
    public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
	}
}