class Solution {
    public int maxTurbulenceSize(int[] arr) {
        
    	char prev='=';
    	int ans=0,c=0;
    	for(int i=0;i<arr.length-1;i++)
    	{
    		if(arr[i]>arr[i+1])
    		{
    			if(prev=='<')
                    c++;
    			else 
					c=1;
    			prev='>';
    		}
    		else if(arr[i]<arr[i+1])
    		{
    			if(prev=='>')
                    c++;
    			else 
					c=1;
    			prev='<';
    		}
    		else 
    		{
    			c=0;
    			prev='=';
    		}
    		ans=Math.max(ans, c);
    	}
    	return ans+1;
    }
}