class Solution {
    boolean canComplete(int[] time, long givenTime, long totalTrips){
        long trips = 0;
        for(int t:time){
            trips += givenTime/t;
        }
        return trips>=totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        long min = Long.MAX_VALUE;
        for(int t:time){
            if(t<min) min=t;
        }
 
        long s = 1;
        long e = min*totalTrips;

        while(s<e){
            long m = s+(e-s)/2;
            if(canComplete(time, m, totalTrips)){
                e=m;
            }
            else{
                s = m+1;
            }
        }
        return s;
   }
   
}