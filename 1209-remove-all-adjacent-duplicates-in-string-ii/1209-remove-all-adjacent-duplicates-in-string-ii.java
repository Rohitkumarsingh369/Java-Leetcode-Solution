class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int []> Master = new Stack<>();
        
        for(char ch : s.toCharArray()){
            if(!Master.isEmpty() && Master.peek()[0] == ch){
                Master.peek()[1]++;
            }
            else Master.push(new int[]{ch, 1});
            if(Master.peek()[1] == k) Master.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!Master.isEmpty()){
            int top[] = Master.pop();
            while(top[1] --> 0)
                sb.append((char)top[0]);
        }
        return sb.reverse().toString();
    }
}