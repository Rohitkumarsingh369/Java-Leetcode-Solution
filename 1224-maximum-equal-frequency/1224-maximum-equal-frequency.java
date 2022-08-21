class Solution {
    public int maxEqualFreq(int[] nums) {
         int[] cnt = new int[100001], freq = new int[100001];
        int maxF=0,res=0;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            cnt[num]++;
            freq[cnt[num]-1]--;
            freq[cnt[num]]++;
            maxF=Math.max(maxF,cnt[num]);
            if(maxF*freq[maxF]==i||(maxF-1)*(freq[maxF-1]+1)==i||maxF==1)
                res = i+1;
        }
        return res;
    }
}