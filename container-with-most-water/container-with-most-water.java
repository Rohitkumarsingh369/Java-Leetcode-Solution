class Solution {
    public int maxArea(int[] a) {
        
        int first=0;
        int last=a.length-1;
        
        int area=0;
        
        while(first<last){
            
            area=Math.max(area,Math.min(a[first],a[last])*(last-first));
            
            if(a[first]<a[last])
                first+=1;
            else
                last-=1;
        }
        return area;
    }
}
