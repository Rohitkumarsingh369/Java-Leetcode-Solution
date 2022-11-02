class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int level = 0;
        int len = bank.length;
        char[] chr = {'A','C','G','T'};
            
        Set<String> hset = new HashSet<String>();
        for(String s: bank){
            hset.add(s);
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        while(true){
            level++;
            int n = queue.size();
            
            if(n == 0){
                return -1;
            }
            
            for(int i =0; i < n; i++){
                char[] ch = queue.poll().toCharArray();
                
                for(int j =0; j < 8; j++){
                    char org_char = ch[j];
                    for(int c = 0; c<4; c++){
                        ch[j] = chr[c]; 
                        String str = String.valueOf(ch);
                        if(str.equals(end)
                          && hset.contains(str)){
                            return level;
                        }
                        
                        if(!hset.contains(str)){
                            continue;
                        }
                        
                        hset.remove(str);
                        queue.add(str);
                    }
                    ch[j] = org_char;
                }
            }
        }
    }
}