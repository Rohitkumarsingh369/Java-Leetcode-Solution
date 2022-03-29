class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length,min=bloomDay[0],max=bloomDay[0],res=-1;
        for(int i=1;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        while(min<=max){
            int mid = min + (max-min)/2;
            if(solve(bloomDay,mid,k,m)){
                res=mid;
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return res;
    }
    public boolean solve(int[] nums,int day,int k,int m){
        int flowersCollected=0,bouquet=0;
        for(int num:nums){
            if(num<=day){
               flowersCollected++; 
            }
            else{
                flowersCollected=0;
            }
            if(k==flowersCollected){
                flowersCollected=0;
                bouquet++;
            }
        }
        return bouquet>=m;
    }
}