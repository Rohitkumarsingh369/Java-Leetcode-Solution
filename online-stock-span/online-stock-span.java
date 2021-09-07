class StockSpanner {
class Node
{
    int price;
    int count;
    
    Node(int price, int count)
    {
        this.price = price;
        this.count = count;
    }
}

Stack<Node> stack = null;

public StockSpanner() {
    stack = new Stack<>();
}

public int next(int price) {
    if(stack.isEmpty() || stack.peek().price > price)
    {
        stack.push(new Node(price,1));
        return 1;
    }
    
    int span = 1;
    while(!stack.isEmpty() && stack.peek().price <= price)
    {
        span += stack.pop().count;
    }
    
    stack.push(new Node(price,span));  
    return span;
}
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */