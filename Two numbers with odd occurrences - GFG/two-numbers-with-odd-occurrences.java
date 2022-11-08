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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
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

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        // code here
         int arr[]=new int[2];

        int count=1;

        int k=0;

        Arrays.sort(Arr);

        for(int i=0;i<Arr.length;i++){

            

            if(i==Arr.length-1){

               if(Arr[i]==Arr[i-1]){

                    if(count%2==0){

                       count=1;

                    }else if(count%2!=0){

                        arr[k]=Arr[i];

                        k++;

                        count=1;

                    }

               }else{

                   arr[k]=Arr[i];

                        k++;

                        count=1;

               }

            }else if(Arr[i]==Arr[i+1]){

                count++;

            }else{

                if(count%2==0){

                    count=1;

                }else if(count%2!=0){

                    arr[k]=Arr[i];

                    k++;

                    count=1;

                }

            }

        }

        if(arr[0]<arr[1]){

            int temp=arr[1];

            arr[1]=arr[0];

            arr[0]=temp;

        }

        return arr;
    }
}