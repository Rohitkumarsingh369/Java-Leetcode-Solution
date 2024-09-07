class Solution {
    public boolean isValid(String s) {
       // Use a stack to keep track of opening parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            // Push opening parentheses onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Check closing parentheses
            else if (c == ')' || c == '}' || c == ']') {
                // If the stack is empty or the top of the stack does not match the corresponding opening parenthesis
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all parentheses are matched; otherwise, there are unmatched opening parentheses
        return stack.isEmpty();
    }

    // Helper method to check if two characters are matching pairs
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    } 
}