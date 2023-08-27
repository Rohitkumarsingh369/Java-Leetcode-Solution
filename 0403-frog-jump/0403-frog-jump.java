class Solution {
    public boolean traverse(int[] arr,Stack<Integer> s,int stepl,HashMap<String,Boolean> map){
       int k=s.peek();
       String keys=k+"-"+stepl;
       if(map.containsKey(keys)){
           return false;
       }
       if(k==arr[arr.length-1]){
           return true;
       }
       for(int i=0;i<arr.length;i++){
           if(arr[i]==k){
                if(stepl>1){
                    s.push(k+stepl-1);
                    if(traverse(arr,s,stepl-1,map)){
                        return true;
                    }
                    s.push(k+stepl);
                    if(traverse(arr,s,stepl,map)){
                        return true;
                    }
                    s.push(k+stepl+1);
                    if(traverse(arr,s,stepl+1,map)){
                        return true;
                    }
                }
                else if(stepl==1){
                    s.push(k+stepl);
                    if(traverse(arr,s,stepl,map)){
                        return true;
                    }
                    s.push(k+stepl+1);
                    if(traverse(arr,s,stepl+1,map)){
                        return true;
                    }
                }  
                break;             
           }
           
       }
       s.pop();
       //String keys=;
       map.put(keys,false);
       return false;
    }
    public boolean canCross(int[] stones) {
        
        Stack<Integer> s=new Stack<>();
        s.push(1);
        HashMap<String,Boolean> map=new HashMap<>();
        //string=index-step
        //when u have to reduce the time complexity and u have no exact key then key can be a string as above
        return traverse(stones,s,1,map);
    }
}