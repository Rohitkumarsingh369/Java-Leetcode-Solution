class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int sum=0;
            for(int j=0;j<nums.length;j++)
            {
                sum+=nums[j];
                if(sum>queries[i])
                {
                    ans[i]=j;
                    break;
                }
                if(j==nums.length-1 && sum<=queries[i])
                    ans[i]=j+1;
            }
        }
        return ans;
    }
}