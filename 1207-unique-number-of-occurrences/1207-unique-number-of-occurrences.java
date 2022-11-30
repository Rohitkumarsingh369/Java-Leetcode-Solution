class Solution {
   /* public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }*/
    public boolean uniqueOccurrences(int[] arr){
        // -1000 -> 0
        // 1000 -> 2000
        int[]freq = new int[2001];
        boolean[]exist = new boolean[arr.length+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]+1000]++;
        }
        for(int i=0;i<2001;i++){
            if(freq[i]!=0&&exist[freq[i]]){return false;}
            exist[freq[i]]=true;
        }
        return true;
    }
}