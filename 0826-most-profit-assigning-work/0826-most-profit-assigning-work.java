class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int sum=0;
        int n=profit.length;
        int[][] jobs=new int[n][2];
        for(int i=0;i<n;i++){
            jobs[i][0]=difficulty[i];
            jobs[i][1]=profit[i];
        }
        Arrays.sort(jobs,(a,b) -> a[0]-b[0]);

        int[] maxProfit=new int[n];
        maxProfit[0]=jobs[0][1];
        for(int i=1;i<n;i++){
            maxProfit[i]=Math.max(maxProfit[i-1],jobs[i][1]);
        }
        Arrays.sort(worker);
        int j=0;
        for(int emp:worker){
            
            while(j<n && jobs[j][0]<=emp){
                j++;
            }
            if(j>0){
                sum+=maxProfit[j-1];
            }
        }
        return sum;
    }
}