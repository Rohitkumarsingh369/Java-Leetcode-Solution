class Solution {
    public int minStoneSum(int[] piles, int k) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<piles.length;i++){
            pq.add(piles[i]);
           
        }
        
       
        for(int i=0;i<k;i++){
            int temp=pq.poll();
            int res=temp-(int)Math.floor(temp/2);
           // System.out.print(res+" ");
            pq.add(res);
        }
        
        
        
        int result=0;
        for(int i=0;i<piles.length;i++){
            result+=pq.poll();
        }
        
        return result;
    }
}