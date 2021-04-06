class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int count[]=new int[max+1];
        
        for(int i=0;i<nums.length;i++){
               count[nums[i]]++;
        }
        for(int i=0;i<count.length;i++){
               if(count[i]>1)
                   result.add(i);
        }
        for(int i=0;i<count.length;i++){
              System.out.print(count[i]+" ");
        }
        return result;
    }
}