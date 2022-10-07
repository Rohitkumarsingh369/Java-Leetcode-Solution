class MyCalendarThree {

    TreeMap<Integer,Integer> map;//for calender map
    public MyCalendarThree() {
        map = new TreeMap<>(); //init
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1); //putting start as +ve marking 
        map.put(end, map.getOrDefault(end,0)-1); //putting end as -ve marking. it will let us end an event started before by subtracting active events for that time;
        
        int maxActiveEvents = 0; 
        int activeEvents = 0;
        for(Integer it : map.values()){//getting values from tree-map (it will be in asc order of event time)
            activeEvents += it; //if we have active event it will add into it and since we used -ve it will sub the ending events.     
            maxActiveEvents = Math.max(maxActiveEvents, activeEvents); //max of active and max active.
        }
        return maxActiveEvents; //returning max.
    }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */