class MinStack {
    Stack<Integer> stk=new Stack<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    public void push(int val) {
        if(min>=val){
            stk.push(min);
            min = val;
        }
        stk.push(val);
    }
    
    public void pop() {
        
        if(stk.pop()==min){
            min = stk.pop();
        }            
    }
    
    public int top() {       
        return stk.peek();
    }
    public int getMin() {
        return min;
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