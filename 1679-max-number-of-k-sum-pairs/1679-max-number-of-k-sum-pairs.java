class Solution {
   /* public int maxOperations(int[] nums, int k) {
         Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k) {
                count++;
                i++;
                j--;
            }
            else if(sum > k) j--;
            else i++;
        }
        return count;
    }*/
    
     public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int res = k - nums[i];
            if(map.containsKey(res)){
                count++;
                if(map.get(res) == 1) map.remove(res);
                else map.put(res, map.get(res) - 1);
            }
            else{
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}