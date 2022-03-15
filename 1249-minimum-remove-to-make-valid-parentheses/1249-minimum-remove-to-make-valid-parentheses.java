class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            //Character.isAlphabetic
            if(Character.isAlphabetic(c))
                continue;
            
            if(c=='(')
                stack.push(i);
            
            else{
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }
        
        StringBuilder result=new StringBuilder();
        HashSet<Integer> set=new HashSet<>(stack);
        
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                result.append(s.charAt(i));
            }
        }
        
        return result.toString();
    }
}