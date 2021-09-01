class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> intersection=new ArrayList<>();
        
        for(int element:nums1){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }
            else
                map.put(element,1);
        }
        
        for(int element:nums2){
            if(map.containsKey(element) && map.get(element)!=0){
                intersection.add(element);
                map.put(element,map.get(element)-1);
            }
            
        }
        
        int result[]=new int[intersection.size()];
        
        for(int i=0;i<intersection.size();i++){
            result[i]=intersection.get(i);
        }
        
        return result;
    }
    
}