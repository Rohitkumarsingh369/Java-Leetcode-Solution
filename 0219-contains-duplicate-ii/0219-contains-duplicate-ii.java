class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int flag=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int pos=map.get(nums[i]);
                if(Math.abs(pos-i)<=k)
                {
                    flag=1;
                }
                map.put(nums[i],i);
            }
            else
                map.put(nums[i],i);
        }
        
        if(flag==1)
            return true;
        
        return false;
    }
}