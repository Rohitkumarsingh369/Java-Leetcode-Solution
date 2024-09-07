class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                // Pop two operands
                int b = stack.pop();
                int a = stack.pop();
                // Apply the operator and push the result back to the stack
                stack.push(applyOperator(a, b, token));
            } else {
                // Push the number to the stack
                stack.push(Integer.parseInt(token));
            }
        }

        // The result is the last element in the stack
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }  
    }
}