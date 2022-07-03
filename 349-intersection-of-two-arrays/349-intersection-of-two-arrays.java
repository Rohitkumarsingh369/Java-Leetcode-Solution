class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> intersect=new HashSet<>();
        
        for(int num:nums1){
            set.add(num);
        }
        
        for(int num:nums2){
            if(set.contains(num)){
                intersect.add(num);
            }
        }
        
        int result[]=new int[intersect.size()];
        
        int position=0;
        
        for(Integer num:intersect){
            result[position++]=num;
        }
        
        return result;
    }
}