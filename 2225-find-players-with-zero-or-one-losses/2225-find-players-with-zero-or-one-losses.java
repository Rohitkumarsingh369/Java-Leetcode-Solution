class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer,Integer> hm=new TreeMap<>();//to store no of matches each player lost
        int n=matches.length;
        for(int i=0;i<n;i++){
            if(hm.containsKey(matches[i][0]))
                hm.put(matches[i][0],hm.get(matches[i][0]));
            else
                hm.put(matches[i][0],0);
            
            if(hm.containsKey(matches[i][1]))
                hm.put(matches[i][1],hm.get(matches[i][1])+1);
            else
                hm.put(matches[i][1],1);
        }

        List<List<Integer>> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        for(int key:hm.keySet()){
            if(hm.get(key)==0){
                list1.add(key);
            }
            if(hm.get(key)==1){
                list2.add(key);
            }
        }

        list.add(list1);
        list.add(list2);
        return list;
    }
}