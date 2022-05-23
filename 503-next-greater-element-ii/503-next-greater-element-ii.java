class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }
        
       // int greater[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            int number=nums[i];
                while(!stack.isEmpty() && stack.peek()<=nums[i]){
                    stack.pop();
                }
           
            nums[i]=stack.empty()?-1:stack.peek();
            stack.push(number);
        }
        
        return nums;
    }
}