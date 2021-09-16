class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        
        boolean part[]=new boolean[sum/2+1];
        Arrays.fill(part,false);
        
        for(int i=0;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--){
                if(part[j-nums[i]]==true||j==nums[i])
                    part[j]=true;
            }
        }
        return part[sum/2];
    }
}