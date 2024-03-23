class Solution {
    public int firstMissingPositive(int[] a) {
        int n=a.length;
      boolean b[]=new boolean[n+1];
		for(int i=0;i<n;i++)
			if(a[i]>=0 && a[i]<=n)
				b[a[i]]=true;
		
		for(int i=1;i<=n;i++)
			if(b[i]==false)
				return i;
		
		return n+1;  
    }
}