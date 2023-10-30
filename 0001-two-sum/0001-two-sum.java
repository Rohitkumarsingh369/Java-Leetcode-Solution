class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<numbers.length;i++){
            int number1=numbers[i];
            
            if(map.containsKey(target-number1)){
                return new int[]{map.get(target-number1),i};
            }
            
            map.put(numbers[i],i);
        }
        
        return new int[]{-1,-1};
    }
}