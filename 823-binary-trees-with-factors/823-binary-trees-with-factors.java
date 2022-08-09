class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 1;
        }
        Arrays.sort(arr);
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i], i);
        }
        
        long ans = 0;
        int remaining = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] % arr[j] == 0){
                    remaining = arr[i] / arr[j];
                    if(map.containsKey(remaining)){
                        dp[i] += dp[j] * dp[map.get(remaining)];
                    }
                }
            }
        }
        
        for(long v : dp){
            ans += v;
        }
        return (int) (ans % 1_000_000_007);
    }
}