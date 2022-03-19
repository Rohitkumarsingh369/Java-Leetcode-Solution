class FreqStack {
    Map<Integer, LinkedList<Integer>> st;
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq;
    public FreqStack() {
        st = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currFreq = map.getOrDefault(val, 0);
        currFreq++;
        map.put(val, currFreq);
        
        if(st.containsKey(currFreq) == false){
            st.put(currFreq, new LinkedList<Integer>());
        }
        st.get(currFreq).addFirst(val);
        maxFreq = Math.max(maxFreq, currFreq);
    }
    
    public int pop() {
        int ans = st.get(maxFreq).removeFirst();
        
        int currFreq = map.get(ans);
        currFreq--;
        map.put(ans, currFreq);
        if(st.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */