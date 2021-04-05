class MyCircularQueue {

    int size;
    int arr[];
    int count = 0;
    int f = -1,r = -1;

    public MyCircularQueue(int k) {
        this.size = k;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(count == size) return false;
        r = (++r % size);
        count++;
        arr[r] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(count == 0) return false;
        count--;
        f = (++f % size);
        return true;        
    }
    
    public int Front() {
        if(count != 0)
            return arr[( f + 1 ) % size];
        return -1;
    }
    
    public int Rear() {
        if(count != 0)
            return arr[r];
        return -1;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */