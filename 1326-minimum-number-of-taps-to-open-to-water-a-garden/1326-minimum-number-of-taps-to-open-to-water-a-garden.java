class Solution {
    public int minTaps(int n, int[] ranges) {
        int min=0,max=0,open=0;
        while(max<n)
        {
            for(int i=0;i<ranges.length;i++)
                max=(i+ranges[i]>=max&&i-ranges[i]<=min)?(i+ranges[i]):max;
            if(min==max) return -1;
            open++;
            min=max;
            
        }
        return open;
    }
}