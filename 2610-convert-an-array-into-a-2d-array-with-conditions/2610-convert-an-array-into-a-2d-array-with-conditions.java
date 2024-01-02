class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int maxFreq=0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<maxFreq;i++){
            List<Integer> subList=new ArrayList<>();
            list.add(subList);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int number=entry.getKey();
            int freq=entry.getValue();
            for(int i=0;i<freq;i++){
                list.get(i).add(number);
            }
        }
        return list;
    }
}