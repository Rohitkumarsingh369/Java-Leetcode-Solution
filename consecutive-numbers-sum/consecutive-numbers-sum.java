class Solution {
    public int consecutiveNumbersSum(int n) {
        int count=0;
        for(int k=1;(k*(k-1))<(2*n);k++)
        {
            int numerator=n-(k*(k-1))/2;
            if(numerator%k==0)
            {
                count++;
            }
        }
        return count;
    }
}