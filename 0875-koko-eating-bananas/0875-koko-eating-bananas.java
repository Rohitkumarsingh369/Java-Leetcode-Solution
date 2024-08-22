class Solution {
    public int minEatingSpeed(int[] piles, int hour) {
        int low=1,high=findMax(piles);
        
        while(low<=high){
            int mid=low+(high-low)/2;
            
            int totalHour=calculateTotalHours(piles,mid);
            
            if(totalHour<=hour){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    
    private int findMax(int[] piles){
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<piles.length;i++){
            if(max<piles[i]){
                max=piles[i];;
            }
        }
        return max;
    }
    
    private int calculateTotalHours(int[] piles, int hourly){
        int totalHours=0;
        
        for(int i=0;i<piles.length;i++){
            totalHours+=Math.ceil((double)(piles[i])/(double)(hourly));
        }
        
        return totalHours;
    }
}