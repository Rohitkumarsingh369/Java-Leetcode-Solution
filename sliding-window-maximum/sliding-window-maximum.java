class Solution {
   
     public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        if(n<=0)return a;
	        Deque<Integer> dq=new LinkedList<>();
	        int ans[]=new int[n-k+1];
	        int i=0;
	        for(;i<k;i++) {
	        	while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]) {
	        		dq.removeLast();
	        	}
	        	dq.addLast(i);
	        }
	        for(;i<n;i++) {
	        	ans[i-k]=a[dq.peekFirst()];
	        	while(!dq.isEmpty() && dq.peekFirst()<=i-k) {
	        		dq.removeFirst();
	        	}
	        	while(!dq.isEmpty() && a[dq.peekLast()]<=a[i]) {
	        		dq.removeLast();
	        	}
	        	dq.addLast(i);
	        }
	        ans[i-k]=a[dq.peekFirst()];
	        return ans;
    }
   /* public int[] maxSlidingWindow(int[] a, int k) {
        
        //max heap
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        
        //length of the array
        int n=a.length;
        
        
        
        //return array
        int result[]=new int[n-k+1];
        int index=0;
        
        int i=0;
        
        for(;i<k;i++)
            queue.add(a[i]);
        
        result[index++]=queue.peek();
            queue.remove(a[0]);
        
        for(;i<n;i++){
            
            queue.add(a[i]);
            
            result[index++]=queue.peek();
            
            queue.remove(a[n-k+1]);
        }
        
        return result;
    }*/
   
}