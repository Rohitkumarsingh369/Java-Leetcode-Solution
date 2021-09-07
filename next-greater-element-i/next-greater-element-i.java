class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek()<=nums2[i])
                    stack.pop();
            }
            int greater=stack.empty()?-1:stack.peek();
            stack.push(nums2[i]);
            map.put(nums2[i],greater);
        }
        
        int nextgreater[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                nextgreater[i]=map.get(nums1[i]);
            }
        }
        return nextgreater;
    }
}