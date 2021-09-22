class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= b.length() / a.length() + 2; i++) //starting 1 and ending with maximum 2 repeations is enough 
            if(sb.append(a).toString().contains(b))
                return i;
        return -1;
    }
}