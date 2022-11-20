class Solution {
   public int calculate(String s) {
    if(s == null) return 0;  
    int result = 0, sign = 1, currentNum = 0;   
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(sign);
            
    for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);       
        if(Character.isDigit(ch)) {
            currentNum = currentNum * 10 + (ch - '0');           
        } else if(ch == '+' || ch == '-') {
            result += sign * currentNum;
            sign = stack.peek() * (ch == '+' ? 1: -1); 
            currentNum = 0;          
        } else if(ch == '(') {
            stack.push(sign);
        } else if(ch == ')') {
            stack.pop();
        }
    }
    result += sign * currentNum;
    return result;  
    }
}