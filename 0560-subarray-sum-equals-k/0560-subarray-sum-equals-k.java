class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
         int result=0,sum=0;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        int preSum = 0, cnt = 0;

        hmap.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += nums[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt +=  hmap.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
             hmap.put(preSum,  hmap.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
        //return result;
    }
}