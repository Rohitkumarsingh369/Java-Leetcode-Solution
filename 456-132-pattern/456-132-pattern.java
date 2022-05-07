class Solution {
    public boolean find132pattern(int[] nums) {
         //length of the array.
        int n = nums.length;
        //stack to maintain "3 2" pattern from "1 3 2"
        Stack<Integer> st = new Stack<>();
        //second represent second highest number i.e, 2 from "1 3 2"
        int second = Integer.MIN_VALUE;
        
        //Now, we are finding 1 as nums[i], stack will contain pattern 32 and we havee to find nums[i] which is less then second so it will also less then st.peek()
        for(int i = n-1; i >= 0; i--){
            if(nums[i] < second)
                return true;
            while(!st.isEmpty() && nums[i] > st.peek()){
                second = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}