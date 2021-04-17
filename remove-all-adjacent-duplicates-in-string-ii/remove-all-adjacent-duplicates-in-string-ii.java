class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Item> deque = new LinkedList();
        
        //Gready Apprach,
        //whenever we find the k consecutive same character just remove the dequeu (stack)
        
        for(char c : s.toCharArray()){
            if(deque.isEmpty()){
                deque.addLast(new Item(c, 1));
                continue;
            }
            
            //last stored item
            Item item = deque.peekLast();

            if(item.c != c){
                deque.addLast(new Item(c, 1));
                continue;
            }
            
            if(item.count == k - 1){
                deque.removeLast();
            }else{
                item.count++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            Item item = deque.removeFirst();
            
            while(item.count --> 0){
                sb.append(item.c);
            }
        }
        
        //sb.reverse();
        
        return sb.toString();
        
    }
}

class Item {
    char c;
    int count;
    
    public Item(char c, int count){
        this.c = c;
        this.count = count;
    }
}