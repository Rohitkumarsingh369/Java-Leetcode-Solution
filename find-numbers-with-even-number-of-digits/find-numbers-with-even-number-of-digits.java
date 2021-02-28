class Solution {
    public int findNumbers(int[] nums) {
        
        int n=nums.length;
        
        int result_count=0;
        for(int i=0;i<n;i++){
            int temp=nums[i];
            int digit=0,count=0;
            while(temp>0){
                digit=temp%10;
                count++;
                temp=temp/10;
            }
            if(count%2==0)
                result_count+=1;
        }
        
        return result_count;
    }
}