class Solution {
     public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> mp = new HashMap<>();
        int ans = 0;
        
        for(int i=0;i<s.length();++i)
            mp.putIfAbsent(s.charAt(i), new LinkedList<>());
        
        for(String word : words) {
            char startCh = word.charAt(0);
            if(mp.containsKey(startCh))
                mp.get(startCh).offer(word);
        }
        
        for(int i=0;i<s.length();++i) {
            char startCh = s.charAt(i);
            Queue<String> que = mp.get(startCh);
            int size = que.size();
            for(int j=0;j<size;++j) {
                String str = que.poll();
                if(str.substring(1).length()==0)
                    ans++;
                else
                    if(mp.containsKey(str.charAt(1)))
                        mp.get(str.charAt(1)).add(str.substring(1));
            }
        }
        
        return ans;
    }
}