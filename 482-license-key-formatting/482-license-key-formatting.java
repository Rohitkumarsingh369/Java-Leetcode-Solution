class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int count=0;
        S=S.toUpperCase();
        char c;
        StringBuilder sb= new StringBuilder(" ");
        for(int i=S.length()-1;i>=0;i--){
            c=S.charAt(i);
            if(c!='-'){
                if(count==K){
                    sb.append('-');
                    count=0;
                }
                sb.append(c);
                count++;
            }
        }
        return sb.reverse().toString().trim();
    }
}