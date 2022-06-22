class Solution {
public int[] maxSubsequence(int[] nums, int k) {

    // Create proirity queue with min priority queue so that min element will be removed first, with index
    // Add those unique index in a set
    // Loop from 0 to n-1 and add element in result if set contains those index
    // For ex. set has index 3,5,6 Just add those element. Order will be maintained
        
 
   // We are defining the min priority queue  
   PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> (a[0]-b[0])); 
    
    // Add element with index to priority queue
    for(int i=0; i<nums.length; i++)
    {
        q.offer(new int[]{nums[i],i});
        if(q.size()> k)
        {
            q.poll();
        }
    }
    
    // Set to keep index
    Set<Integer> index = new HashSet<>();
    
    
    // Add the index in the set since index are unique 
    while(!q.isEmpty())
    {
        int[] top = q.poll();
        index.add(top[1]);
    }
    
    // Final result add here
    int[] result = new int[k];
    
    
    // Just add the element in the result for those index present in SET
    int p =0;
    for(int i=0; i< nums.length; i++)
    {
        if(index.contains(i))
        {
            result[p] = nums[i];
            ++p;
        }
    }
    
    return result;
}
}