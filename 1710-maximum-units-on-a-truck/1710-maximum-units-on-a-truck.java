class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int n=boxTypes.length;
       // Arrays.sort(boxTypes,(a, b) -> b[1] - a[1]); may cause int overflow
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int i=0;
        
        int result=0;
        
        while(truckSize>0 && i<n){
            int size=Math.min(truckSize,boxTypes[i][0]);
            
            truckSize-=size;
            
            result+=size*boxTypes[i][1];
            
            i++;
        }
        
        return result;
        /*int result=0;
        while(truckSize>0 && i<n){
            int size=Math.min(boxTypes[i][0],truckSize);
            truckSize-=size;
            
            result+=size*boxTypes[i][1];
            i++;
        }
        return result;*/
    }
}


/*// Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); // b[1] - a[1] may cause int overflow, credit to @Zudas.
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int boxes = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                boxes += box[0] * box[1];
                truckSize -= box[0];
            }else {
                boxes += truckSize * box[1];
                return boxes;
            }
        }
        return boxes;*/