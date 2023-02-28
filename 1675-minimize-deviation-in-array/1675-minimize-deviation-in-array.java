class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) nums[i] *= 2;
            set.add(nums[i]);
        }
        if(set.size() == 1) return 0;
        int ans = Integer.MAX_VALUE;
        while(set.size() != 1) {
            int smallest = set.first();
            int highest = set.last();
            ans = Math.min(ans, highest - smallest);
            set.remove(highest);
            if(highest % 2 == 0) {
                if(highest /2 == smallest && set.size() == 1) return 0;
                set.add(highest/2);
            }else {
                break;
            }
        }
        return ans;
    }
}