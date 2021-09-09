class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }
        
        int greater[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            
                while(!stack.isEmpty() && stack.peek()<=nums[i]){
                    stack.pop();
                }
           
            greater[i]=stack.empty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        
        return greater;
    }
}