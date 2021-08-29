class Solution {
       private class Job {
        int st, ed, profit;
        Job(int st, int ed, int profit) {
            this.st = st;
            this.ed = ed;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        
        for(int i=0;i<n;i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        return Aptschedule(jobs);
    }

    private int Aptschedule(Job[] jobs) {
        // Sort jobs according to ed time
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.ed));
        // dp[i] stores the profit for jobs till jobs[i]
        // (including jobs[i])
        int n = jobs.length;
        int[] dp = new int[n];
        dp[0] = jobs[0].profit;
        for (int i=1; i<=n-1; i++) {
            // Profit including the current job
            int profit = jobs[i].profit;
            int l = search(jobs, i);
            if (l != -1)
                profit += dp[l];
            // Store maximum of including and excluding
            dp[i] = Math.max(profit, dp[i-1]);
        }

        return dp[n-1];
    }

    private int search(Job[] jobs, int index) {
        int st = 0, end = index - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (jobs[mid].ed <= jobs[index].st) {
                if  (jobs[mid + 1].ed > jobs[index].st){
                    return mid;} 
                else{
                    st = mid + 1;}
            }
            else {
                end = mid - 1;}
        }
        return -1;
    }
}