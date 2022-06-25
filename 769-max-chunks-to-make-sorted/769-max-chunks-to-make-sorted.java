class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int max=0;
        int chunk_count=0;
        
        for(int i=0;i<arr.length;i++){
            
            max=Math.max(max,arr[i]);
            
            if(i==max){
                chunk_count++;
            }
        }
        
        return chunk_count;
    }
}