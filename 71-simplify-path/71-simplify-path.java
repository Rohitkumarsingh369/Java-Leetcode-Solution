class Solution {
    public String simplifyPath(String path) {
          if(path == null || path.equals(""))
            return path;
        List<String> list = new ArrayList<>();
        String str[] = path.split("/");
        String canonicalPath = "";
        for(String s : str){
            if(s.isEmpty())
                continue;
            if(s.equals("..")){
                if(!list.isEmpty()){
                    list.remove(list.size()-1);
                }
                continue;
            }
            if(s.equals("."))
                continue;
            list.add(s);
        }
        
        if(list.isEmpty())
            return "/";
        for(String c : list){
            canonicalPath += '/';
            canonicalPath += c;
        }
        return canonicalPath;
    }
}