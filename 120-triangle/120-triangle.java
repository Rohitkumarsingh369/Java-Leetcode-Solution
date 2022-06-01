class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       if(triangle.size()==0)
           return 0;
        
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> nextrow=triangle.get(i+1);
            int j=0;
            while(j<=i){
                
                int sum=Math.min(nextrow.get(j),nextrow.get(j+1))+triangle.get(i).get(j);
                
                triangle.get(i).set(j,sum);
                j++;
            }
        }
       return  triangle.get(0).get(0);
    }
}