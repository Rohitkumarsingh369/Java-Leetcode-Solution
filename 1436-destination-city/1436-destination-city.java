class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,String> routes = new HashMap<>();
        String start = "";
        for(List<String> path: paths){
            if(start == "")
                start = path.get(0);
            routes.put(path.get(0), path.get(1));
        }   

        while(routes.containsKey(start)){
            start = routes.get(start);
        }

        return start;
    }
}