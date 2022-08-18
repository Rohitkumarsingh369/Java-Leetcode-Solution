class Solution {
    public int minSetSize(int[] arr) {
        int len=arr.length;
        int remaining=len;
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
      
            //imp to note how to convert map to list
        List<Integer>list=map.values().stream().collect(Collectors.toList());


                //sort in reverse order
        Collections.sort(list,Collections.reverseOrder());
            int index=0;
            while(remaining>len/2){
                remaining-=list.get(index);
                index++;
            }
            return index;
    }
   
}