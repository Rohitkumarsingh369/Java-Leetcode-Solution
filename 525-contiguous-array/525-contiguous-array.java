class Solution {
   public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max=0;
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++) {
            sum+=(nums[i]==0?-1:1);
            Integer index = map.get(sum);
            if(index!=null) {
                max=Math.max(i-index,max);
            } else {
                map.put(sum,i);       
            }
        }
        return max;
    }
}