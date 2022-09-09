class Solution {
    public int tupleSameProduct(int[] nums) {
        int m = nums.length;
        int factor = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < m - 1; i ++) {
            for(int j = i + 1; j < m; j ++) {
                int curNumber = nums[i] * nums[j];
                int curNumberCount = (hm.containsKey(curNumber)) ? hm.get(curNumber) + 1 : 1;
                hm.put(curNumber, curNumberCount);
            }
        }
        
		// check the qty of number, and we can get n * (n - 1) / 2 compositions
		
        for(Integer key: hm.keySet()) {
            int count = hm.get(key);
            if(count == 1) continue;
            factor += count * (count - 1) / 2;
        }
        return factor * 8;
    }
}