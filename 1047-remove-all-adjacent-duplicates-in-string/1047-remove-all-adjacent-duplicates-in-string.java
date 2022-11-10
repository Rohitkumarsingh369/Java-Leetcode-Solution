class Solution {
    public String removeDuplicates(String s) {
        
        Stack<Character> stack=new Stack();
        
        for(char c:s.toCharArray()){
            
            if(!stack.isEmpty() && stack.peek()==c){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        
        StringBuilder result=new StringBuilder();
        
        while(!stack.isEmpty())
            result.append(stack.pop());
        
        
        return result.reverse().toString();
    }
}