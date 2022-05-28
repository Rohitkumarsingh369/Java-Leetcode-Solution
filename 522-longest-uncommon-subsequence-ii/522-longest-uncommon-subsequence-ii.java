class Solution {
   /* public int findLUSlength(String[] strs) {
    Map<String, Integer> subseqFreq = new HashMap<>();
    for (String s : strs) {
       Set<String> result=getSubseqs(s);
         System.out.println(result);
        for (String subSeq : getSubseqs(s)){
            
            subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
        }
    }
    int longest = -1;
    for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
        if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
    return longest;
}

public static Set<String> getSubseqs(String s) {
    Set<String> res = new HashSet<>();
    if (s.length() == 0) {
         res.add("");
         return res;
    }
    Set<String> subRes = getSubseqs(s.substring(1));
    res.addAll(subRes);
    for (String seq : subRes) res.add(s.charAt(0) + seq);
    return res;
    
}*/
    public int findLUSlength(String[] strs) {
        int len = strs.length;
        
        // reverse sorting array with length 
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        for(int i=0; i<len; i++){
            int missMatchCount = strs.length - 1;
            for(int j=0; j<len; j++){
                if(i != j && !isSubSequence(strs[i], strs[j])){
                    missMatchCount --;
                }
            }
            
            // strs[i] is not a sub sequence of any other entry
            if(missMatchCount == 0){
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    private boolean isSubSequence(String s1, String s2){
        int idx = 0;
        for(char ch : s2.toCharArray()){
            if(idx < s1.length() && ch == s1.charAt(idx)){
                idx++;
            }
        }
        
        return idx == s1.length();
    }
}