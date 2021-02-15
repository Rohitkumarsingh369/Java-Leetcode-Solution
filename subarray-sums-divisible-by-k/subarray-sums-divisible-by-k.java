class Solution {
    public int subarraysDivByK(int[] a, int k) {
       int mod[]=new int[k];
        Arrays.fill(mod,0);
        
        int cumsum=0;
        int n=a.length;
        for(int i=0;i<n;i++){
            cumsum+=a[i];
            mod[((cumsum%k)+k)%k]++;
        }
        int result=0;
        for(int i=0;i<k;i++){
            if(mod[i]>1)
            result+=(mod[i]*(mod[i]-1))/2;
        }
        result+=mod[0];
        
        return result;
    }
}