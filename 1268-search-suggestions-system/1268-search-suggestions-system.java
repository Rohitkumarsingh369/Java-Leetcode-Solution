class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       List<List<String>> fl = new ArrayList<>();
        
        String s = "";
        
        HashMap<String, List<String>> map = new LinkedHashMap<>();
        
        for(int i = 0; i < searchWord.length(); i++)
        {
            s += searchWord.charAt(i);
            
            int len = s.length();
            
            List<String> list = new ArrayList<>();
            
            for(String product : products)
            {
                if(product.length() < len)
                {
                    continue;
                }
                
                String test = product.substring(0, len);
                
                if(test.equals(s))
                {
                    list.add(product);
                }
            }
            
            Collections.sort(list);
            
            while(list.size() > 3)
            {
                list.remove(list.size() - 1);
            }
            
            map.put(s, list);
        }
      
        
        for(List<String> l : map.values())
        {
            fl.add(l);
        }
        
        return fl;
    }
}