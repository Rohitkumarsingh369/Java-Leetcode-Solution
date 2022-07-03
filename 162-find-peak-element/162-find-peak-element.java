class Solution {
    /*public int findPeakElement(int[] num) {
     // First or last element is peak element
            int n=arr.length;
        if (n == 1)
          return 0;
        if (arr[0] >= arr[1])
            return 0;
        if (arr[n - 1] >= arr[n - 2])
            return n - 1;

        // Check for every other element
        for(int i = 1; i < n - 1; i++)
        {

            // Check if the neighbors are smaller
            if (arr[i] >= arr[i - 1] &&
                arr[i] >= arr[i + 1])
                return i;
        }
        return 0;
    }*/
    
    public int findPeakElement(int[] num) {
    int low = 0;
        int high = num.length-1;
        
        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}