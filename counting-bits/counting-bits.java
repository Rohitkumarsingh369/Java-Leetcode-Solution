class Solution {
    public int[] countBits(int num) {
        
        int count;
        int result[]=new int[num+1];
        for(int i=0;i<=num;i++){
            int n=i;;
            count=0;
            while(n!=0){
                n=n&(n-1);
                count++;
            }
            result[i]=count;
        }
        
        return result;
    }
}