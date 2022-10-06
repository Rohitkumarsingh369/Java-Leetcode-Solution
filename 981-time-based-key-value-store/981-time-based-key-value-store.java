class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<Data>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }
    
    protected String binarySearch(List<Data> list, int time) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid).time == time) return list.get(mid).val;
            if (list.get(mid).time < time) {
                if (list.get(mid+1).time > time) return list.get(mid).val;
                start = mid + 1;
            }
            else end = mid -1;
        }
        return list.get(start).time <= time ? list.get(start).val : "";
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */