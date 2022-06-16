class MinStack {

    int minelement;
    Stack<Integer> stack;
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            minelement=Integer.MAX_VALUE;
        
        if(val<minelement)
            minelement=val;
        
        stack.push(val);
        stack.push(minelement);
    }
    
    public void pop() {
        stack.pop();
        stack.pop();
        
        if(!stack.isEmpty())
            minelement=stack.peek();
    }
    
    public int top() {
        int remain=stack.pop();
        int top=stack.peek();
        stack.push(remain);
        return top;
    }
    
    public int getMin() {
    
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */