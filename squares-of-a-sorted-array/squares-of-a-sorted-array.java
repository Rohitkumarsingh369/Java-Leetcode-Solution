class Solution {
    public int[] sortedSquares(int[] nums) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]*nums[i]);
        }
        
        int result[]=new int[pq.size()];
        int index=0;
        while(!pq.isEmpty()){
            result[index++]=pq.remove();
        }
        return result;
    }
}