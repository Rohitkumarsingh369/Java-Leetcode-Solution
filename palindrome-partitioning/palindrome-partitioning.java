class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> allpart=new ArrayList<>();
        Deque<String> currpart=new LinkedList<>();
        
        allpartition(allpart,currpart,0,s.length(),s);
        
        return allpart;
    }
    
    public void allpartition(List<List<String>> allpart,Deque<String> currpart,int start,int n,String input){
        
        if(start>=n){
            allpart.add(new ArrayList<>(currpart));
            return;
        }
        
        for(int i=start;i<n;i++){
            
            if(ispalindrome(input,start,i)){
                
                currpart.addLast(input.substring(start,i+1));
                
                allpartition(allpart,currpart,i+1,n,input);
                
                currpart.removeLast();
            }
        }
    }
    
    public boolean ispalindrome(String input,int start,int end){
        while(start<end){
            if(input.charAt(start++)!=input.charAt(end--))
                return false;
        }
        return true;
    }
}