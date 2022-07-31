class NumArray {
    int[] buckets;
    int size;
    int[] A;

    public NumArray(int[] nums) {
        this.A = nums;
        double root = Math.sqrt(nums.length);
        size = (int) Math.ceil(nums.length / root);
        buckets = new int[size];
        int bucketNumber = 0;
        
        for(int i = 0; i < nums.length; i++){
            bucketNumber = i / size;
            buckets[bucketNumber] += nums[i];
        }
    }
    
    public void update(int index, int val) {
        int bucketNumber = index / size;
        buckets[bucketNumber] -= A[index];
        buckets[bucketNumber] += val;
        A[index] = val;
    }
    
    public int sumRange(int left, int right) {
        
        int startBucket = left / size;
        int endBucket = right / size;
        int sum = 0;
        
        if(startBucket != endBucket){
            // for the startBucket which is partial
            int endStartBucket = startBucket * size + size;
            for(int i = left; i < endStartBucket; i++){
                sum += A[i];
            }
            
            // for complete buckets included
            for(int i = startBucket + 1; i < endBucket; i++){
                sum += buckets[i];
            }
            
            // for the endBucket which is partial
            for(int i = endBucket * size; i < right + 1; i++){
                sum += A[i];
            }  
        }
        else{
            for(int i = left; i <= right; i++){
                sum += A[i];
            }
        }
        return sum;
    }
}