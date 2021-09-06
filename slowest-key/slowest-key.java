class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max=releaseTimes[0];
        char result=keysPressed.charAt(0);
        
        for(int i=1;i<keysPressed.length();i++){
            int time=releaseTimes[i]-releaseTimes[i-1];
            if(max<time){
                max=time;
                result=keysPressed.charAt(i);
            }
            else if(time==max){
                if(keysPressed.charAt(i)>result)
                    result=keysPressed.charAt(i);
            }
        }
       
        return result;
    }
}