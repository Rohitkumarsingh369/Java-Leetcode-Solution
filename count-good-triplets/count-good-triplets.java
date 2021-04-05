class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
         int i;
    int j;
    int k;
    int counter = 0;
    
    for(i=0; i < arr.length - 2; i++)
    {
        for(j=i + 1; j < arr.length - 1; j++)
        {
            for(k = j + 1; k < arr.length; k++)
            {
                int temp1 = Math.abs(arr[i] - arr[j]);
                int temp2 = Math.abs(arr[j] - arr[k]);
                int temp3 = Math.abs(arr[i] - arr[k]);
                
                if(temp1 <= a && temp2 <= b && temp3 <= c)
                    counter++;
                
            }
        }
    }
    
    return counter;
    }
}