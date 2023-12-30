class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>();

        List<Character> list = new ArrayList<>();
        
        for(String s : words){
            for(int i=0; i<s.length(); i++){
                list.add(s.charAt(i));
            }
        }

        for(Character ch : list){
                if(map.containsKey(ch)){
                    Integer a = map.get(ch);
                    map.put(ch, a=a+1);
                }
                else
                    map.put(ch, 1);
            }

        for(Map.Entry<Character, Integer> m : map.entrySet()){
            if(m.getValue() % words.length != 0)
                return false;
        }

        return true;
    }
}