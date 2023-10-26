class Solution {
    public int maxSubArray(int[] a) {
        /*int max_so_far=Integer.MIN_VALUE;
        int n=a.length;
		int max_ending_here=0;
		int start=0,end=0,s=0;
		for(int i=0;i<n;i++) {
			max_ending_here=max_ending_here+a[i];
			if(max_so_far<max_ending_here)
			{
				max_so_far=max_ending_here;
				start=s;
				end=i;
			}
			if(max_ending_here<0)
			{
				max_ending_here=0;
				s=i+1;
			}
		}
        return max_so_far;*/
        int n=a.length;
        int maxSoFar=Integer.MIN_VALUE;
        int maxEndingHere=0;
        int start=0,end=0,s=0;
        
        for(int i=0;i<n;i++){
            maxEndingHere+=a[i];
            
            if(maxSoFar<maxEndingHere){
                maxSoFar=maxEndingHere;
                end=i;
                start=s;
                    
            }
            if(maxEndingHere<0){
                maxEndingHere=0;
                s=i+1;
            }
        }
        return maxSoFar;
    }
}

/*
public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}*/