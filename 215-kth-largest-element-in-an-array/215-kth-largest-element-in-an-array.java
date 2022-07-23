class Solution {
    public int findKthLargest(int[] nums, int k) {  
        return findKthLargest(nums, 0, nums.length-1, k-1);  
    }  
  
    private int findKthLargest(int[] nums, int left, int right, int k) {  
        if(k<left || k>right) return -1; 
        while(true){
            int index = partition(nums, left, right);  
            if(index == k) {  
                return nums[index]; 
            }
            if(index>k){
                right=index-1;
            }
            else{
                left=index+1;
            }
        }
         
    }  

    private int partition(int[] nums, int l, int h) { 
        int pivot = nums[h];  
        int p = l;  
        for(int i=l; i<h; i++) {  
            if(nums[i]>pivot) {  
                swap(nums, i, p++);  
            }  
        }  
        swap(nums, p, h);  
        return p;  
    }  

    private void swap(int[] nums, int i, int j) {  
        int tmp = nums[i];  
        nums[i] = nums[j];  
        nums[j] = tmp;  
    }
}