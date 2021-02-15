class Solution {
    public int subarraysDivByK(int[] a, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int sum=0,rem=0,ans=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            rem=sum%k;
            if(rem<0)
                rem+=k;
            
            if(mp.containsKey(rem)){
                ans+=mp.get(rem);
                mp.put(rem,mp.get(rem)+1);
            }
            else
                mp.put(rem,1);
        }
        
        return ans;
    }
}