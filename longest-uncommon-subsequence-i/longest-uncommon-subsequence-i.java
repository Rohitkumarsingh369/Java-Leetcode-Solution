class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)==true)
            return -1;
        
        return Math.max(a.length(),b.length());
    }
}