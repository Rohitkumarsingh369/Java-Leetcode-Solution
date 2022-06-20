/*class Solution {
    public String frequencySort(String s) {
        
    }
}*/
import java.util.Map.Entry;
class Solution {

    public String frequencySort(String s) {
        
    	char str[]=s.toCharArray();
        
    	Map<Character,StringBuilder> map=new HashMap<Character, StringBuilder>();
    	
        for(int i=0;i<str.length;i++)
    		map.put(str[i], map.getOrDefault(str[i], new StringBuilder()).append(str[i]));
    	
        List<Entry<Character, StringBuilder>> list=new ArrayList<>(map.entrySet());
    	
        Collections.sort(list,(o1,o2)->o2.getValue().length()-o1.getValue().length());
    	
        StringBuilder ans=new StringBuilder();
    	
        for(Entry<Character, StringBuilder> pa : list)
    		ans.append(pa.getValue());
    	
        return ans.toString();
    }
}