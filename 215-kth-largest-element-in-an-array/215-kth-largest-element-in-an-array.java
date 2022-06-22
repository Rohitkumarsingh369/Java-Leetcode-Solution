class Solution {
    public int findKthLargest(int[] nums, int k) {  
        return findKthLargest(nums, 0, nums.length-1, k-1);  
    }  
  
    private int findKthLargest(int[] nums, int l, int h, int k) {  
        if(k<l || k>h) return -1;  
        int p = partition(nums, l, h);  
        if(p == k) {  
            return nums[p];  
        } else if(p > k) {  
            return findKthLargest(nums, l, p-1, k);  
        } else {  
            return findKthLargest(nums, p+1, h, k);  
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