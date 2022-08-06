class Solution {
   
    public int minDays(int[] bloomDay, int m, int k){
        
        if(bloomDay.length<m)
            return -1;
        int n=bloomDay.length,min=bloomDay[0],max=bloomDay[0],result=-1;
        
        for(int i=0;i<n;i++){
            min=Math.min(bloomDay[i],min);
            max=Math.max(bloomDay[i],max);
        }
        
        while(min<=max){
            int mid=min+(max-min)/2;
            
            if(solve(bloomDay,mid,m,k)){
                result=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
            
        }
        return result;
    }
    public boolean solve(int nums[],int day,int m,int k){
     int flowercollected=0,bouqet=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=day){
                flowercollected++;
            }
            else{
                flowercollected=0;
            }
            if(k==flowercollected){
                bouqet++;
                flowercollected=0;
            }
        }
        
        return bouqet>=m;
    }
}