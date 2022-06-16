class MinStack {

    Stack<Node> s;
    class Node{
        int val, min;
        Node(int val,int min){
            this.val=val;
            this.min=min;
        }
    }
    /** initialize your data structure here. */
    public MinStack() {
        s=new Stack<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
            s.push(new Node(x,x));
        }
        else{
            int min=Math.min(s.peek().min,x);
            s.push(new Node(x,min));
        }
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
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