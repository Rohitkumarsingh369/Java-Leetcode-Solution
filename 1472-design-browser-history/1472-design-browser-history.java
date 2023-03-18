class BrowserHistory {
    Stack<String> container = new Stack<>();
    Stack<String> fwd = new Stack<>();
    public BrowserHistory(String homepage) {
        container.add(homepage);
    }
    
    public void visit(String url) {
        container.add(url);
        fwd = new Stack<>();
    }
    
    public String back(int steps) {
        while(container.size() > 1 && steps > 0){
            fwd.add(container.pop());
            steps--;
        }
        return container.peek();
    }
    
    public String forward(int steps) {
        while(fwd.size() > 0 && steps > 0){
            container.add(fwd.pop());
            steps--;
        }
        return container.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */