class Solution {
    public int[] findOriginalArray(int[] nums) {
        int[] vacarr = new int[0];
	   	// when we need to return vacant array
        int n= nums.length;
			// size of the array
        if(n%2!=0)
        {
            return vacarr;
			// when we will have odd number of integer in our input(double array can't be in odd number)
    
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			 // for storing the frequencies of each input
        int[] ans = new int[(nums.length/2)];
        // answer storing array
     
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
			// storing the frequencies
        }
        int temp = 0;
        
        Arrays.sort(nums);
		// sorting in increasing order
        for(int i: nums)
        {
           
            if(hm.get(i)<=0)
            {
			  // if we have already decreased it's value when we were checking y/2 value, like 2,4 we will remove 4 also when we will check 2 but our iteration will come again on 4.
      
                continue;
            }
         
            if(hm.getOrDefault(2*i,0)<=0)
            {   // if we have y but not y*2 return vacant array
                return vacarr;
            }
            ans[temp++] = i;
			 // if we have both y and y*2, store in our ans array
           // decrease the frequency of y and y*2
            hm.put(i, hm.get(i)-1); 
            hm.put(2*i, hm.get(2*i)-1);
        }
        
        return ans;
    }
}