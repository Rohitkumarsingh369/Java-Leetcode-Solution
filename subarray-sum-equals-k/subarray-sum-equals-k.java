class Solution {
    public int subarraySum(int[] nums, int k) {
         int result=0,sum=0;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        for(int i:nums){
            sum+=i;
            if(sum==k){
                result++;
            }
            if(hmap.containsKey(sum-k)){
                int count=hmap.get(sum-k);
                result+=count;
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return result;
    }
}