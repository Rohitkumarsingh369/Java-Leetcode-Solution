class Solution {
    public int bulbSwitch(int n) {
        long low=0;
        long high=n;
        while(low<=high){
            long mid=low+(high-low)/2;
            if((mid*mid)==n)
                return (int)mid;
            else if((mid*mid)<n)
                low=mid+1;
            else
                high=mid-1;
        }
        return (int)low-1;
    }
}