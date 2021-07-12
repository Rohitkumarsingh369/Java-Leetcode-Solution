class Solution {
    public boolean isIsomorphic(String s, String t) {
    if(s.length()!=t.length()){
        return false;
    }
 
    HashMap<Character, Character> map1 = new HashMap<>();
    HashMap<Character, Character> map2 = new HashMap<>();
 
    for(int i=0; i<s.length(); i++){
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);
 
        if(map1.containsKey(c1)){
            if(c2!=map1.get(c1)){
                return false;
            }
        }else{
            if(map2.containsKey(c2)){
                return false;
            }
 
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
    }
 
    return true;
}
}