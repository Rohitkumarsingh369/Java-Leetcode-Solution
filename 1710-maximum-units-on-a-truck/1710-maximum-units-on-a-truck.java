class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a, b) -> b[1] - a[1]);
        
        int i=0;
        
        int result=0;
        while(truckSize>0 && i<n){
            int size=Math.min(boxTypes[i][0],truckSize);
            truckSize-=size;
            
            result+=size*boxTypes[i][1];
            i++;
        }
        return result;
    }
}