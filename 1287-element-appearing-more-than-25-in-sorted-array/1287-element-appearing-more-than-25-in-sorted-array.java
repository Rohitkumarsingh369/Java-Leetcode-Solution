class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int lim = n/4;
        int count=1;
        int curr = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] == curr)
                count++;
            else    
                count =1;

            if(count>lim)
                return arr[i];

            curr = arr[i];
        }
        return curr;
    }
}