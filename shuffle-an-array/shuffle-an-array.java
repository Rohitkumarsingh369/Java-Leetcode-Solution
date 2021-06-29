class Solution {
    
    private int nums[]=null;
    
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
       /* Random r=new Random();
        
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            int j=r.nextInt(n);
            
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        
        return nums;*/
        // copy the orginal array
        int[] arr = nums.clone();
        
        Random rnd = new Random();
        for(int i = 0; i < arr.length; i++) {
            // find random index in the array
            int index = rnd.nextInt(arr.length);
            
            // swap current element with random
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */