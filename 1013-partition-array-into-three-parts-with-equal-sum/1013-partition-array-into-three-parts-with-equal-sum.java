class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        
        int sum=0;
        for(int num:arr){
            sum+=num;
        }
        int average=sum/3;
        
        int part=0;
        int count=0;
        for(int num:arr){
            part+=num;
            
            if(part==average){
                ++count;
                part=0;
            }
        }
        
        return count>=3 && sum%3==0;
    }
}