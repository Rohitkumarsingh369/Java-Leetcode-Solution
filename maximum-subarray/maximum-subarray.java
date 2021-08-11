class Solution {
    public int maxSubArray(int[] a) {
        int max_so_far=Integer.MIN_VALUE;
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
        return max_so_far;
    }
}